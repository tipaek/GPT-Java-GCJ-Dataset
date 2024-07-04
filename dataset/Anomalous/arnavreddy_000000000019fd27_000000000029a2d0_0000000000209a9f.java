import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Parenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int openBrackets = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (openBrackets < digit) {
                    output.append('(');
                    openBrackets++;
                }

                while (openBrackets > digit) {
                    output.append(')');
                    openBrackets--;
                }

                output.append(digit);
            }

            while (openBrackets > 0) {
                output.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + caseNum + ": " + output);
        }
    }
}