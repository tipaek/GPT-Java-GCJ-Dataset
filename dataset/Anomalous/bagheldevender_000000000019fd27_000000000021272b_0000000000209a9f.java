import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder resultBuilder = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            String inputString = scanner.next();
            resultBuilder.append("Case #").append(t + 1).append(": ");
            int openBrackets = 0;

            for (int i = 0; i < inputString.length(); i++) {
                int currentDigit = inputString.charAt(i) - '0';
                if (currentDigit > openBrackets) {
                    int difference = currentDigit - openBrackets;
                    for (int j = 0; j < difference; j++) {
                        resultBuilder.append("(");
                    }
                } else if (currentDigit < openBrackets) {
                    int difference = openBrackets - currentDigit;
                    for (int j = 0; j < difference; j++) {
                        resultBuilder.append(")");
                    }
                }
                resultBuilder.append(currentDigit);
                openBrackets = currentDigit;
            }

            while (openBrackets > 0) {
                resultBuilder.append(")");
                openBrackets--;
            }

            resultBuilder.append("\n");
        }

        System.out.print(resultBuilder);
    }
}