import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String input = reader.readLine();
            int length = input.length();

            StringBuilder result = new StringBuilder();
            int currentValue = 0;

            for (int i = 0; i < length; i++) {
                int digit = Character.getNumericValue(input.charAt(i));

                if (digit > currentValue) {
                    result.append(repeatCharacter('(', digit - currentValue));
                    currentValue = digit;
                } else if (digit < currentValue) {
                    result.append(repeatCharacter(')', currentValue - digit));
                    currentValue = digit;
                }

                result.append(digit);

                if (i == length - 1) {
                    result.append(repeatCharacter(')', currentValue));
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String repeatCharacter(char character, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
        return sb.toString();
    }
}