import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer input

        for (int i = 1; i <= t; i++) {
            String input = sc.nextLine();
            int n = input.length();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int j = 0; j < n; j++) {
                int digit = input.charAt(j) - '0';

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }

                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(input.charAt(j));
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }

        sc.close();
    }
}