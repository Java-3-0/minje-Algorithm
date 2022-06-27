import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int hill = -1;
        for (int i = N - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                hill = i;
                break;
            }
        }

        if (hill == -1) {
            System.out.println(-1);
            return;
        }
        int tmpMax = 0;
        int idx = -1;
        for (int i = N - 1; i >= hill; i--) {
            if (arr[hill - 1] > arr[i]) {
                if (tmpMax < arr[i]) {
                    tmpMax = arr[i];
                    idx = i;
                }
            }
        }
        swap(arr, idx, hill - 1);

        //todo: 스왑 뒷지점 내림차순으로
        for (int i = 1; i <= (N - hill) / 2; i++) {
            if (arr[N - i] > arr[N - i - 1]) {
                swap(arr, N - i, hill + i - 1);
            }
        }
        print(arr);
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;
    }

    static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}

