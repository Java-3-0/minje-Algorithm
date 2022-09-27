import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] isRead = new boolean[N];
        isRead[0] = true;
        int[][] msg = new int[K + 1][2];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            char who = st.nextToken().toCharArray()[0];
            msg[i][0] = cnt;
            msg[i][1] = who - 'A';
        }

        int findCnt = msg[Q][0];
        for (int i = 1; i <= K; i++) {
            if (findCnt <= msg[i][0]) {
                isRead[msg[i][1]] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            if (!isRead[i]) {
                sb.append((char) ('A' + i)).append(" ");
            }
        }

        if (findCnt == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}