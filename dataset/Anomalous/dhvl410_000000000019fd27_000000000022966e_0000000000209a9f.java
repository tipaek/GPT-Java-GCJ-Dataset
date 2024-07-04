import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int t = 1; t <= testCases; t++) {
            String[] input = scanner.nextLine().split("");
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (String s : input) {
                int digit = Integer.parseInt(s);

                if (digit > currentDepth) {
                    result.append("(".repeat(digit - currentDepth));
                } else if (digit < currentDepth) {
                    result.append(")".repeat(currentDepth - digit));
                }
                result.append(digit);
                currentDepth = digit;
            }

            result.append(")".repeat(currentDepth));
            System.out.println("Case #" + t + ": " + result);
        }
    }
}