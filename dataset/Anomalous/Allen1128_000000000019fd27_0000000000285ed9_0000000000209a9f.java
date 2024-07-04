import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputLine = scanner.nextLine();
            String result = processLine(inputLine);
            System.out.println("Case #" + caseNumber + ": " + result);
            System.out.flush();
        }
    }

    private static String processLine(String line) {
        StringBuilder resultBuilder = new StringBuilder();
        boolean isParenthesisOpen = false;

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            if (currentChar == '1' && !isParenthesisOpen) {
                resultBuilder.append("(");
                isParenthesisOpen = true;
            } else if (currentChar != '1' && isParenthesisOpen) {
                resultBuilder.append(")");
                isParenthesisOpen = false;
            }

            resultBuilder.append(currentChar);
        }

        if (isParenthesisOpen) {
            resultBuilder.append(")");
        }

        return resultBuilder.toString();
    }
}