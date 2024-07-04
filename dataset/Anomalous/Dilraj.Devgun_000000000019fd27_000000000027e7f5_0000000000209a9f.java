import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int n = 1; n <= t; n++) {
            processCase(scanner, n);
        }
    }

    private static void processCase(Scanner scanner, int caseNumber) {
        String digits = scanner.next();
        StringBuilder result = new StringBuilder();
        int currentOpen = 0;

        for (char digitChar : digits.toCharArray()) {
            int digit = digitChar - '0';

            if (currentOpen < digit) {
                result.append("(".repeat(digit - currentOpen));
            } else if (currentOpen > digit) {
                result.append(")".repeat(currentOpen - digit));
            }

            currentOpen = digit;
            result.append(digit);
        }

        result.append(")".repeat(currentOpen));
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}