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
                    int diff = value - currentBraces;
                    result.append(repeatCharacter('(', diff)).append(input.charAt(i));
                    currentBraces = value;
                } else {
                    int diff = currentBraces - value;
                    result.append(repeatCharacter(')', diff)).append(input.charAt(i));
                    currentBraces = value;
                }
            }

            if (currentBraces > 0) {
                result.append(repeatCharacter(')', currentBraces));
            }

            System.out.println(result.toString());
        }
    }

    private static String repeatCharacter(char character, int times) {
        return String.join("", Collections.nCopies(times, String.valueOf(character)));
    }
}