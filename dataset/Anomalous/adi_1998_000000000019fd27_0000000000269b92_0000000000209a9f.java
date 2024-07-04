import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            String input = scanner.next();
            int length = input.length();
            int[] cumulativeDepth = new int[length];
            StringBuilder result = new StringBuilder();

            cumulativeDepth[0] = Character.getNumericValue(input.charAt(0));
            for (int i = 1; i < length; i++) {
                int difference = Character.getNumericValue(input.charAt(i)) - Character.getNumericValue(input.charAt(i - 1));
                cumulativeDepth[i] = cumulativeDepth[i - 1] + difference;
            }

            if (cumulativeDepth[0] > 0) {
                result.append("(".repeat(cumulativeDepth[0]));
            }
            result.append(input.charAt(0));

            for (int i = 1; i < length; i++) {
                int difference = cumulativeDepth[i] - cumulativeDepth[i - 1];
                if (difference > 0) {
                    result.append("(".repeat(difference));
                } else if (difference < 0) {
                    result.append(")".repeat(-difference));
                }
                result.append(input.charAt(i));
            }

            if (cumulativeDepth[length - 1] > 0) {
                result.append(")".repeat(cumulativeDepth[length - 1]));
            }

            System.out.println(result);
        }

        scanner.close();
    }
}