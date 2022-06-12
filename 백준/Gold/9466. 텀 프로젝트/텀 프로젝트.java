import java.io.*;
import java.util.*;

public class Main {
    public static int adjList[];
    public static HashSet<Integer> teamMSet;
    public static boolean[] isVisited;
    public static int N, ans;
    public static ArrayList<Integer> tmpList;
    public static HashMap<Integer, Integer> tmpMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            ans = N = Integer.parseInt(br.readLine());
            adjList = new int[N];
            isVisited = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int hope = (Integer.parseInt(st.nextToken())) - 1;
                if (c == hope) {
                    ans--;
                    isVisited[c] = true;
                }
                adjList[c] = hope;
            }

            for (int i = 0; i < N; i++) {
                if (isVisited[i]) continue;
                tmpList = new ArrayList<>();
                tmpMap = new HashMap<>();
                check(i);
            }

            bw.write(ans + "\n");
        }
        bw.flush();
    }

    public static void check(int n) {
        if (tmpMap.get(n) != null) {
            ans = ans - (tmpList.size()-tmpMap.get(n));
            return;
        }
        if(isVisited[n]) return;
        tmpMap.put(n, tmpList.size());
        tmpList.add(n);
        isVisited[n] = true;
        check(adjList[n]);
    }
}
