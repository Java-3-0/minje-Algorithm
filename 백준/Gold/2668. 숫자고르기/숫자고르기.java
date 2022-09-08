import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    static int N;
    static int[] adjList;
    static ArrayList<Integer> ansList = new ArrayList<>();
    static boolean isVisited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adjList = new int[N + 1];
        isVisited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                ArrayList<Integer> visitedList = new ArrayList<>();
                if (dfs(i, visitedList)) {
                    ansList.addAll(visitedList);
                }
            }
        }

        System.out.println(ansList.size());
        ansList.sort(Comparator.comparingInt(a -> a));
        for (Integer a : ansList) {
            System.out.println(a);
        }
    }

    public static boolean dfs(int start, ArrayList<Integer> visitedList) {
        visitedList.add(start);
        isVisited[start] = true;

        int next = adjList[start];
        if (!isVisited[next] && dfs(next, visitedList)) {
            return true;
        }
        if (visitedList.contains(next)) {
            for (int i = visitedList.indexOf(next) - 1; i >= 0; i--) {
                visitedList.remove(i);
            }
            return true;
        }

        visitedList.remove(visitedList.size()-1);
        return false;
    }
}
