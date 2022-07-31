import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        dp = new int[N][2];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 1);
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) { //증가중
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                } else if (arr[i] < arr[j]) { // 감소중
                    dp[i][1] = Math.max(dp[j][1] + 1, dp[i][1]);
                    dp[i][1] = Math.max(dp[j][0] + 1, dp[i][1]);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            ans = Math.max(dp[i][0], ans);
            ans = Math.max(dp[i][1], ans);
        }
        System.out.println(ans);
    }
}