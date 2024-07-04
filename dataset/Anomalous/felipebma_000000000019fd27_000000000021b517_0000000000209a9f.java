import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            processCase(caseNumber);
        }
    }

    private static void processCase(int caseNumber) {
        StringBuilder result = new StringBuilder();
        String inputString = scanner.nextLine();
        int currentDepth = 0;

        for (char digitChar : inputString.toCharArray()) {
            int digit = digitChar - '0';
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            result.append(digitChar);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
    }
}