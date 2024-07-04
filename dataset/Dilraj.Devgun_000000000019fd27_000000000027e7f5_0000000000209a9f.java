import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int n = 0; n < t; n++) {
            solveProblem2(scanner, n+1);
        }
    }

    public static void solveProblem2(Scanner scanner, int caseNumber) {
        String digits = scanner.next();
        StringBuilder result = new StringBuilder();

        int currOpen = 0;
        for (int i = 0; i < digits.length(); i++) {
            int digit = Integer.parseInt(digits.substring(i, i+1));

            if (currOpen < digit) {
                // add more openings and then current digit
                for (int j = 0; j < (digit - currOpen); j++) {
                    result.append("(");
                }
            } else if (currOpen > digit) {
                // add close and then current digit
                for (int j = 0; j < (currOpen - digit); j++) {
                    result.append(")");
                }
            }

            currOpen = digit;
            // should have right number so add digit
            result.append(digit);
        }

        for (int i = 0; i < currOpen; i++) {
            result.append(")");
        }


        System.out.println("Case #" + caseNumber + ": " + result);

    }
}