import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Flower implements Comparable<Flower> {

    public int floweringDate;
    public int fallingDate;

    public Flower(int floweringDate, int fallingDate) {
        this.floweringDate = floweringDate;
        this.fallingDate = fallingDate;
    }

    @Override
    public int compareTo(Flower o) {
        return o.fallingDate - this.fallingDate;
    }
}

public class Main {

    static int datesSum[] = calcDateCumSum();
    static final int FIN_DATE = convertMonDate2Date(11, 30);
    static final int ST_DATE = convertMonDate2Date(3, 1);
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Flower[] flowerList = new Flower[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int flowerMonth = Integer.parseInt(st.nextToken());
            int flowerDate = Integer.parseInt(st.nextToken());
            int fallMonth = Integer.parseInt(st.nextToken());
            int fallDate = Integer.parseInt(st.nextToken());
            flowerList[i] = new Flower(convertMonDate2Date(flowerMonth, flowerDate),
                convertMonDate2Date(fallMonth, fallDate));
        }

        Arrays.sort(flowerList);

        int curFall = ST_DATE;
        while (curFall <= FIN_DATE) { //flower list => 지우면서할까? 링크드리스트 있자나
            boolean flag = true;
            for (Flower flower : flowerList) {
                if (flower.floweringDate <= curFall && flower.fallingDate > curFall) {
                    curFall = flower.fallingDate;
                    ans++;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = 0;
                break;
            }
        }

        System.out.println(ans);
    }

    private static int convertMonDate2Date(int mon, int date) {
        return datesSum[mon - 1] + date;
    }

    private static int[] calcDateCumSum() {
        int[] datesMonth = new int[13];
        for (int i = 1; i <= 12; i++) {
            datesMonth[i] = datesMonth[i - 1] + getNumDays(i);
        }
        return datesMonth;
    }

    private static int getNumDays(int month) {
        int numDays = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            case 2:
                numDays = 28;
                break;
        }
        return numDays;
    }
}
