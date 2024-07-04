import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String inputString = scanner.next();
            processString(inputString, t);
        }
        scanner.close();
    }

    public static void processString(String input, int caseNumber) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
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

        System.out.println(String.format("Case #%d: %s", caseNumber, result.toString()));
    }
}