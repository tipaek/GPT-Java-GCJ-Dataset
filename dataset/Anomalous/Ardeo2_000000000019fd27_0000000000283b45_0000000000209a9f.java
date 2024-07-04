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
            int openBrackets = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int currentVal = s.charAt(i) - '0';

                if (currentVal == openBrackets) {
                    result.append(s.charAt(i));
                } else if (currentVal > openBrackets) {
                    int diff = currentVal - openBrackets;
                    result.append(repeatCharacter('(', diff)).append(s.charAt(i));
                    openBrackets = currentVal;
                } else {
                    int diff = openBrackets - currentVal;
                    result.append(repeatCharacter(')', diff)).append(s.charAt(i));
                    openBrackets = currentVal;
                }
            }

            if (openBrackets > 0) {
                result.append(repeatCharacter(')', openBrackets));
            }

            System.out.println("Case #" + (tt + 1) + ": " + result.toString());
        }
    }

    private static String repeatCharacter(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}