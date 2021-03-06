import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long arr[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N][2]; //마을위치, 마을 사람수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new long[]{Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())};
        }

        Arrays.sort(arr, Comparator.comparingLong(x -> x[0]));

        long left = -1_000_000_000;
        long right = 1_000_000_000;
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (calc(mid) < calc(mid + 1)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
 
        if (calc(ans) >= calc(ans - 1)) {
            System.out.println(ans - 1);
        } else {
            System.out.println(ans);
        }
    }

    public static long calc(long mid) {
        long d = 0;
        for (int i = 0; i < N; i++) {
            d += Math.abs(arr[i][0] - mid) * arr[i][1];
        }
        return d;
    }
}