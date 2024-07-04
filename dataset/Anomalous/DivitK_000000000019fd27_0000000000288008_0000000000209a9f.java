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
            StringBuilder result = processString(s);
            System.out.println(result);
        }
    }

    private static StringBuilder processString(String s) {
        int n = s.length();
        int currentBraces = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int value = Character.getNumericValue(s.charAt(i));

            if (value == currentBraces) {
                sb.append(s.charAt(i));
            } else if (value > currentBraces) {
                sb.append(generateBraces(value - currentBraces, '(')).append(s.charAt(i));
                currentBraces = value;
            } else {
                sb.append(generateBraces(currentBraces - value, ')')).append(s.charAt(i));
                currentBraces = value;
            }
        }

        if (currentBraces > 0) {
            sb.append(generateBraces(currentBraces, ')'));
        }

        return sb;
    }

    private static String generateBraces(int count, char braceType) {
        return String.join("", Collections.nCopies(count, String.valueOf(braceType)));
    }
}