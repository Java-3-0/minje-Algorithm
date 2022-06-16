import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K, map[][];
    static boolean visited[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            ans = 0;
            for (int i = 0; i < K; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st1.nextToken());
                int r = Integer.parseInt(st1.nextToken());
                map[r][c] = 1;
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        visited[i][j]=true;
                        dfs(i, j);
                        ans++;
                    }
                }

            }
            bw.write(ans + "\n");
        }
        bw.flush();
    }

    public static void dfs(int r, int c) {

        for (int d = 0; d < 4; d++) {
            int nr = r+ dr[d];
            int nc = c+ dc[d];
            if (!isValidRange(nr, nc)) continue;
            if (map[nr][nc] == 1 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }

    public static boolean isValidRange(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
