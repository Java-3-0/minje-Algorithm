import java.io.*;
import java.util.*;

public class Main {

    static Map<String, String> map;
    static Map<String, Integer> scoreMap;
    static int score;

    static {
        map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        scoreMap = new HashMap<>();
        scoreMap.put("(", 2);
        scoreMap.put("[", 3);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Stack<Object> stack = new Stack<>();

        String[] input = bufferedReader.readLine().split("");
        boolean flag = false;

        for (String ch : input) {
//            1. 여는괄호
//            그냥 넣기
//            tmp score = 0;
//            2. 닫는괄호
//            while (스택 peek 숫자가 아닐떄까지){
//                숫자면 tmpscore +더해서
//            }
//            if (tmpscore == 0) {
//                tmpscore = 1
//            }
//            tmpscore + scoreMap 배수
            if (map.containsKey(ch)) {   // 닫는 괄호
                Integer offset = 0;
                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    offset += (Integer) stack.pop();
                }
                if (!stack.isEmpty() && map.get(ch).equals(stack.peek())) {
                    stack.push(updateScore((String) stack.pop(), offset));
                } else {
                    flag = true;
                    break;
                }
            } else {
                stack.push(ch);
            }
        }

        int score = 0;
        while (!stack.isEmpty() && stack.peek() instanceof Integer) {
            score += (Integer) stack.pop();
        }
        if(flag || !stack.isEmpty()) {
            System.out.println("0");
        }else {
            System.out.println(score);
        }
    }

    public static Integer updateScore(String poppedOne, Integer offset) {
        if (offset == 0) {
            offset++;
        }
        return offset * scoreMap.get(poppedOne);
    }
}

