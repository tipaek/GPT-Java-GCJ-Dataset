import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader input = new InputReader(inputStream);
        PrintWriter output = new PrintWriter(outputStream);
        NestingDepthSolver solver = new NestingDepthSolver();
        solver.solve(input, output);
        output.close();
    }
}

class NestingDepthSolver {
    public void solve(InputReader input, PrintWriter output) {
        int testCases = input.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String sequence = input.next();
            output.print("Case #" + caseNumber + ": ");
            int currentDepth = 0;

            for (char digitChar : sequence.toCharArray()) {
                int digit = digitChar - '0';
                while (currentDepth < digit) {
                    output.print("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    output.print(")");
                    currentDepth--;
                }
                output.print(digitChar);
            }

            while (currentDepth > 0) {
                output.print(")");
                currentDepth--;
            }
            output.println();
        }
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}