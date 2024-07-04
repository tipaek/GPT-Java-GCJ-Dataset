import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class NestingDepths1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                int difference = digit - currentDepth;

                if (difference > 0) {
                    result.append(String.join("", Collections.nCopies(difference, "(")));
                } else if (difference < 0) {
                    result.append(String.join("", Collections.nCopies(-difference, ")")));
                }

                result.append(ch);
                currentDepth = digit;
            }

            if (currentDepth > 0) {
                result.append(String.join("", Collections.nCopies(currentDepth, ")")));
            }

            System.out.println(result.toString());
        }
    }
}