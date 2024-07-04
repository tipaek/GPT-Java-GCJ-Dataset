import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder(input);
            int offset = 0;

            for (int i = 0; i < input.length() - 1; i++) {
                int currentDigit = Character.getNumericValue(result.charAt(offset + i));
                int nextDigit = Character.getNumericValue(result.charAt(offset + i + 1));
                int difference = currentDigit - nextDigit;

                if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        result.insert(offset + i + 1, ")");
                        offset++;
                    }
                } else if (difference < 0) {
                    for (int j = 0; j < -difference; j++) {
                        result.insert(offset + i + 1, "(");
                        offset++;
                    }
                }
            }

            int lastDigit = Character.getNumericValue(result.charAt(result.length() - 1));
            for (int j = 0; j < lastDigit; j++) {
                result.append(")");
            }

            int firstDigit = Character.getNumericValue(result.charAt(0));
            for (int j = 0; j < firstDigit; j++) {
                result.insert(0, "(");
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}