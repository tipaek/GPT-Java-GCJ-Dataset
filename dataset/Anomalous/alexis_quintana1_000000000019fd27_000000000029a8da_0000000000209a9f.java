import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            String S = scanner.nextLine();
            results[i] = "Case #" + (i + 1) + ": " + processString(S);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String processString(String S) {
        StringBuilder result = new StringBuilder();
        int prev = 0;

        for (int j = 0; j < S.length(); j++) {
            int current = Character.getNumericValue(S.charAt(j));
            if (current > prev) {
                result.append("(".repeat(current - prev));
            } else if (current < prev) {
                result.append(")".repeat(prev - current));
            }
            result.append(current);
            prev = current;
        }

        result.append(")".repeat(prev));
        return result.toString();
    }
}