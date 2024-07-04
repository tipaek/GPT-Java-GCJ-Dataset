import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String ans = "Case #" + (i + 1) + ": ";
            String s = br.readLine();
            int previousDigit = -1;

            StringBuilder result = new StringBuilder(ans);
            for (int j = 0; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                int currentDigit = Character.getNumericValue(currentChar);

                if (currentDigit == 0) {
                    if (previousDigit == 1) {
                        result.append(')');
                    }
                    result.append(currentChar);
                    previousDigit = 0;
                } else {
                    if (previousDigit == currentDigit) {
                        result.append(currentChar);
                    } else {
                        result.append('(').append(currentChar);
                        previousDigit = 1;
                    }
                }
            }

            if (previousDigit == 1) {
                result.append(')');
            }

            System.out.println(result.toString());
        }
    }
}