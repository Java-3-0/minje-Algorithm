import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Date implements Comparable<Date> {

    int start;
    int end;

    public Date(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Date o) {
        if (this.start == o.start) {
            return o.end - this.end;
        }

        return this.start - o.start;
    }
}

public class Main {

    static boolean[][] plan = new boolean[1000][366];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Date> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Date(start, end));
        }

        while (!pq.isEmpty()) {
            Date cur = pq.poll();

            for (int i = 0; i < 1000; i++) {
                if (plan[i][cur.start]) {
                    continue;
                }

                for (int j = cur.start; j <= cur.end; j++) {
                    plan[i][j] = true;
                }
                break;
            }
        }

        int width = 0;
        int rectH = 0;
        int ans = 0;
        for (int j = 0; j < 366; j++) {
            int height = hasPlan(j);
            if (height != -1) {  //일정이 있다.
                width++;
                rectH = Math.max(rectH, height + 1);
            }
            if (height == -1 || j == 365) {
                ans += width * rectH;
                width = 0;
                rectH = 0;
            }
        }
        System.out.println(ans);
    }

    //찾으면 height, 없으면 -1 리턴
    public static int hasPlan(int day) {
        int rt = -1;
        for (int i = 0; i < 1000; i++) {
            if (plan[i][day]) {
                rt = Math.max(rt, i);
            }
        }
        return rt;
    }
}