import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            String S = in.nextLine();
            StringBuilder result = new StringBuilder("Case #" + (i + 1) + ": ");
            int currentDepth = 0;

            for (char c : S.toCharArray()) {
                int digit = Character.getNumericValue(c);
                while (currentDepth < digit) {
                    result.append("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(")");
                    currentDepth--;
                }
                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }

            results[i] = result.toString();
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}