import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static String str;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
//            sb.append(st.nextToken());
            sb.append(br.readLine());
        }
        str = sb.toString();
        int left = 0;
        int right = str.length() - 1;

        StringBuilder ans = new StringBuilder();
        while (left <= right) {
            if (selectPop(left, right) < 0) {
                ans.append(str.charAt(left++));
            } else {
                ans.append(str.charAt(right--));
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(ans.charAt(i));
            if (i != 0 && ((i + 1) % 80) == 0) {
                bw.write("\n");
            }
        }
        bw.flush();
    }

    public static int selectPop(int left, int right) {
        if (str.charAt(left) < str.charAt(right)) {
            return -1;
        } else if (str.charAt(left) > str.charAt(right)) {
            return 1;
        } else {
            int l2 = left, r2 = right;
            while (l2 <= r2) {
                if (str.charAt(l2) < str.charAt(r2)) {
                    return -1;
                } else if (str.charAt(l2) > str.charAt(r2)) {
                    return 1;
                } else {
                    l2++;
                    r2--;
                }
            }
            return -1;
        }
    }
}

