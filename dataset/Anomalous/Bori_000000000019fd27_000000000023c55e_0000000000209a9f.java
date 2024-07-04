import java.util.Scanner;

public class Solution {

    static String repeatCharacter(String str, int count, String character) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= numberOfTests; t++) {
            String inputLine = scanner.nextLine();
            int openBrackets = 0;
            StringBuilder resultBuilder = new StringBuilder();

            for (int i = 0; i < inputLine.length(); i++) {
                int currentDigit = inputLine.charAt(i) - '0';
                if (currentDigit > openBrackets) {
                    resultBuilder.append(repeatCharacter("", currentDigit - openBrackets, "("));
                } else if (currentDigit < openBrackets) {
                    resultBuilder.append(repeatCharacter("", openBrackets - currentDigit, ")"));
                }
                openBrackets = currentDigit;
                resultBuilder.append(inputLine.charAt(i));
            }

            if (openBrackets > 0) {
                resultBuilder.append(repeatCharacter("", openBrackets, ")"));
            }

            System.out.println("Case #" + t + ": " + resultBuilder.toString());
        }

        scanner.close();
    }
}