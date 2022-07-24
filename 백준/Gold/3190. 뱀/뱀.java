import java.util.*;
import java.io.*;

public class Main {

    static int N, d, time;
    // 우, 하, 좌, 상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static Queue<int[]> cmd = new LinkedList<>(); // time , dir
    static boolean[][] isSnakeExist;
    static boolean[][] isAppleExist;
    static Deque<int[]> snake = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        isSnakeExist = new boolean[N][N];
        isAppleExist = new boolean[N][N];
        snake.add(new int[]{0, 0});
        isSnakeExist[0][0] = true;
        d = 0;
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            isAppleExist[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken())
                - 1] = true;
        }
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cmd.add(
                new int[]{Integer.parseInt(st.nextToken()), st.nextToken().equals("L") ? -1 : 1});
        }

        //1. 뱀 d 방향으로 전진
        //2. 새로운방향 snake에 추가
        //3. snake 있거나 벽인지 체크 -> O , die 끝 / x , 계속
        //3. 사과있?
        // 있다. ->  할거 없슴
        // 없다. -> 꼬리 짜르기 이전 snake = false'

        do {
            if (!cmd.isEmpty() && cmd.peek()[0] == time) {
                d = (4 + d + cmd.peek()[1]) % 4;
                cmd.poll();
            }
            int head[] = snake.getFirst();
            int nr = head[0] + dr[d];
            int nc = head[1] + dc[d];
            if (isEnd(nr, nc)) {
                break;
            }
            isSnakeExist[nr][nc] = true;
            if (isAppleExist[nr][nc]) {
                isAppleExist[nr][nc] = false;
            } else {
                int tail[] = snake.getLast();
                isSnakeExist[tail[0]][tail[1]] = false;
                snake.pollLast();
            }
            snake.addFirst(new int[]{nr, nc});
            time++;
        } while (true);

        System.out.println(time+1);
    }

    public static boolean isEnd(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= N || nc >= N || isSnakeExist[nr][nc];
    }
}