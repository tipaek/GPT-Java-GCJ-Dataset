import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        PrintStream out = System.out;
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            char[] digits = scanner.next().toCharArray();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char digitChar : digits) {
                int digit = digitChar - '0';

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}