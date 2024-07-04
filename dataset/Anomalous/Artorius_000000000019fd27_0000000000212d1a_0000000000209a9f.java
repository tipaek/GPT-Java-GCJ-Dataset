import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            StringBuilder result = new StringBuilder();
            String inputString = scanner.next();

            int depth = 0;
            for (char ch : inputString.toCharArray()) {
                int digit = ch - '0';

                while (depth < digit) {
                    result.append('(');
                    depth++;
                }

                while (depth > digit) {
                    result.append(')');
                    depth--;
                }

                result.append(ch);
            }

            while (depth > 0) {
                result.append(')');
                depth--;
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}