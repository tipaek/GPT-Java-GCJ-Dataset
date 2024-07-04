import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            handleCase(caseIndex, scanner);
        }
    }
    
    private static void handleCase(int caseNumber, Scanner scanner) {
        String inputString = scanner.next(); // A is either 20 or 200
        StringBuilder output = new StringBuilder();
        
        int openParens = 0;
        for (int i = 0; i < inputString.length(); i++) {
            int digit = Character.getNumericValue(inputString.charAt(i));
            while (openParens > digit) {
                output.append(")");
                openParens--;
            }
            while (openParens < digit) {
                output.append("(");
                openParens++;
            }
            output.append(digit);
        }

        while (openParens > 0) {
            output.append(")");
            openParens--;
        }
        System.out.printf("Case #%d: %s%n", caseNumber, output.toString());
    }
}