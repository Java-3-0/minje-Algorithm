import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        boolean isCut[] = new boolean[N];
        Arrays.fill(isCut, false);
        st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i != 0) {
                pq.offer(new int[]{i - 1, arr[i] - arr[i - 1]});
            }
        }

        for (int i = 0; i < K - 1; i++) {
            int cur[] = pq.poll();
            isCut[cur[0]] = true;
        }

        int start = 0;
        long ans = 0L;
        for (int i = 0; i < N; i++) {
            if (isCut[i]) {
                ans += arr[i] - arr[start];
                start = i + 1;
            }
        }
        ans += arr[N - 1] - arr[start];
        System.out.println(ans);
    }
}