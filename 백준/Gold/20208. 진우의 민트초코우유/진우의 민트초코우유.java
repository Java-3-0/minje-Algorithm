import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Position {

    int r;
    int c;

    public Position(int r, int c) {
        this.r = r;
        this.c = c;
    }

}

public class Main {

    static final int HOME = 1;
    static final int MINT = 2;
    static Position homeLoc;
    static int H, ans;
    static boolean[] isVisited;
    static List<Position> mintList = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; c++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == HOME) {
                    homeLoc = new Position(r, c);
                } else if (input == MINT) {
                    mintList.add(new Position(r, c));
                }
            }
        }
        isVisited = new boolean[mintList.size()];
        dfs(homeLoc, 0, M);
        System.out.println(ans);
    }

    public static void dfs(Position start, int score, int hp) {
        if (canGo(start, homeLoc, hp)) {
            ans = Math.max(ans, score);
        }
        for (int i = 0; i < mintList.size(); i++) {
            Position cur = mintList.get(i);
            if (!isVisited[i] && canGo(start, cur, hp)) {
                isVisited[i] = true;
                dfs(cur, score + 1, hp + H - calcDist(start, cur));
                isVisited[i] = false;
            }
        }
    }

    public static boolean canGo(Position from, Position to, int hp) {
        return calcDist(from, to) <= hp;
    }

    public static int calcDist(Position from, Position to) {
        return Math.abs(from.c - to.c) + Math.abs(from.r - to.r);
    }
}

