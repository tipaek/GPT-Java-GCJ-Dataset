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
            int braceCount = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int currentValue = Character.getNumericValue(s.charAt(i));
                if (currentValue == braceCount) {
                    result.append(s.charAt(i));
                } else if (currentValue > braceCount) {
                    result.append(String.join("", Collections.nCopies(currentValue - braceCount, "(")))
                          .append(s.charAt(i));
                    braceCount = currentValue;
                } else {
                    result.append(String.join("", Collections.nCopies(braceCount - currentValue, ")")))
                          .append(s.charAt(i));
                    braceCount = currentValue;
                }
            }

            if (braceCount > 0) {
                result.append(String.join("", Collections.nCopies(braceCount, ")")));
            }

            System.out.println("Case #" + tt + ": " + result);
        }
    }
}