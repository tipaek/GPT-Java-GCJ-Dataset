import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= T; i++) {
            char[] S = scanner.nextLine().toCharArray();


            int depth = 0;
            StringBuilder result = new StringBuilder();
            for (int k = 0; k < S.length; k++) {
                int n = Character.getNumericValue(S[k]);
                while (depth < n) {
                    result.append("(");
                    depth++;
                }
                while (depth > n) {
                    result.append(")");
                    depth--;
                }
                result.append(S[k]);
            }
            while (depth > 0) {
                result.append(")");
                depth--;
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}