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
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;

            for (char c : input.toCharArray()) {
                int digit = Character.getNumericValue(c);

                if (digit > currentDepth) {
                    output.append(repeatChar('(', digit - currentDepth));
                } else if (digit < currentDepth) {
                    output.append(repeatChar(')', currentDepth - digit));
                }

                output.append(c);
                currentDepth = digit;
            }

            if (currentDepth > 0) {
                output.append(repeatChar(')', currentDepth));
            }

            System.out.println(output.toString());
        }
    }

    private static String repeatChar(char c, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(c)));
    }
}