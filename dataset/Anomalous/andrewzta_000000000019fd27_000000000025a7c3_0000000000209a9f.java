import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner scanner = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        NestingDepth solver = new NestingDepth();
        int testCases = Integer.parseInt(scanner.next());
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, scanner, writer);
        }
        writer.close();
    }

    static class NestingDepth {
        public void solve(int testNumber, Scanner scanner, PrintWriter writer) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
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

            writer.println("Case #" + testNumber + ": " + result.toString());
        }
    }
}