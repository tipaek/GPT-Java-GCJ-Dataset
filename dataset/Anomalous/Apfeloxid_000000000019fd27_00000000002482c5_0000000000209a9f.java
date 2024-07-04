import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char digit : input.toCharArray()) {
                int targetDepth = digit - '0';

                while (currentDepth < targetDepth) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > targetDepth) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}