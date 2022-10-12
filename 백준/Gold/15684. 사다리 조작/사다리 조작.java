import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] hasLine;
    static int N, M, H, ans;
    static int[] picked = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        hasLine = new boolean[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int hor = Integer.parseInt(st.nextToken());
            int vert = Integer.parseInt(st.nextToken());
            hasLine[hor][vert] = true;
        }

        for (int i = 0; i <= 3; i++) {
            dfs(0, i);
        }

        System.out.println("-1");
    }

    public static void dfs(int cnt, int num) {
        if (num == cnt) {
            if (check()) {
                System.out.println(cnt);
                System.exit(0);
            }
            return;
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (hasLine[i][j] == true || hasLine[i][j - 1] == true
                    || hasLine[i][j + 1] == true) {
                    continue;
                }
                hasLine[i][j] = true;
                dfs(cnt + 1, num);
                hasLine[i][j] = false;
            }
        }
    }

    public static boolean check() {
        for (int i = 1; i <= N; i++) {
            int col = i;
            for (int h = 1; h <= H; h++) {
                if (hasLine[h][col]) {
                    col++;
                } else if (hasLine[h][col - 1]) {
                    col--;
                }
            }

            if (col != i) {
                return false;
            }
        }

        return true;
    }
}

