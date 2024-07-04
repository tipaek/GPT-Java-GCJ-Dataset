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
            StringBuilder sb = new StringBuilder();
            int currentBraces = 0;

            for (char ch : s.toCharArray()) {
                int digit = ch - '0';

                if (digit > currentBraces) {
                    sb.append(repeatChar('(', digit - currentBraces));
                } else if (digit < currentBraces) {
                    sb.append(repeatChar(')', currentBraces - digit));
                }

                sb.append(ch);
                currentBraces = digit;
            }

            if (currentBraces > 0) {
                sb.append(repeatChar(')', currentBraces));
            }

            System.out.println(sb.toString());
        }
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}