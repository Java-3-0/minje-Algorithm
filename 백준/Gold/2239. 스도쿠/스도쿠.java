import java.io.*;

public class Main {
    static int[][] squareCheck = new int[3][3];
    static int[] rowCheck = new int[9];
    static int[] colCheck = new int[9];
    static int[][] map = new int[9][9];
    static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                int input = Integer.parseInt(inputs[j]);
                map[i][j] = input;
                squareCheck[i / 3][j / 3] |= (1 << input);
                rowCheck[i] |= (1 << input);
                colCheck[j] |= (1 << input);
            }
        }
        dfs();
    }

    public static void dfs() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0) { // check 해보자
                    for (int k = 1; k <= 9; k++) {
                        if (canPlaceN(i, j, k)) {
                            place(i, j, k);
                            dfs();
                            if(flag) break;
                            reset(i, j, k);
                        }
                    }
                    return;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
        flag = true;
        return;
    }

    public static void place(int r, int c, int n) {
        map[r][c] = n;
        squareCheck[r / 3][c / 3] |= 1 << n;
        rowCheck[r] |= 1 << n;
        colCheck[c] |= 1 << n;
    }

    public static void reset(int r, int c, int n) {
        map[r][c] = 0;
        squareCheck[r / 3][c / 3] ^= 1 << n;
        rowCheck[r] ^= 1 << n;
        colCheck[c] ^= 1 << n;
    }

    public static boolean canPlaceN(int r, int c, int n) {
        if (checkInput(squareCheck[r / 3][c / 3], n) && checkInput(colCheck[c], n) && checkInput(rowCheck[r], n)) {
            return true;
        }
        return false;
    }

    public static boolean checkInput(int checkSum, int input) {
        return (checkSum & (1 << input)) == 0;
    }
}