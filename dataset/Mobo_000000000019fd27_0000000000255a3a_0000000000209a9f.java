import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nProblems = Integer.parseInt(in.nextLine());
        for (int problemNumber = 0; problemNumber < nProblems; problemNumber++) {
            String input = in.nextLine();

            String result = solve(input);

            System.out.println("Case #" + (problemNumber + 1) + ": " + result);

        }
    }

    private static String solve(String input) {
        int bracketsOpen = 0;
        int bracketsClosed = 0;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int value = Integer.parseInt(input.substring(i, i + 1));

            int bracketsCurrentlyOpen = bracketsOpen - bracketsClosed;

            if (value == bracketsCurrentlyOpen) {
                result.append(value);
            }
            if (value > bracketsCurrentlyOpen) {
                for (int bracketsToBeOpened = value - bracketsCurrentlyOpen; bracketsToBeOpened > 0; bracketsToBeOpened--) {
                    result.append("(");
                    bracketsOpen++;
                }
                result.append(value);
            }

            if (value < bracketsCurrentlyOpen) {
                for (int bracketsToBeClosed = bracketsCurrentlyOpen - value; bracketsToBeClosed > 0; bracketsToBeClosed--) {
                    result.append(")");
                    bracketsClosed++;
                }
                result.append(value);
            }
        }

        for (int remainingOpenBrackets = bracketsOpen - bracketsClosed; remainingOpenBrackets > 0; remainingOpenBrackets--) {
            result.append(")");
        }
        return result.toString();
    }
}