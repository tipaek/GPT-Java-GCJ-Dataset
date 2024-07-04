import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < numberOfCases; i++) {
            String input = scanner.next();
            results.add(Solver.solve(input));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class Solver {
    public static String solve(String input) {
        StringBuilder output = new StringBuilder();
        int length = input.length();

        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            for (int j = 0; j < digit; j++) {
                output.append("(");
            }
            output.append(input.charAt(i));
            for (int j = 0; j < digit; j++) {
                output.append(")");
            }
        }

        // Removing redundant parentheses
        StringBuilder simplifiedOutput = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < output.length(); i++) {
            char currentChar = output.charAt(i);
            if (currentChar == '(') {
                balance++;
            } else if (currentChar == ')') {
                balance--;
            }
            simplifiedOutput.append(currentChar);

            if (balance == 0 && i + 1 < output.length() && output.charAt(i + 1) == '(') {
                simplifiedOutput.append(')');
                balance--;
            }
        }

        return simplifiedOutput.toString();
    }
}