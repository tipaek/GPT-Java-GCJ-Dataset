import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = scanner.nextInt();

        for (int i = 0; i < testCount; i++) {
            String inputString = scanner.next();
            String formattedString = formatString(inputString);
            System.out.println("Case #" + (i + 1) + ": " + formattedString);
        }
    }

    private static String formatString(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        int openBrackets = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));

            while (openBrackets < currentDigit) {
                resultBuilder.append('(');
                openBrackets++;
            }

            while (openBrackets > currentDigit) {
                resultBuilder.append(')');
                openBrackets--;
            }

            resultBuilder.append(input.charAt(i));
        }

        while (openBrackets > 0) {
            resultBuilder.append(')');
            openBrackets--;
        }

        return resultBuilder.toString();
    }
}