import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            String input = reader.readLine();
            int length = input.length();
            int currentBraces = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int value = input.charAt(i) - '0';

                if (value == currentBraces) {
                    result.append(input.charAt(i));
                } else if (value > currentBraces) {
                    int difference = value - currentBraces;
                    result.append(generateBraces(difference, '(')).append(input.charAt(i));
                    currentBraces += difference;
                } else {
                    int difference = currentBraces - value;
                    result.append(generateBraces(difference, ')')).append(input.charAt(i));
                    currentBraces -= difference;
                }
            }

            if (currentBraces > 0) {
                result.append(generateBraces(currentBraces, ')'));
            }

            System.out.println(result.toString());
        }
    }

    private static String generateBraces(int count, char brace) {
        return String.join("", Collections.nCopies(count, String.valueOf(brace)));
    }
}