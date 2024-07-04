import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int targetDepth = ch - '0';

                while (currentDepth < targetDepth) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > targetDepth) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(ch);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}