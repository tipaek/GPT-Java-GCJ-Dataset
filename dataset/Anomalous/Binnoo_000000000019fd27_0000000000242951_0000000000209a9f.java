import java.util.Scanner;

public class Solution {

    private int testCaseNumber;
    private Scanner scanner;
    private int[] digits;

    public Solution(int testCaseNumber, Scanner scanner) {
        this.testCaseNumber = testCaseNumber;
        this.scanner = scanner;
    }

    public void solve() {
        String digitsString = scanner.next();
        digits = new int[digitsString.length()];

        for (int i = 0; i < digitsString.length(); i++) {
            digits[i] = digitsString.charAt(i) - '0';
        }

        StringBuilder result = new StringBuilder();
        int previousValue = 0;

        for (int currentDigit : digits) {
            if (currentDigit > previousValue) {
                result.append("(".repeat(currentDigit - previousValue));
            } else if (currentDigit < previousValue) {
                result.append(")".repeat(previousValue - currentDigit));
            }
            result.append(currentDigit);
            previousValue = currentDigit;
        }

        result.append(")".repeat(previousValue));

        System.out.println("Case #" + testCaseNumber + ": " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int i = 0; i < numberOfTestCases; i++) {
            new Solution(i + 1, scanner).solve();
        }

        scanner.close();
    }
}