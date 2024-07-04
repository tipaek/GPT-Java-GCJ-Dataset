import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 1; tt <= t; tt++) {
            String s = br.readLine();
            int n = s.length();
            int openBraces = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int currentDigit = s.charAt(i) - '0';

                if (currentDigit == openBraces) {
                    sb.append(s.charAt(i));
                } else if (currentDigit > openBraces) {
                    sb.append(repeatChar('(', currentDigit - openBraces)).append(s.charAt(i));
                    openBraces = currentDigit;
                } else {
                    sb.append(repeatChar(')', openBraces - currentDigit)).append(s.charAt(i));
                    openBraces = currentDigit;
                }
            }

            if (openBraces > 0) {
                sb.append(repeatChar(')', openBraces));
            }

            System.out.println("Case #" + tt + ": " + sb.toString());
        }
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}