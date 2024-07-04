import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final PrintWriter writer = new PrintWriter(System.out);
    private static final StringBuilder resultString = new StringBuilder();
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String inputString = scanner.next();
            resultString.append("Case #").append(t).append(": ").append(processInputString(inputString)).append(NEW_LINE);
        }
        writer.print(resultString.toString());
        writer.close();
    }

    private static String processInputString(String inputString) {
        char[] characters = inputString.toCharArray();
        int[] digits = new int[characters.length + 2];
        digits[0] = 0;
        digits[digits.length - 1] = 0;

        for (int i = 1; i < digits.length - 1; i++) {
            digits[i] = characters[i - 1] - '0';
        }

        StringBuilder outputString = new StringBuilder();
        for (int i = 1; i < digits.length - 1; i++) {
            for (int j = 0; j < digits[i] - digits[i - 1]; j++) {
                outputString.append("(");
            }
            outputString.append(digits[i]);
            for (int j = 0; j < digits[i] - digits[i + 1]; j++) {
                outputString.append(")");
            }
        }

        return outputString.toString();
    }
}