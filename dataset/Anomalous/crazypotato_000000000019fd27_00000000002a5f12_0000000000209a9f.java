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
            StringBuilder result = processString(input);
            System.out.println(result.toString());
        }
    }

    private static StringBuilder processString(String s) {
        int currentBraces = 0;
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int value = ch - '0';
            if (value == currentBraces) {
                sb.append(ch);
            } else if (value > currentBraces) {
                sb.append(repeatChar('(', value - currentBraces)).append(ch);
                currentBraces = value;
            } else {
                sb.append(repeatChar(')', currentBraces - value)).append(ch);
                currentBraces = value;
            }
        }

        if (currentBraces > 0) {
            sb.append(repeatChar(')', currentBraces));
        }

        return sb;
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}