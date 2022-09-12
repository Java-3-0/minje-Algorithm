import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static long N, P, Q;
    static HashMap<Long, Long> dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        dp = new HashMap<>();
        dp.put(0L, 1L);
        System.out.println(solve(N));

    }

    public static long solve(long n) {
        long cand = dp.getOrDefault(n,-1L);
        if (cand == -1L) {
            long val = solve(Math.floorDiv(n, P)) + solve(Math.floorDiv(n, Q));
            dp.put(n,val);
            return val;
        }

        return cand;
    }
}
