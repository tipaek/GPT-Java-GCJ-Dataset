import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            String input = reader.readLine();
            System.out.println(processString(input));
        }
    }

    private static String processString(String input) {
        StringBuilder result = new StringBuilder();
        int currentBraces = 0;

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

        return result.toString();
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}