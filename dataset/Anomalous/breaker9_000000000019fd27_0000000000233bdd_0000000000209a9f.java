import java.util.Scanner;

public class Solution {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int query = in.nextInt();
        
        for (int i = 0; i < query; i++) {
            String s = in.next();
            answer.append("Case #").append(i + 1).append(": ").append(processString(s)).append("\n");
        }
        
        System.out.println(answer);
        in.close();
    }

    private static String processString(String s) {
        StringBuilder newS = new StringBuilder();
        int prevNum = -1;
        int bracCount = 0;

        for (int j = 0; j < s.length(); j++) {
            int num = Character.getNumericValue(s.charAt(j));

            if (num > prevNum) {
                newS.append(repeat("(", num - bracCount));
                bracCount = num;
            } else if (num < prevNum) {
                newS.append(repeat(")", bracCount - num));
                bracCount = num;
            }

            newS.append(num);
            prevNum = num;
        }

        if (bracCount > 0) {
            newS.append(repeat(")", bracCount));
        }

        return newS.toString();
    }

    private static String repeat(String str, int count) {
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < count; i++) {
            newStr.append(str);
        }
        return newStr.toString();
    }
}