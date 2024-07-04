import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String openBrackets = "((((((((((";
        String closeBrackets = ")))))))))))";

        for (int t = 0; t < testCases; t++) {
            String result = "";
            String input = scanner.next();
            int length = input.length();
            int[] cumulativeSum = new int[length];
            cumulativeSum[0] = Character.getNumericValue(input.charAt(0));

            for (int i = 1; i < length; i++) {
                int difference = Character.getNumericValue(input.charAt(i)) - Character.getNumericValue(input.charAt(i - 1));
                cumulativeSum[i] = cumulativeSum[i - 1] + difference;
            }

            if (cumulativeSum[0] > 0) {
                result += openBrackets.substring(0, cumulativeSum[0]);
            }
            result += input.charAt(0);

            for (int i = 1; i < length; i++) {
                int difference = cumulativeSum[i] - cumulativeSum[i - 1];
                if (difference > 0) {
                    result += openBrackets.substring(0, difference);
                } else if (difference < 0) {
                    result += closeBrackets.substring(0, -difference);
                }
                result += input.charAt(i);
            }

            if (cumulativeSum[length - 1] > 0) {
                result += closeBrackets.substring(0, cumulativeSum[length - 1]);
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}