import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < inputString.length(); i++) {
                int digit = inputString.charAt(i) - '0';

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }

        scanner.close();
    }
}