import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Main {

    static int N;
    static int[] adjList;
    static ArrayList<Integer> ansList = new ArrayList<>();
    static Stack<Integer> stack = new Stack();
    static boolean isVisited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        adjList = new int[N + 1];
        isVisited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                stack.clear();
                dfs(i);
            }
        }

        sb.append(ansList.size()).append("\n");
        Collections.sort(ansList);
        for (Integer a : ansList) {
            sb.append(a).append("\n");
        }

        System.out.println(sb);
    }

    public static boolean dfs(int start) {
        stack.push(start);
        isVisited[start] = true;

        int next = adjList[start];
        if (!isVisited[next] && dfs(next)) {
            return true;
        }
        if (stack.contains(next)) {
            while (!stack.isEmpty()) {
                int top = stack.pop();
                ansList.add(top);
                if (top == next) {
                    break;
                }
            }
            return true;
        }

        stack.pop();
        return false;
    }
}