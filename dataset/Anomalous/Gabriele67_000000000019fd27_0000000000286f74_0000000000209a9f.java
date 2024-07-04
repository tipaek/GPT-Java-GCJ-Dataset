import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= T; i++) {
            String base = reader.readLine();
            StringBuilder s = new StringBuilder();

            for (int c = 0; c < base.length(); c++) {
                int pairs = Character.getNumericValue(base.charAt(c));
                s.append("(".repeat(pairs)).append(base.charAt(c)).append(")".repeat(pairs));
            }

            StringBuilder out = new StringBuilder();
            for (int c = 0; c < s.length() - 1; c++) {
                if (s.charAt(c) == ')' && s.charAt(c + 1) == '(') {
                    continue;
                }
                out.append(s.charAt(c));
            }
            out.append(s.charAt(s.length() - 1)); // Append the last character

            System.out.println("Case #" + i + ": " + out);
        }
    }
}