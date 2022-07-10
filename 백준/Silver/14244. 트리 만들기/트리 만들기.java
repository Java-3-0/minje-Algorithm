import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            if (i > N - M) {
                bw.write(Integer.toString(N - M));
            } else {
                bw.write(Integer.toString(i - 1));
            }
            bw.write(" ");
            bw.write(Integer.toString(i));
            bw.write("\n");
        }
        bw.flush();
    }
}
