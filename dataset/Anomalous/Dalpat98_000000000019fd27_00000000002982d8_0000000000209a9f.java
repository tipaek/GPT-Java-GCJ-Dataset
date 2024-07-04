import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class NestingDepths {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';

                if (digit > currentDepth) {
                    result.append(repeatChar('(', digit - currentDepth));
                } else if (digit < currentDepth) {
                    result.append(repeatChar(')', currentDepth - digit));
                }

                result.append(ch);
                currentDepth = digit;
            }

            if (currentDepth > 0) {
                result.append(repeatChar(')', currentDepth));
            }

            System.out.println(result);
        }
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}