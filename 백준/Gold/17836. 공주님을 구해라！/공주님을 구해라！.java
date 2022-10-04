import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {

    int r;
    int c;
    boolean hasGram;

    public Position(int r, int c, boolean hasGram) {
        this.r = r;
        this.c = c;
        this.hasGram = hasGram;
    }
}

public class Main {

    static int M, N, T, time;
    static int map[][];
    static Queue<Position> q = new LinkedList<>();
    static boolean isVisited[][][];
    static final int[] dr = new int[]{-1, 1, 0, 0};
    static final int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited[0][0][0] = true;
        q.offer(new Position(0, 0, false));

        while (T >= time && !q.isEmpty()) {
            int qSize = q.size();
            while (qSize-- > 0) {
                Position cur = q.poll();
                if (cur.r == N - 1 && cur.c == M - 1) {
                    System.out.println(time);
                    return;
                }
                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (isValidRange(nr, nc) && !isVisited[nr][nc][cur.hasGram ? 1 : 0]) {
                        if (!cur.hasGram) {
                            if (map[nr][nc] == 2) {
                                isVisited[nr][nc][0] = true;
                                q.offer(new Position(nr, nc, true));
                            } else if (map[nr][nc] != 1) {
                                isVisited[nr][nc][0] = true;
                                q.offer(new Position(nr, nc, false));
                            }
                        } else {
                            isVisited[nr][nc][1] = true;
                            q.offer(new Position(nr, nc, true));
                        }
                    }
                }
            }
            time++;
        }

        System.out.println("Fail");
    }

    public static boolean isValidRange(int nr, int nc) {
        return N > nr && nr >= 0 && nc >= 0 && nc < M;
    }
}

