import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[][] map;
    static boolean[][] isVisited;
    static int M;
    static int N;
    static Queue<int[]> q = new LinkedList<>();
    static final int[] dr = new int[]{-1, 1, 0, 0};
    static final int[] dc = new int[]{0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        map = new int[m][n];
        isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = picture[i].clone();
        }

        int numberOfArea = 0;
        int maxSizeOfOneArea = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 && !isVisited[i][j]) {
                    q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    isVisited[i][j] = true;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(map[i][j]));
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int bfs(int color) {
        int rtArea = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (isValidRange(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == color) {
                    rtArea++;
                    isVisited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return rtArea;
    }

    public static boolean isValidRange(int nr, int nc) {
        return M > nr && nr >= 0 && nc >= 0 && nc < N;
    }
}