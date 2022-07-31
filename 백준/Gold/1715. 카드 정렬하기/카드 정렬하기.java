import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            int a = pq.poll();
            if (pq.isEmpty()) {
                break;
            }
            int b = pq.poll();
            ans += a + b;
            pq.offer(a + b);
        }

        System.out.println(ans);
    }
}