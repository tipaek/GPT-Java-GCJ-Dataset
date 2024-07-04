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
        StringBuilder sb = new StringBuilder();
        int prev = 0;

        for (char c : S.toCharArray()) {
            int current = Character.getNumericValue(c);
            if (current > prev) {
                sb.append("(".repeat(current - prev));
            } else if (current < prev) {
                sb.append(")".repeat(prev - current));
            }
            sb.append(current);
            prev = current;
        }

        sb.append(")".repeat(prev));
        return sb.toString();
    }
}