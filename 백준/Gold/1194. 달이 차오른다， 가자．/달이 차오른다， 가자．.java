import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] visited;  // 아무열쇠 없 && 방문 = 1(2)  // a열쇠 get && 방문 == 10(2)
    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char input = str.charAt(j);
                map[i][j] = input;
                if (input == '0') {
                    q.offer(new int[]{i, j, 1});
                    visited[i][j] = 1;
                }

            }
        }

        bfs();

        bw.write(String.valueOf(ans));
        bw.flush();

    }

    static void bfs() {

        while (!q.isEmpty()) {
            int qSize = q.size();
            while (--qSize >= 0) {
                int[] cur = q.poll();
                if (map[cur[0]][cur[1]] == '1') return;

                for (int d = 0; d < 4; d++) {
                    int key = cur[2];
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];
                    if (!isValidRange(nr, nc)) continue;

                    char mapCh = map[nr][nc];
                    if (mapCh != '#' && !isVisited(key,visited[nr][nc])) {
                        if (isKey(mapCh)) {
                            key = key | 1 << (mapCh - 'a' + 1);
                        }
                        if (isDoor(mapCh) && !hasDoorKey(mapCh, key)) {
                            continue;
                        }
                        q.offer(new int[]{nr, nc, key});
                        visited[nr][nc] = key;
                    }
                }
            }
            ans++;
        }
        ans = -1;
    }

    static boolean isValidRange(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }

    static boolean isKey(char mapCh) {
        return mapCh >= 'a' && mapCh <= 'f';
    }

    static boolean isDoor(char mapCh) {
        return mapCh >= 'A' && mapCh <= 'F';
    }

    static boolean hasDoorKey(char mapCh, int key) {
        return (key & (1 << (mapCh - 'A' + 1))) > 0;
    }

    static boolean isVisited(int key, int visited) {
        return (key & visited) == key;
    }
}
