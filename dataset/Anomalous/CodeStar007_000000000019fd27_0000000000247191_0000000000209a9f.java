import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            String result = solve(inputString);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String solve(String s) {
        StringBuilder result = new StringBuilder();
        int previousDigit = s.charAt(0) - '0';

        for (int i = 0; i < previousDigit; i++) {
            result.append('(');
        }
        result.append(previousDigit);

        for (int i = 1; i < s.length(); i++) {
            int currentDigit = s.charAt(i) - '0';

            while (previousDigit > currentDigit) {
                result.append(')');
                previousDigit--;
            }

            while (previousDigit < currentDigit) {
                result.append('(');
                previousDigit++;
            }

            result.append(currentDigit);
        }

        while (previousDigit > 0) {
            result.append(')');
            previousDigit--;
        }

        return result.toString();
    }
}