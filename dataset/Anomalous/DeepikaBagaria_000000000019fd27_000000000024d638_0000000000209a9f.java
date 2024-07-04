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
            int n = s.length();
            int currentBraces = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int digit = s.charAt(i) - '0';
                if (digit == currentBraces) {
                    result.append(s.charAt(i));
                } else if (digit > currentBraces) {
                    result.append(repeatChar('(', digit - currentBraces)).append(s.charAt(i));
                    currentBraces = digit;
                } else {
                    result.append(repeatChar(')', currentBraces - digit)).append(s.charAt(i));
                    currentBraces = digit;
                }
            }

            if (currentBraces > 0) {
                result.append(repeatChar(')', currentBraces));
            }

            System.out.println(result.toString());
        }
    }

    private static String repeatChar(char c, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(c)));
    }
}