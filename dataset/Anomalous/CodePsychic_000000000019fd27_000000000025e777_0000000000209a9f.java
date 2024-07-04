import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int i = 1; i <= testCaseCount; i++) {
            scanner.nextLine();
            String inputString = scanner.next();
            processBrackets(i, inputString);
        }
    }

    public static void processBrackets(int caseNumber, String inputString) {
        StringBuilder result = new StringBuilder();
        int openBrackets = 0;

        for (char currentChar : inputString.toCharArray()) {
            int requiredBrackets = Character.getNumericValue(currentChar);

            while (openBrackets < requiredBrackets) {
                result.append('(');
                openBrackets++;
            }

            while (openBrackets > requiredBrackets) {
                result.append(')');
                openBrackets--;
            }

            result.append(currentChar);
        }

        while (openBrackets > 0) {
            result.append(')');
            openBrackets--;
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }
}