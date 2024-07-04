import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int previousDigit = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = input.charAt(i) - '0';
                adjustParentheses(previousDigit, currentDigit, output);
                output.append(currentDigit);
                previousDigit = currentDigit;
            }

            adjustParentheses(previousDigit, 0, output);
            results.add(output.toString());
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static void adjustParentheses(int previousDigit, int currentDigit, StringBuilder output) {
        int difference = currentDigit - previousDigit;

        if (difference > 0) {
            for (int j = 0; j < difference; j++) {
                output.append("(");
            }
        } else {
            for (int j = 0; j < -difference; j++) {
                output.append(")");
            }
        }
    }
}