import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class NestingDepth {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            System.out.println(processString(s));
        }
    }

    private static String processString(String s) {
        int currentDepth = 0;
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
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

        return result.toString();
    }

    private static String generateBraces(int count, char brace) {
        return String.join("", Collections.nCopies(count, String.valueOf(brace)));
    }
}