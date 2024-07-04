import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NestingDepth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            int previousDigit = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = Character.getNumericValue(input.charAt(i));

                if (digit > previousDigit) {
                    for (int j = 0; j < digit - previousDigit; j++) {
                        result.append('(');
                    }
                } else if (digit < previousDigit) {
                    for (int j = 0; j < previousDigit - digit; j++) {
                        result.append(')');
                    }
                }

                result.append(digit);
                previousDigit = digit;
            }

            for (int i = 0; i < previousDigit; i++) {
                result.append(')');
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }
}