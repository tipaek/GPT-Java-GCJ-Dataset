import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
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
                    result.append(repeatCharacter('(', difference)).append(input.charAt(i));
                    currentBraces += difference;
                } else {
                    int difference = currentBraces - value;
                    result.append(repeatCharacter(')', difference)).append(input.charAt(i));
                    currentBraces -= difference;
                }
            }

            if (currentBraces > 0) {
                result.append(repeatCharacter(')', currentBraces));
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }

    private static String repeatCharacter(char character, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(character)));
    }
}