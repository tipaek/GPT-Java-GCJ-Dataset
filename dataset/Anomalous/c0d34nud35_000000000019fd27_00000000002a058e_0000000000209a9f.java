import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine().trim());

        for (int t = 0; t < T; t++) {
            String num = scan.nextLine().trim();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < num.length(); i++) {
                int digit = num.charAt(i) - '0';

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }

                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }

        scan.close();
    }
}