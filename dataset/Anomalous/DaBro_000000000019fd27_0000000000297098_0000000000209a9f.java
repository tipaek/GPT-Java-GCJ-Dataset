import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class NestingDepths1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            String input = br.readLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                if (digit > currentDepth) {
                    result.append(generateBraces(digit - currentDepth, '('));
                } else if (digit < currentDepth) {
                    result.append(generateBraces(currentDepth - digit, ')'));
                }
                result.append(ch);
                currentDepth = digit;
            }

            if (currentDepth > 0) {
                result.append(generateBraces(currentDepth, ')'));
            }

            System.out.println(result);
        }
    }

    private static String generateBraces(int count, char brace) {
        return String.join("", Collections.nCopies(count, String.valueOf(brace)));
    }
}