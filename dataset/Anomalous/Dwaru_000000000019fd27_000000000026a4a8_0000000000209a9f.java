import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            String result = processString(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String processString(String s) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            result.append(ch);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }
}