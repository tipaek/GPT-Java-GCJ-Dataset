import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.next();
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();

            for (char ch : inputString.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (digit > currentDepth) {
                    result.append('(');
                    currentDepth++;
                }
                while (digit < currentDepth) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(ch);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }
}