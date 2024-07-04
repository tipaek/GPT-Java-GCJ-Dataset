import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            String input = br.readLine();
            System.out.println(processString(input));
        }
    }

    private static String processString(String s) {
        int currentBraces = 0;
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            int value = Character.getNumericValue(c);
            
            if (value > currentBraces) {
                result.append(generateBraces('(', value - currentBraces));
            } else if (value < currentBraces) {
                result.append(generateBraces(')', currentBraces - value));
            }
            
            result.append(c);
            currentBraces = value;
        }

        if (currentBraces > 0) {
            result.append(generateBraces(')', currentBraces));
        }

        return result.toString();
    }

    private static String generateBraces(char braceType, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(braceType)));
    }
}