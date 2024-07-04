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
            StringBuilder sb = new StringBuilder();
            int currentBraces = 0;

            for (char ch : s.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                if (digit > currentBraces) {
                    sb.append(String.join("", Collections.nCopies(digit - currentBraces, "(")));
                } else if (digit < currentBraces) {
                    sb.append(String.join("", Collections.nCopies(currentBraces - digit, ")")));
                }
                sb.append(ch);
                currentBraces = digit;
            }

            if (currentBraces > 0) {
                sb.append(String.join("", Collections.nCopies(currentBraces, ")")));
            }

            System.out.println("Case #" + (tt + 1) + ": " + sb.toString());
        }
    }
}