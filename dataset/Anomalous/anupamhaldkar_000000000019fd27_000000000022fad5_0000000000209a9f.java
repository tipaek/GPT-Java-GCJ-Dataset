import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            String result = processString(input);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        scanner.close();
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