import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    //    static final int MAX_N = 1_000_000;
    static int N, M;
    static int[] S;
    static int[][] warningZone;
    static long leftStone, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        leftStone = K = Long.parseLong(st.nextToken());
        warningZone = new int[M][2];
        S = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            warningZone[i] = new int[]{from, to};
        }

        Arrays.sort(warningZone, Comparator.comparingInt((x) -> x[0]));
        if (M != 0 && M != 1) {
            solve();
        }
        System.out.println(leftStone >= 0 ? "YES" : "NO");

    }

    public static void solve() {

        int startCheck = warningZone[0][0];
        int nextStart = warningZone[0][1];

        for (int i = 1; i < M; i++) {
            int cur[] = warningZone[i];
            int minStone = Integer.MAX_VALUE;
            for (int j = nextStart; j <= cur[0]; j++) {
                minStone = Math.min(S[j], minStone);
            }
            leftStone -= minStone;
            nextStart = cur[1];
        }

        int minStone = Integer.MAX_VALUE;
        if (nextStart > startCheck) {
            for (int i = nextStart; i <= N + startCheck; i++) {
                int idx = i % N;
                if (idx == 0) {
                    idx = N;
                }
                minStone = Math.min(S[idx], minStone);
            }
        } else {
            for (int i = nextStart; i <= startCheck; i++) {
                minStone = Math.min(S[i], minStone);
            }
        }

        leftStone -= minStone;
    }
}

