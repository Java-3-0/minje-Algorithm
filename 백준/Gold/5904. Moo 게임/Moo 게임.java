import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char ans;
    static int dp[] = new int[30];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        dp[0] = 3;
        solve(N);
        System.out.println(ans);
    }

    public static void solve(int N) {
        int idx = 0;
        while (dp[idx] < N) {
            idx++;
            dp[idx] = dp[idx - 1] * 2 + idx + 3;
        }
        if (idx == 0) {
            if (N == 1) {
                ans = 'm';
            } else {
                ans = 'o';
            }
        } else if (dp[idx - 1] + idx + 3 < N) {
            solve(N - (dp[idx - 1] + idx + 3));
        } else if (dp[idx - 1] < N) {
            if (N == dp[idx - 1] + 1) {
                ans = 'm';
            } else {
                ans = 'o';
            }
        }
    }
}

