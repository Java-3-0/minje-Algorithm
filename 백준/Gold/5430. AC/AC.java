import java.io.*;
import java.util.*;

public class Main {

    static boolean isRev;
    static Deque<Integer> dq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        LOOP:
        for (int tc = 0; tc < T; tc++) {
            String[] cl = br.readLine().split("");
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.substring(1, str.length() - 1);
            StringTokenizer st = new StringTokenizer(str, ",");

            dq = new ArrayDeque<>();
            isRev = false;
            for (int i = 0; i < N; i++) {
                int input = Integer.parseInt(st.nextToken());
                dq.offer(input);
            }

            for (String s : cl) {
                if (!doAc(s)) {
                    bw.write("error\n");
                    continue LOOP;
                }
            }
            bw.write(rtAns());
        }
        bw.flush();
    }

    public static boolean doAc(String s) {
        if (s.equals("R")) {
            isRev = !isRev;
        } else if (s.equals("D")) {
            if (dq.isEmpty()) {
                return false;
            }
            if (isRev) {
                dq.pollLast();
            } else {
                dq.pollFirst();
            }
        }
        return true;
    }

    public static String rtAns() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int dqSize = dq.size();
        if(dqSize==0) sb.append("]\n");
        for (int i = 0; i < dqSize; i++) {
            int num;
            if (isRev) {
                num = dq.pollLast();
            } else {
                num = dq.pollFirst();
            }
            sb.append(num);
            if (i != dqSize - 1) {
                sb.append(",");
            } else {
                sb.append("]\n");
            }
        }

        return sb.toString();
    }
}
