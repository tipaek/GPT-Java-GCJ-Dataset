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
            StringBuilder result = new StringBuilder();
            int currentLevel = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                if (digit > currentLevel) {
                    result.append(repeatChar('(', digit - currentLevel));
                } else if (digit < currentLevel) {
                    result.append(repeatChar(')', currentLevel - digit));
                }
                result.append(ch);
                currentLevel = digit;
            }

            if (currentLevel > 0) {
                result.append(repeatChar(')', currentLevel));
            }

            System.out.println(result.toString());
        }
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}