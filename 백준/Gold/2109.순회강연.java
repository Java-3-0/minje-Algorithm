import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static PriorityQueue<Integer> pq;
    static ArrayList<Integer>[] lectureList = new ArrayList[10001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 10000; i++) {
            lectureList[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lectureList[d].add(p);
        }

        int ans = 0;
        int time = 10000;
        while (time > 0) {
            pq.addAll(lectureList[time]);
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
            time--;
        }

        System.out.println(ans);
    }
}
