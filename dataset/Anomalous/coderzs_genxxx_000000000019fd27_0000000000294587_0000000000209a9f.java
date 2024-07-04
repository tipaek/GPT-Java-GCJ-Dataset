import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 0; tt < t; tt++) {
            String s = br.readLine();
            int n = s.length();
            int openBraces = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int currentValue = s.charAt(i) - '0';

                if (currentValue > openBraces) {
                    result.append(repeatCharacter('(', currentValue - openBraces));
                    openBraces = currentValue;
                } else if (currentValue < openBraces) {
                    result.append(repeatCharacter(')', openBraces - currentValue));
                    openBraces = currentValue;
                }

                result.append(s.charAt(i));
            }

            if (openBraces > 0) {
                result.append(repeatCharacter(')', openBraces));
            }

            System.out.println(result.toString());
        }
    }

    private static String repeatCharacter(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}