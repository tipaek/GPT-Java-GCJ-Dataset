import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int currentLevel = 0;

            for (int j = 0; j < input.length(); j++) {
                int digit = input.charAt(j) - '0';

                if (currentLevel == digit) {
                    result.append(digit);
                } else if (currentLevel > digit) {
                    for (int k = 0; k < currentLevel - digit; k++) {
                        result.append(')');
                    }
                    result.append(digit);
                    currentLevel = digit;
                } else {
                    for (int k = 0; k < digit - currentLevel; k++) {
                        result.append('(');
                    }
                    result.append(digit);
                    currentLevel = digit;
                }
            }

            for (int j = 0; j < currentLevel; j++) {
                result.append(')');
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }
}