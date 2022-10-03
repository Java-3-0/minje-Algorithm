import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int oneCnt = 0;
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            PriorityQueue<Integer> pq = plus;
            int input = Integer.parseInt(br.readLine());
            if (input == 1) {
                oneCnt++;
                continue;
            }
            if (input <= 0) {
                pq = minus;
            }
            pq.add(input);
        }

        int ans = 0;
        int tmp = 1;
        int size = plus.size();
        for (int i = 0; i < size; i++) {
            tmp *= plus.poll();
            if (i % 2 == 1) {
                ans += tmp;
                tmp = 1;
            }
        }
        if (size % 2 != 0) {
            ans += tmp;
        }

        tmp = 1;
        size = minus.size();
        for (int i = 0; i < size; i++) {
            tmp *= minus.poll();
            if (i % 2 == 1) {
                ans += tmp;
                tmp = 1;
            }
        }
        if (size % 2 != 0) {
            ans += tmp;
        }

        System.out.println(ans + oneCnt);
    }
}