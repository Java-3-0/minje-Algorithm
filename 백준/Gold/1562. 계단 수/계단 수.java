import java.io.*;
import java.util.*;

public class Main {
    static final int DIVISOR = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long ans = 0;

        ans += solve(N);


        System.out.println(ans);
    }

    public static long solve(int N) {
        long[][][] dp = new long[N + 1][10][1 << 10];

        for (int i = 0; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1 << 10; k++) {
                    long prev = dp[i][j][k] % DIVISOR;
                    if (prev == 0) continue;
                    if (j != 0) {
                        dp[i + 1][j - 1][k | (1 << (j - 1))] = (dp[i + 1][j - 1][k | (1 << (j - 1))] + prev) % DIVISOR;
                    }
                    if (j != 9) {
                        dp[i + 1][j + 1][k | (1 << (j + 1))] = dp[i + 1][j + 1][k | (1 << (j + 1))] + prev % DIVISOR;
                    }

                }

            }
        }
        long ans = 0;
        for (int j = 1; j < 10; j++) {
            ans = (ans + dp[N][j][(1 << 10) - 1]) % DIVISOR;
        }
        return ans;
    }

}
