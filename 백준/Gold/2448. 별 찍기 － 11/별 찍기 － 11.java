import java.io.*;

public class Main {
    static String[][] stars;
    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stars = new String[N][2];
        stars[0][0] = "  *  ";
        stars[1][0] = " * * ";
        stars[2][0] = "*****";

        rec(0, 3);

        for (int i = 0; i < N; i++) {
            bw.write(stars[i][0]);
            bw.write("\n");
        }
        bw.flush();
    }


    public static void rec(int start, int end) {
        for (int i = start; i < end; i++) {
            StringBuilder sb = new StringBuilder();
            if (start == 0) {
                sb.append(stars[i - start][0]);
            } else {
                sb.append(stars[i - start][0]).append(" ").append(stars[i - start][0]);
            }
            stars[i][0] = sb.toString();
        }

        update(start);

        if (end == N) {
            return;
        }
        rec(end, end * 2);
    }

    public static void update(int start) {
        int offset = start;
        for (int i = 0; i < start; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < offset; j++) {
                sb.append(" ");
            }
            stars[i][1] = Integer.toString(offset);
            sb.append(stars[i][0]);
            for (int j = 0; j < offset; j++) {
                sb.append(" ");
            }
            stars[i][0] = sb.toString();
        }
    }
}