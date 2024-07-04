import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 0; tt < t; tt++) {
            String s = br.readLine();
            int n = s.length();
            int openBracesCount = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int currentDigit = s.charAt(i) - '0';

                if (currentDigit > openBracesCount) {
                    result.append(repeatCharacter('(', currentDigit - openBracesCount));
                    openBracesCount = currentDigit;
                } else if (currentDigit < openBracesCount) {
                    result.append(repeatCharacter(')', openBracesCount - currentDigit));
                    openBracesCount = currentDigit;
                }

                result.append(s.charAt(i));
            }

            if (openBracesCount > 0) {
                result.append(repeatCharacter(')', openBracesCount));
            }

            System.out.println("Case #" + (tt + 1) + ": " + result.toString());
        }
    }

    private static String repeatCharacter(char character, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(character)));
    }
}