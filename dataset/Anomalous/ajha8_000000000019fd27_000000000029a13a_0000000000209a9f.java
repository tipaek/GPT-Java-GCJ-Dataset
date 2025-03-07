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
            int length = input.length();
            int currentBraces = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int value = Character.getNumericValue(input.charAt(i));
                if (value == currentBraces) {
                    result.append(input.charAt(i));
                } else if (value > currentBraces) {
                    int difference = value - currentBraces;
                    result.append(repeatCharacter('(', difference)).append(input.charAt(i));
                    currentBraces = value;
                } else {
                    int difference = currentBraces - value;
                    result.append(repeatCharacter(')', difference)).append(input.charAt(i));
                    currentBraces = value;
                }
            }

            if (currentBraces > 0) {
                result.append(repeatCharacter(')', currentBraces));
            }

            System.out.println(result.toString());
        }
    }

    private static String repeatCharacter(char character, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(character)));
    }
}