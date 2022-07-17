import java.io.*;
import java.util.StringTokenizer;

/*
1. 꿀통 가운데 어딘가(arr양 끝을 제외한 Max값) && 벌 양쪽끝
2. 꿀통 오른쪽 끝에 있을때(예제) // 벌1 = 왼쪽 끝 벌2 = 위치 구해줘야함
3. 꿀통 왼쪽 끝에 있을때 // 벌1 = 오른쪽 끝 벌2 = 위치 구해줘야함
 */

public class Main {
    static int[] arr; //배열
    static int[] sum; //누적합
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sum = new int[n];
        int max = Integer.MIN_VALUE; //꿀통 가운데 있을때 사용
        int tmp = 0; // 누적합용
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (i != 0 && i < n - 1)
                max = Math.max(max, input);
            arr[i] = input;
            tmp += arr[i];
            sum[i] = tmp;
        }

        int canCen = sum[n - 1] + max - arr[0] - arr[n - 1];

        // 꿀통 젤 오른쪽
        int prev = 1;
        int bee1 = 1;
        for (int i = 2; i < n - 1; i++) {
            if (arr[prev] > sum[i] - sum[prev] + arr[i]) { //내가 새로 얻는 이익 > 내가 포기하는 얻는 이익
                prev = i;
                bee1 = i;
            }
        }

        int canRight = sum[n - 1] + sum[n - 1] - sum[bee1] - sum[0] - arr[bee1];

        ans = Math.max(canRight, canCen);

        // 꿀통 젤 왼쪽
        int prevL = n - 2;
        int bee2 = n - 2;
        int tmp2 = 0;
        for (int i = n - 3; i >= 1; i--) {
            tmp2 += arr[i];
            if (arr[prevL] > tmp2 + arr[i]) {
                prevL = i;
                bee2 = i;
                tmp2 = 0;
            }
        }
        int canLeft = sum[n - 2] + sum[bee2 - 1] - arr[bee2];
        ans = Math.max(ans, canLeft);
        System.out.println(ans);

    }
}
