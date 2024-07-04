import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (char digitChar : input.toCharArray()) {
                int digit = digitChar - '0';

                while (openBrackets < digit) {
                    result.append("(");
                    openBrackets++;
                }

                while (openBrackets > digit) {
                    result.append(")");
                    openBrackets--;
                }

                result.append(digit);
            }

            while (openBrackets > 0) {
                result.append(")");
                openBrackets--;
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}