import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;
        while (t-- > 0) {
            String s = br.readLine();
            String result = surroundBinaryStringWithParens(s);
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }

    private static StringBuilder generateParens(char c, int count) {
        char[] chars = new char[count];
        Arrays.fill(chars, c);
        return new StringBuilder().append(chars);
    }

    private static String surroundBinaryStringWithParens(String s) {
        StringBuilder result = new StringBuilder();
        int currentLevel = 0;
        int openParensNeeded = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = Character.digit(s.charAt(i), 10);

            if (digit > currentLevel) {
                result.append(generateParens('(', digit - currentLevel));
                openParensNeeded += (digit - currentLevel);
            } else if (digit < currentLevel) {
                result.append(generateParens(')', currentLevel - digit));
                openParensNeeded -= (currentLevel - digit);
            }

            result.append(s.charAt(i));
            currentLevel = digit;
        }

        if (openParensNeeded > 0) {
            result.append(generateParens(')', openParensNeeded));
        }

        return result.toString();
    }
}