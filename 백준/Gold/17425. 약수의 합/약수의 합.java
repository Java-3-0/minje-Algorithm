import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static long cache[] = new long[1_000_001];
    static long sum[] = new long[1_000_001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 1_000_000; i++) {
            for (int j = 1; i * j <= 1_000_000; j++) {
                cache[i * j] += j;
            }
        }
        long tmp = 0;
        for (int i = 1; i <= 1_000_000; i++) {
            tmp += cache[i];
            sum[i] = tmp;
        }

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(sum[N]).append("\n");
        }
        System.out.println(sb);
    }
}