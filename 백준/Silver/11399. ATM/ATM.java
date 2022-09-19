import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] pI = new int[N];
        for (int i = 0; i < N; i++) {
            pI[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pI);

        int ans = 0;

        for (int i = 0; i < N; i++) {
            ans += pI[i] * (N - i);
        }
        System.out.println(ans);
    }
}

