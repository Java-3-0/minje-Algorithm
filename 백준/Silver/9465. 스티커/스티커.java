import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr, dp;
    public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[2][N];
            dp = new int[2][N];
            for (int i = 0; i < 2; i++) {
                Arrays.fill(dp[i], -1);
            }
            for (int r = 0; r < 2; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            int ans = Math.max(dp(1, N - 1), dp(0, N - 1));
            bw.write(ans+"\n");
        }
        bw.flush();
    }

    public static int dp(int r, int c) {
        int nr = r == 0 ? 1 : 0;
        if (c == 0 || dp[r][c] != -1) {
            return dp[r][c];
        }
        if (c == 1) {
            return dp[r][c] = dp(nr, c - 1) + arr[r][c];
        }

        int candMax = Math.max(dp(nr, c - 2), dp(r, c - 2));
        return dp[r][c] = Math.max(dp(nr, c - 1), candMax) + arr[r][c];
    }
}
