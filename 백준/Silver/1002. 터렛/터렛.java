import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = Math.abs(x1 - x2);
            int dy = Math.abs(y1 - y2);

            int d = dx * dx + dy * dy;

            if (d == 0 && r1 == r2) {
                bw.write("-1\n");
            } else if (d > (r1 + r2) * (r1 + r2) || d < (r2 - r1) * (r2 - r1)) {
                bw.write("0\n");
            } else if (d == (r2 - r1) * (r2 - r1) && d != 0) {
                bw.write("1\n");
            } else if (d == (r1 + r2) * (r1 + r2)) {
                bw.write("1\n");
            } else bw.write("2\n");
        }

        bw.flush();
    }
}
