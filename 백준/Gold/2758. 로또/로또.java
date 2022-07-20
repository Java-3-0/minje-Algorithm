import java.util.*;
import java.io.*;

public class Main {

    static long[][] dp = new long[11][2001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < 11; i++) {
            Arrays.fill(dp[i], -1L);
        }
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long ans = 0L;
            for (int i = (1 << (n - 1)); i <= m; i++) {
                ans += calc(n, i);
            }

            System.out.println(ans);
        }
    }

    public static long calc(int n, int m) {
        if (n == 1) {
            return 1;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        long sum = 0;
        for (int i = (1 << (n - 2)); i <= m / 2; i++) {
            sum += calc(n - 1, i);
        }
        return dp[n][m] = sum;
    }
}