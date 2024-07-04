import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = Integer.parseInt(input.nextLine());
        for (int ks = 1; ks <= T; ks++) {
            String S = input.nextLine();
            System.out.println("Case #" + ks + ": " + addParentheses(S));
        }
    }

    private static String addParentheses(String S) {
        StringBuilder result = new StringBuilder();
        int previous = 0;

        for (char c : S.toCharArray()) {
            int current = Character.getNumericValue(c);
            if (current > previous) {
                result.append("(".repeat(current - previous));
            } else if (current < previous) {
                result.append(")".repeat(previous - current));
            }
            result.append(c);
            previous = current;
        }

        result.append(")".repeat(previous));
        return result.toString();
    }
}