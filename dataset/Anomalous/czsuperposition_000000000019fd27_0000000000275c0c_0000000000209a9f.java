import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            String S = scanner.next();
            StringBuilder temp = new StringBuilder();

            for (int j = 0; j < S.length(); j++) {
                int digit = Character.getNumericValue(S.charAt(j));
                temp.append("(".repeat(digit))
                    .append(digit)
                    .append(")".repeat(digit));
            }

            results[i] = temp.toString().replace(")(", "");
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
}