import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 1; i <= testCases; ++i) {
            String inputString = scanner.nextLine();
            String result = processString(inputString);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processString(String s) {
        return insertParentheses(s, 0, s.length() - 1, 0);
    }

    private static String insertParentheses(String s, int left, int right, int depth) {
        if (left > right) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        while (left <= right) {
            int ptr = left;
            while (ptr <= right && (Character.getNumericValue(s.charAt(ptr)) - depth) > 0) {
                ptr++;
            }
            if (ptr > left) {
                result.append("(")
                      .append(insertParentheses(s, left, ptr - 1, depth + 1))
                      .append(")");
                left = ptr;
            } else {
                result.append(s.charAt(ptr));
                left++;
            }
        }
        return result.toString();
    }
}