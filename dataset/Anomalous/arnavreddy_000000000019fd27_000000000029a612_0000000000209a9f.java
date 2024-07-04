import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int openBrackets = 0;

            for (char ch : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);

                while (openBrackets < currentDigit) {
                    output.append('(');
                    openBrackets++;
                }

                while (openBrackets > currentDigit) {
                    output.append(')');
                    openBrackets--;
                }

                output.append(currentDigit);
            }

            while (openBrackets > 0) {
                output.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + caseNumber + ": " + output.toString());
        }
    }
}