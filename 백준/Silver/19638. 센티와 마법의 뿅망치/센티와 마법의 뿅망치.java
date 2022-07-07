import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int N = Integer.parseInt(st.nextToken());
        int centiH = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(br.readLine()));
        }

        while (q.peek() >= centiH) {
            if (cnt == limit) {
                cnt++;
                break;
            }
            cnt++;
            q.offer(hammering(q.poll()));
        }

        sb.append(cnt > limit ? "NO" : "YES");
        sb.append("\n");
        sb.append(cnt > limit ? (int) q.peek() : cnt);
        System.out.println(sb);
    }

    public static int hammering(int x) {
        return x == 1 ? 1 : x >> 1;
    }
}

