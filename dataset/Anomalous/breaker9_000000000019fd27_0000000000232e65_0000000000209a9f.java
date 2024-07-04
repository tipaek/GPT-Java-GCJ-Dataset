import java.util.Scanner;

public class Solution {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queryCount = in.nextInt();

        for (int i = 0; i < queryCount; i++) {
            String input = in.next();
            String result = processInput(input);
            answer.append("Case #").append(i + 1).append(": ").append(result).append("\n");
        }

        in.close();
        System.out.print(answer.toString());
    }

    private static String processInput(String input) {
        StringBuilder newS = new StringBuilder();
        int prevNum = -1;
        int bracCount = Character.getNumericValue(input.charAt(0));

        for (int j = 0; j < input.length(); j++) {
            int num = Character.getNumericValue(input.charAt(j));

            if (num > prevNum) {
                newS.append(repeat("(", num - prevNum));
            } else if (num < prevNum) {
                newS.append(repeat(")", prevNum - num));
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