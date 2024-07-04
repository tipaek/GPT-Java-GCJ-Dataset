import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer input

        for (int t = 1; t <= testCases; t++) {
            String input = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = Character.getNumericValue(input.charAt(i));
                int diff = digit - currentDepth;

                if (diff > 0) {
                    result.append("(".repeat(diff));
                } else if (diff < 0) {
                    result.append(")".repeat(-diff));
                }

                result.append(digit);
                currentDepth = digit;
            }

            result.append(")".repeat(currentDepth));

            System.out.println("Case #" + t + ": " + result);
        }
    }
}