import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class NestingDepths1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 0; tt < t; tt++) {
            String s = br.readLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : s.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                if (digit > currentDepth) {
                    result.append(String.join("", Collections.nCopies(digit - currentDepth, "(")));
                } else if (digit < currentDepth) {
                    result.append(String.join("", Collections.nCopies(currentDepth - digit, ")")));
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