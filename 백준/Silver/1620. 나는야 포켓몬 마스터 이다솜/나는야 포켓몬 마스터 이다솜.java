import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameMap = new HashMap<>();
        HashMap<Integer, String> idxMap = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < n + 1; i++) {
            String name = br.readLine();
            nameMap.put(name, i);
            idxMap.put(i,name);
        }

        for (int i = 0; i < m; i++) {
            String findStr = br.readLine();
            if(isStringNumber(findStr)) { // 숫자(인덱스)를 입력받은 경우
                int index = Integer.parseInt(findStr);
                sb.append(idxMap.get(index));
            }
            else {	// 문자를 입력받은 경우
                sb.append(nameMap.get(findStr));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static boolean isStringNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
