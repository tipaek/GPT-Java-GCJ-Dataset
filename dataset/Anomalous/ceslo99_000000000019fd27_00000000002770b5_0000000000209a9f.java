import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++) {
            String number = scanner.nextLine();
            processNumberWithParenthesis(number, i);
        }
    }

    public static void processNumberWithParenthesis(String number, int caseNum) {
        StringBuilder result = new StringBuilder();
        int currentDigit = 0;
        int previousDigit = 0;

        for (int i = 0; i < number.length(); i++) {
            currentDigit = Character.getNumericValue(number.charAt(i));

            if (i > 0) {
                previousDigit = Character.getNumericValue(number.charAt(i - 1));
            }

            if (currentDigit > previousDigit) {
                for (int j = 0; j < currentDigit - previousDigit; j++) {
                    result.append("(");
                }
            } else if (currentDigit < previousDigit) {
                for (int j = 0; j < previousDigit - currentDigit; j++) {
                    result.append(")");
                }
            }

            result.append(number.charAt(i));
        }

        for (int j = 0; j < currentDigit; j++) {
            result.append(")");
        }

        System.out.println("Case #" + (caseNum + 1) + ": " + result.toString());
    }
}