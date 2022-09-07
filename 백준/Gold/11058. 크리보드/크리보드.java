import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static long[] dp = new long[102];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (i <= 6) {
                dp[i] = i;
                continue;
            }
            for (int j = 3; i - j > 0; j++) {
                dp[i] = Math.max(dp[i - j] * (j - 1), dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}
