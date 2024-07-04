import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static String nestingDepths(String s) {
        StringBuilder sb = new StringBuilder();
        int openParens = 0;
        int firstDigit = Character.getNumericValue(s.charAt(0));

        // Add initial opening parentheses
        for (int i = 0; i < firstDigit; i++) {
            sb.append('(');
            openParens++;
        }
        sb.append(firstDigit);

        // Process the rest of the string
        for (int i = 1; i < s.length(); i++) {
            int currentDigit = Character.getNumericValue(s.charAt(i));
            int previousDigit = Character.getNumericValue(s.charAt(i - 1));

            if (currentDigit > previousDigit) {
                for (int j = 0; j < currentDigit - previousDigit; j++) {
                    sb.append('(');
                    openParens++;
                }
            } else if (currentDigit < previousDigit) {
                for (int j = 0; j < previousDigit - currentDigit; j++) {
                    sb.append(')');
                    openParens--;
                }
            }
            sb.append(currentDigit);
        }

        // Close any remaining open parentheses
        for (int i = 0; i < openParens; i++) {
            sb.append(')');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            System.out.println("Case #" + i + ": " + nestingDepths(input));
        }
    }
}