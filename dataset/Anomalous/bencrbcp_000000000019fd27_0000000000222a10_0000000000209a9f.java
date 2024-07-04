import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int x = 0; x < cases; x++) {
            String s = br.readLine();
            StringBuilder result = new StringBuilder();
            int open = 0;
            int closed = 0;

            for (int i = 0; i < s.length(); i++) {
                int currentDigit = Character.getNumericValue(s.charAt(i));
                int prevDigit = i > 0 ? Character.getNumericValue(s.charAt(i - 1)) : 0;

                if (currentDigit > open - closed) {
                    for (int j = 0; j < currentDigit - (open - closed); j++) {
                        result.append("(");
                        open++;
                    }
                } else if (currentDigit < open - closed) {
                    for (int j = 0; j < (open - closed) - currentDigit; j++) {
                        result.append(")");
                        closed++;
                    }
                }

                result.append(currentDigit);
            }

            for (int j = 0; j < open - closed; j++) {
                result.append(")");
            }

            System.out.println("Case #" + (x + 1) + ": " + result);
        }
    }
}