import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;
    private static PrintStream output;

    private static final String CASE_PREFIX = "Case #";
    private static final String SEPARATOR = ": ";

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        output = System.out;

        int testCases = scanner.nextInt();
        int[] depths = new int[101];
        StringBuilder result = new StringBuilder(1001);

        for (int t = 1; t <= testCases; t++) {
            result.setLength(0);
            String inputString = scanner.next();
            
            for (int i = 0; i < inputString.length(); i++) {
                depths[i] = inputString.charAt(i) - '0';
            }

            int currentDepth = 0;

            for (int i = 0; i < inputString.length(); i++) {
                int depth = depths[i];
                char ch = inputString.charAt(i);

                if (depth > currentDepth) {
                    for (int j = 0; j < depth - currentDepth; j++) {
                        result.append('(');
                    }
                } else if (depth < currentDepth) {
                    for (int j = 0; j < currentDepth - depth; j++) {
                        result.append(')');
                    }
                }
                currentDepth = depth;
                result.append(ch);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            output.printf("%s%d%s%s%n", CASE_PREFIX, t, SEPARATOR, result.toString());
        }
        output.flush();
    }

}