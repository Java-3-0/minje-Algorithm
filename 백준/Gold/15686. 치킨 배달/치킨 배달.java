import java.io.*;
import java.util.*;

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M;
    static int map[][];
    static ArrayList<Point> houseList;
    static ArrayList<Point> chickenList;
    static int ans;
    static boolean[] choosed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                if (map[r][c] == 1) {
                    houseList.add(new Point(r, c));
                } else if (map[r][c] == 2) {
                    chickenList.add(new Point(r, c));
                }
            }
        }

        choosed = new boolean[chickenList.size()];
        comb(0, 0);
        System.out.println(ans);
    }

    public static void comb(int cnt, int start){
        if (cnt == M) {
            ans = Math.min(ans, rtChickenD());
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            choosed[i] = true;
            comb(cnt + 1, i + 1);
            choosed[i] = false;
        }
    }

    public static int rtChickenD(){
        int rt = 0;
        for (int i = 0; i < houseList.size(); i++) {
            int minD = Integer.MAX_VALUE;
            for (int j = 0; j < chickenList.size(); j++) {
                if (choosed[j]) {
                    int dist = Math.abs(houseList.get(i).x - chickenList.get(j).x)
                        + Math.abs(houseList.get(i).y - chickenList.get(j).y);

                    minD = Math.min(minD, dist);
                }
            }

            rt += minD;
        }

        return rt;
    }
}

