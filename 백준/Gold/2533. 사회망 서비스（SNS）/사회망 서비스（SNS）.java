import java.util.*;
import java.io.*;

public class Main {
    static int N, ans;
    static List<Integer>[] tree;
    static boolean[] isEarlyAd;
    static boolean[] isDetermined;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        isEarlyAd = new boolean[N + 1];
        isDetermined = new boolean[N + 1];

        StringTokenizer st;

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            tree[parent].add(child);
            tree[child].add(parent);
        }

        isEA(1);


        System.out.println(ans);
    }

    public static boolean isEA(int node) {  // node가 얼리 어댑터여야하는가
        isDetermined[node] = true;
        boolean flag = false;
        for (int i = 0; i < tree[node].size(); i++) {
            int next = tree[node].get(i);
            if (!isDetermined[next] && !isEA(next)) {
                isEarlyAd[node] = true;
                flag = true;
            }
        }

        if(flag) ans++;
        return flag;
    }

}
