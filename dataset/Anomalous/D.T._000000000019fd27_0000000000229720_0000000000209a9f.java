import java.util.Scanner;

public class Solution {

    public static void solve(int caseNumber, String inputString) {
        int length = inputString.length();
        int[] digits = new int[length];
        int totalBrackets = 0;

        for (int i = 0; i < length; i++) {
            digits[i] = Character.getNumericValue(inputString.charAt(i));
            totalBrackets += digits[i];
        }

        char[] result = new char[totalBrackets * 2 + length];
        int index = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < digits[i]; j++) {
                result[index++] = '(';
            }
            result[index++] = (char) (digits[i] + '0');
            for (int j = 0; j < digits[i]; j++) {
                result[index++] = ')';
            }
        }

        // Reduce unnecessary pairs of parentheses
        boolean hasReduction;
        do {
            hasReduction = false;
            for (int i = 0; i < result.length - 1; i++) {
                if (result[i] == ')' && result[i + 1] == '(') {
                    result[i] = '-';
                    result[i + 1] = '-';
                    hasReduction = true;
                }
            }
            result = new String(result).replaceAll("-", "").toCharArray();
        } while (hasReduction && result.length > 0);

        System.out.println("Case #" + caseNumber + ": " + new String(result));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            solve(caseNumber, inputString);
        }
    }
}