import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCount; testCase++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (currentDepth < digit) {
                    output.append('(');
                    currentDepth++;
                }

                while (currentDepth > digit) {
                    output.append(')');
                    currentDepth--;
                }

                output.append(digit);
            }

            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + testCase + ": " + output.toString());
        }
    }
}