import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static String result = "";
    private static int minLength;

    private static String nest(String S) {
        result = "";
        minLength = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        generateNesting(sb, S, 0, 0);
        return result;
    }

    private static void generateNesting(StringBuilder current, String S, int index, int openBrackets) {
        if (index >= S.length() && openBrackets == 0) {
            if (result.isEmpty() || current.length() < minLength) {
                result = current.toString();
                minLength = current.length();
            }
            return;
        }

        if (openBrackets < 0 || current.length() >= minLength) {
            return;
        }

        int digit = 0;
        if (index < S.length()) {
            digit = Character.getNumericValue(S.charAt(index));
        }

        if (openBrackets < digit && index < S.length()) {
            generateNesting(current.append("("), S, index, openBrackets + 1);
            current.deleteCharAt(current.length() - 1);
        }

        if (openBrackets > 0 && current.charAt(current.length() - 1) != '(') {
            generateNesting(current.append(")"), S, index, openBrackets - 1);
            current.deleteCharAt(current.length() - 1);
        }

        if (index < S.length()) {
            int nextDigit = Character.getNumericValue(S.charAt(index));
            if (openBrackets == nextDigit) {
                generateNesting(current.append(nextDigit), S, index + 1, openBrackets);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            String S = scanner.next();
            String nestedString = nest(S);
            System.out.println("Case #" + i + ": " + nestedString);
        }
        scanner.close();
    }
}