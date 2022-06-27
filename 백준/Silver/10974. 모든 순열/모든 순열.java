import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }
        print(arr);

        LOOP:
        while (true) {

            int hill = -1;
            for (int i = N - 1; i > 0; i--) {
                if (arr[i] > arr[i - 1]) {
                    hill = i;
                    break;
                }
            }

            if (hill == -1) {
                break LOOP;
            }
            for (int i = N - 1; i >= hill; i--) {
                if (arr[hill - 1] < arr[i]) {
                    swap(arr, i, hill - 1);
                    break;
                }
            }

            for (int i = 1; i <= (N - hill) / 2; i++) {
                if (arr[N - i] < arr[N - i - 1]) {
                    swap(arr, N - i, hill + i - 1);
                }
            }
            print(arr);
        }
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

