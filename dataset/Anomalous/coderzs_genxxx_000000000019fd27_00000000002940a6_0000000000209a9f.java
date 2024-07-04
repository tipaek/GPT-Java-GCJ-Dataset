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

            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';

                if (digit > currentBraces) {
                    sb.append(String.join("", Collections.nCopies(digit - currentBraces, "(")));
                } else if (digit < currentBraces) {
                    sb.append(String.join("", Collections.nCopies(currentBraces - digit, ")")));
                }

                sb.append(digit);
                currentBraces = digit;
            }

            sb.append(String.join("", Collections.nCopies(currentBraces, ")")));
            System.out.println(sb.toString());
        }
    }
}