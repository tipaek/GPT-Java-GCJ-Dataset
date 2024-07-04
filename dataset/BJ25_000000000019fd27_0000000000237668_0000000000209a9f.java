import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        int caseNum = 1;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for(int i = 0; i < t; i++) {
            String s = in.next();
            String result = createParentheses(s);
            stringBuilder.append(printResult(caseNum, result));
            caseNum++;
        }
        
        in.close();
        
        printAnswer(stringBuilder.toString());
    }

    private static String createParentheses(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        List<String> charList = new ArrayList<>();
        for(char c : chars) {
            charList.add(Character.toString(c));
        }

        StringBuilder stringBuilder = new StringBuilder();
        int pre = Integer.parseInt(charList.get(0));
        for(int i = 0; i < charList.size(); i++) {
            String str = charList.get(i);
            if(i == 0) {
                for(int j = 0; j < Integer.parseInt(str); j++) {
                    stringBuilder.append("(");
                    count++;
                }
                stringBuilder.append(str);
            } else {
                int target = Integer.parseInt(str);
                if(pre == target) {
                    stringBuilder.append(str);
                } else if(pre > target) {
                    for(int j = 0; j < (pre-target); j++) {
                        stringBuilder.append(")");
                        count--;
                    }
                    stringBuilder.append(str);
                } else {
                    for(int j = 0; j < (target-pre); j++) {
                        stringBuilder.append("(");
                        count++;
                    }
                    stringBuilder.append(str);
                }
                pre = target;
            }
        }
        for(int i = 0; i < count; i++) {
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }

    public static String printResult(int caseNum, String result1) {
        return "Case #" + caseNum + ": " + result1 + "\n";
    }

    public static void printAnswer(String answer) {
        System.out.print(answer);
    }

}