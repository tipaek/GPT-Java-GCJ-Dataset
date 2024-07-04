import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 1; tt <= t; tt++) {
            String s = br.readLine();
            int n = s.length();
            int currentBraces = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int value = s.charAt(i) - '0';

                if (value == currentBraces) {
                    result.append(s.charAt(i));
                } else if (value > currentBraces) {
                    int diff = value - currentBraces;
                    result.append(repeatCharacter('(', diff)).append(s.charAt(i));
                    currentBraces += diff;
                } else {
                    int diff = currentBraces - value;
                    result.append(repeatCharacter(')', diff)).append(s.charAt(i));
                    currentBraces -= diff;
                }
            }

            if (currentBraces > 0) {
                result.append(repeatCharacter(')', currentBraces));
            }

            System.out.println("Case #" + tt + ": " + result.toString());
        }
    }

    private static String repeatCharacter(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}