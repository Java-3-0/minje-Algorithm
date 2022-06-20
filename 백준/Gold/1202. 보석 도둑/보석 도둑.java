import java.io.*;
import java.util.*;

// N , K 입력받고
// 보석 c최대 N 까지 입력받는다 PQ에 넣기 무게 1순위 // 이후 무게가 지금 나온 가방 무게보다 낮을때까지 pq 빼서 가격이 2순위 정렬해서 더해주기
// 무게 기준으로 pq 정렬

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long ans = 0;
        PriorityQueue<int[]> diaQ = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        PriorityQueue<Integer> bpQ = new PriorityQueue<>();
        PriorityQueue<Integer> tmpQ = new PriorityQueue<>(
            (Integer x, Integer y) -> x >= y ? -1 : 1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            diaQ.offer(
                new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        for (int i = 0; i < K; i++) {
            String bpW = br.readLine();
            bpQ.offer(Integer.parseInt(bpW));
        }

        while (!bpQ.isEmpty()) {
            while (!diaQ.isEmpty() && diaQ.peek()[0] <= bpQ.peek()) { // 그 가방에 들어갈 수 있는 다이아 다뽑기
                tmpQ.offer(diaQ.poll()[1]);
            }

            bpQ.poll();
            if(!tmpQ.isEmpty()) {
                ans += (long) tmpQ.poll(); // 가방에 하나 담아가자
            }
        }

        System.out.println(ans);
    }
}
