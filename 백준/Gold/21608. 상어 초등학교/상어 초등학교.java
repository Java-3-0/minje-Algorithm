import java.util.*;
import java.io.*;

class Cell {
    static final int EMPTY_STATUS = -1;
    public int studentId;
    public Map<Integer, Integer> likeStdCntMap = new HashMap<>();
    public int nearEmptyCnt;

    public boolean isEmpty() {
        return studentId == EMPTY_STATUS;
    }

    Cell(Map<Integer, int[]> studentMap) {
        this.studentId = EMPTY_STATUS;
        this.nearEmptyCnt = -1;
        studentMap.forEach((k, v) -> {
            this.likeStdCntMap.put(k, 0);
        });
    }

    @Override
    public String toString() {
        return "학생 :" + studentId;
    }

    public int compare(Cell o, int stdId) {
        if (likeStdCntMap.get(stdId) > o.likeStdCntMap.get(stdId)) {
            return 1;
        } else if (likeStdCntMap.get(stdId) == o.likeStdCntMap.get(stdId)) {
            return this.nearEmptyCnt > o.nearEmptyCnt ? 1 : -1;
        } else
            return -1;
    }
}

public class Main {
    static int N;
    static final int dr[] = {1, 0, -1, 0};
    static final int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Map<Integer, int[]> studentMap = new LinkedHashMap<>();  // {학생번호 : 좋아하는 학생번호 List}
        Cell[][] map = new Cell[N][N]; // N x N 좌석

        for (int r = 0; r < N * N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int key = Integer.parseInt(st.nextToken());
            int[] value = new int[4];
            for (int c = 0; c < 4; c++) {
                value[c] = Integer.parseInt(st.nextToken());
            }
            studentMap.put(key, value);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new Cell(studentMap);
            }
        }
        initEmptyCnt(map);

        studentMap.forEach((key, value) -> {
            Cell cand = new Cell(studentMap);
            int[] candLoc = new int[2];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].isEmpty() && map[i][j].compare(cand, key) > 0) {
                        cand = map[i][j];
                        candLoc = new int[]{i, j};
                    }
                }
            }
            cand.studentId = key;

            for (int d = 0; d < 4; d++) {
                int nr = candLoc[0] + dr[d];
                int nc = candLoc[1] + dc[d];
                if (isValidRange(nr, nc)) {
                    map[nr][nc].nearEmptyCnt--;

                    studentMap.forEach((k1, v1) -> {
                        for (int std : v1) {
                            if (key == std) {
                                map[nr][nc].likeStdCntMap.put(k1, map[nr][nc].likeStdCntMap.get(k1) + 1);
                            }
                        }
                    });
                }
            }
        });


        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int favoriteStdCnt = map[i][j].likeStdCntMap.get(map[i][j].studentId);
                if (favoriteStdCnt != 0)
                    ans += Math.pow(10, favoriteStdCnt - 1);
            }
        }
        System.out.println(ans);
    }

    public static boolean isValidRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static void initEmptyCnt(Cell[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int emptyCnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (isValidRange(nr, nc) && map[nr][nc].isEmpty()) {
                        emptyCnt++;
                    }
                }
                map[i][j].nearEmptyCnt = emptyCnt;
            }
        }
    }
}
