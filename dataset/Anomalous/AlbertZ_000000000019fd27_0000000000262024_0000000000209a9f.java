import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PrintWriter OUT = new PrintWriter(System.out);
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int testCases = SCANNER.nextInt();
        for (int i = 1; i <= testCases; i++) {
            OUT.print(String.format("Case #%d: ", i));
            solution.solve();
        }
        OUT.flush();
        System.exit(0);
    }

    private void solve() throws IOException {
        char[] digits = SCANNER.next().toCharArray();
        int previousDigit = 0;
        StringBuilder result = new StringBuilder();

        for (char digit : digits) {
            int currentDigit = digit - '0';
            if (currentDigit < previousDigit) {
                for (int j = 0; j < previousDigit - currentDigit; j++) {
                    result.append(')');
                }
            } else if (currentDigit > previousDigit) {
                for (int j = 0; j < currentDigit - previousDigit; j++) {
                    result.append('(');
                }
            }
            result.append(digit);
            previousDigit = currentDigit;
        }

        while (previousDigit-- > 0) {
            result.append(')');
        }

        OUT.println(result.toString());
    }
}