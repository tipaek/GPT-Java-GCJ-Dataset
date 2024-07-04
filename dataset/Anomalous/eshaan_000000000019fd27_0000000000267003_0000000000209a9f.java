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
            int bracketCount = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int currentValue = s.charAt(i) - '0';

                if (currentValue == bracketCount) {
                    result.append(s.charAt(i));
                } else if (currentValue > bracketCount) {
                    int diff = currentValue - bracketCount;
                    result.append(generateBraces(diff, '(')).append(s.charAt(i));
                    bracketCount += diff;
                } else {
                    int diff = bracketCount - currentValue;
                    result.append(generateBraces(diff, ')')).append(s.charAt(i));
                    bracketCount -= diff;
                }
            }

            if (bracketCount > 0) {
                result.append(generateBraces(bracketCount, ')'));
            }

            System.out.println(result.toString());
        }
    }

    private static String generateBraces(int count, char braceType) {
        return String.join("", Collections.nCopies(count, String.valueOf(braceType)));
    }
}