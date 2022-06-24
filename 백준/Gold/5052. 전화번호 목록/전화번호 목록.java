import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        LOOP:
        for (int tc = 0; tc < T; tc++) {
            if (tc != 0) {
                sb.append("\n");
            }
            int N = Integer.parseInt(br.readLine());
            String[] str = new String[N];
            for (int i = 0; i < N; i++) {
                str[i] = br.readLine();
            }
            Arrays.sort(str);

            for (int i = 0; i < N - 1; i++) {
                if (str[i].length() < str[i + 1].length()) {
                    if (str[i].equals(str[i + 1].substring(0, str[i].length()))) {
                        sb.append("NO");
                        continue LOOP;
                    }
                }
            }
            sb.append("YES");
        }

        System.out.println(sb);
    }
}

