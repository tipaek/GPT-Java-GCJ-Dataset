import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author satish.thulva. Generated on 04/04/20
 **/
public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numTests = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numTests; i += 1) {
                processTest(i + 1, reader.readLine());
            }
        }
    }

    private static void processTest(int testNumber, String line) {
        int openParenthesis = 0;
        StringBuilder matchingBuilder = new StringBuilder();
        for (char ch : line.toCharArray()) {
            int diff = ch - '0';
            if (openParenthesis == diff) {
                matchingBuilder.append(ch);
                continue;
            }

            if (diff > 0) {
                while (diff > openParenthesis) {
                    openParenthesis += 1;
                    matchingBuilder.append("(");
                }
                matchingBuilder.append(ch);
            } else {
                while (diff < openParenthesis) {
                    openParenthesis -= 1;
                    matchingBuilder.append(")");
                }
                matchingBuilder.append(ch);
            }
        }

        while (openParenthesis-- > 0) {
            matchingBuilder.append(")");
        }
        System.out.println("Case #" + testNumber + ": " + matchingBuilder.toString());
    }

}
