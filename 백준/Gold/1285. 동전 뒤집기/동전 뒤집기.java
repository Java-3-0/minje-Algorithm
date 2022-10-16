import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        // 주어진 값 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == 'T') {
                    map[i][j] = 1;
                }
            }
        }

        int ans = 400;
        // 행을 뒤집을 것인가 뒤집지 않을 것인가를 비트마스크로 결정
        // n=3일 때, 예를 들어 001 이라면 3번째 행만 뒤집는다는 의미이다.
        for (int bit = 0; bit <= (1 << n) - 1; bit++) {
            int sum = 0;

            // 현재 비트값에 대해 모든 열에서 탐색 수행
            for (int x = 0; x < n; x++) {
                int tail = 0;

                // 각 열의 행을 뒤집거나 뒤집지 않거나 수행
                for (int y = 0; y < n; y++) {
                    int cur = map[y][x];
                    // 뒤집는다.(비트가 1이면)
                    if ((bit & (1 << y)) != 0) {
                        cur = flip(y, x);
                    }
                    // tail의 수를 찾는다.
                    if (cur == 1) {
                        tail++;
                    }
                }
                // 열을 뒤집거나 뒤집지 않거나의 경우를 상정하여 더 작은 경우를 더함!
                sum += Math.min(tail, n - tail);
            }
            if (ans > sum) {
                ans = sum;
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static int flip(int y, int x) {
        return map[y][x] ^ 1;
    }
}