import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class NestingDepths {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 0; tt < t; tt++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            int currentDepth = 0;

            for (char c : s.toCharArray()) {
                int digit = c - '0';
                if (digit > currentDepth) {
                    sb.append(String.join("", Collections.nCopies(digit - currentDepth, "(")));
                } else if (digit < currentDepth) {
                    sb.append(String.join("", Collections.nCopies(currentDepth - digit, ")")));
                }
                sb.append(c);
                currentDepth = digit;
            }

            if (currentDepth > 0) {
                sb.append(String.join("", Collections.nCopies(currentDepth, ")")));
            }

            System.out.println(sb.toString());
        }
    }
}