import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        parenthesisDepthProblem();
    }

    private static void parenthesisDepthProblem() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int eachTestCase = 0; eachTestCase < t; eachTestCase++) {
            String input = scan.next();
            System.out.println(findParanthesisDepthProblemResult(eachTestCase + 1, input));
        }
        scan.close();
    }

    private static String findParanthesisDepthProblemResult(int testCase, String input) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char c : input.toCharArray()) {
            char lastChar = temp.length() > 0 ? temp.charAt(temp.length() - 1): '-';
            if (lastChar == c) {
                temp.append(c);
                continue;
            }
            if (lastChar == '1') {
                result.append("(").append(temp).append(")");
            } else if (lastChar == '0') {
                result.append(temp);
            }
            temp = new StringBuilder(c + "");
        }
        char lastChar = temp.charAt(temp.length() - 1);
        if (lastChar == '1') {
            result.append("(").append(temp).append(")");
        } else if (lastChar == '0') {
            result.append(temp);
        }
        return String.format("Case #%d: %s", testCase, result.toString());
    }
}
