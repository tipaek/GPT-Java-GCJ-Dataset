import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static String result;
    static int minimumLength;

    private static String nest(String S) {
        result = "";
        minimumLength = Integer.MAX_VALUE;
        generateNesting("", S, 0, 0);
        return result;
    }

    private static void generateNesting(String current, String S, int index, int openBrackets) {
        if (index >= S.length() && openBrackets == 0) {
            if (result.isEmpty() || current.length() < result.length()) {
                result = current;
                minimumLength = current.length();
            }
            return;
        }

        if (openBrackets < 0 || current.length() >= minimumLength) return;

        int digit = (index < S.length()) ? Character.getNumericValue(S.charAt(index)) : 0;

        if (openBrackets < digit && index < S.length()) {
            generateNesting(current + "(", S, index, openBrackets + 1);
        }

        if (openBrackets > 0 && current.charAt(current.length() - 1) != '(') {
            generateNesting(current + ")", S, index, openBrackets - 1);
        }

        if (index < S.length()) {
            int nextDigit = Character.getNumericValue(S.charAt(index));
            if (openBrackets == nextDigit) {
                generateNesting(current + nextDigit, S, index + 1, openBrackets);
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