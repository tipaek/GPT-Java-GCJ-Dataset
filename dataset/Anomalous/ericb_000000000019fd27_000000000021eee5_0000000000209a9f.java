import java.util.Scanner;

public class Solution {
    static int testCases;
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            output.append(runTestCase(i + 1));
        }

        System.out.println(output.toString());
    }

    public static String runTestCase(int caseNumber) {
        String tokens = scanner.nextLine();
        return "Case #" + caseNumber + ": " + getOutput(tokens) + "\n";
    }

    public static String getOutput(String input) {
        int open = 0;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));

            while (open < currentDigit) {
                output.append('(');
                open++;
            }

            while (open > currentDigit) {
                output.append(')');
                open--;
            }

            output.append(currentDigit);
        }

        while (open > 0) {
            output.append(')');
            open--;
        }

        return output.toString();
    }
}