import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, -1, 1};
    static int R, C, dustNum;
    static char[][] map;
    static int[][] visited; // 미방문  = 0(2), 먼지 치우지않음 & 방문 = 1(2), 1번째 먼지 치움 & 방문 = 10(2)
    static Queue<int[]> q;  // {r,c,mask}
    static HashMap<Integer, Integer> dustMap; // for dust masking {dust x, dust y, dust idx}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            if (checkEnd()) {
                break;
            }
            visited = new int[R][C];
            map = new char[R][C];
            q = new LinkedList<>();
            dustMap = new HashMap<>();
            dustNum = 0;
            for (int i = 0; i < R; i++) {
                char[] line = br.readLine().toCharArray();
                for (int j = 0; j < C; j++) {
                    if (line[j] == 'o') {
                        q.offer(new int[]{i, j, 1});
                        visited[i][j] = 1;
                    } else if (line[j] == '*') {
                        dustNum++;
                        dustMap.put(i * C + j, dustNum);
                    }
                    map[i][j] = line[j];
                }
            }

            bw.write(bfs() + "\n");
        }
        bw.flush();
    }

    public static int bfs() {
        int ans = 0;
        if(dustNum==0) return ans;
        while (!q.isEmpty()) {
            ans++;
            int qSize = q.size();
            while (--qSize >= 0) {
                int cur[] = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];
                    int mask = cur[2];
                    if (isValidRange(nr, nc) && !isVisited(mask, visited[nr][nc])
                        && map[nr][nc] != 'x') {
                        if (map[nr][nc] == '*') {
                            mask = mask | (1 << dustMap.get(nr * C + nc));
                            
                            if (mask == (1 << (dustNum + 1)) - 1) {
                                return ans;
                            }
                        }
                        q.offer(new int[]{nr, nc, mask});
                        visited[nr][nc] = mask;
                    }
                }
            }
        }

        return -1;
    }

    public static boolean isVisited(int mask, int visited) {
        return (visited & mask) == mask;
    }

    public static boolean isValidRange(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    public static boolean checkEnd() {
        return R == 0 && C == 0;
    }
}
