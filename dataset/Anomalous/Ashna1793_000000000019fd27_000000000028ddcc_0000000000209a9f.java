import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {

    private static String result = "";
    private static int minLength;

    private static String nest(String S) {
        result = "";
        minLength = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder(S.length() * 2);
        generateNesting(sb, S, 0, 0);
        return result;
    }

    private static void generateNesting(StringBuilder current, String S, int index, int openBrackets) {
        if (index >= S.length() && openBrackets == 0) {
            if (result.isEmpty() || current.length() < result.length()) {
                result = current.toString();
                minLength = current.length();
            }
            return;
        }

        if (openBrackets < 0 || current.length() >= minLength) {
            return;
        }

        if (index < S.length()) {
            int nextDigit = Character.getNumericValue(S.charAt(index));
            if (openBrackets == nextDigit) {
                current.append(nextDigit);
                generateNesting(current, S, index + 1, openBrackets);
                current.deleteCharAt(current.length() - 1);
            }
        }

        if (index < S.length()) {
            int digit = Character.getNumericValue(S.charAt(index));
            if (openBrackets < digit) {
                current.append("(");
                generateNesting(current, S, index, openBrackets + 1);
                current.deleteCharAt(current.length() - 1);
            }
        }

        if (openBrackets > 0 && current.length() > 0 && current.charAt(current.length() - 1) != '(') {
            current.append(")");
            generateNesting(current, S, index, openBrackets - 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input_file.txt"))) {
            int T = Integer.parseInt(br.readLine());
            for (int i = 1; i <= T; i++) {
                String S = br.readLine();
                String result = nest(S);
                System.out.println("Case #" + i + ": " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}