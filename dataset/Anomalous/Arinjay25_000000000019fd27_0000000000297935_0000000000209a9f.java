import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            String input = br.readLine();
            int currentBraces = 0;
            StringBuilder result = new StringBuilder();

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                if (digit > currentBraces) {
                    result.append(repeatChar('(', digit - currentBraces));
                } else if (digit < currentBraces) {
                    result.append(repeatChar(')', currentBraces - digit));
                }
                result.append(ch);
                currentBraces = digit;
            }

            if (currentBraces > 0) {
                result.append(repeatChar(')', currentBraces));
            }

            System.out.println(result);
        }
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}