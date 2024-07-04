import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    private String calculateOutput(int n, int k) {
        StringBuilder result = new StringBuilder();
        if (k > 0 && k % n == 0) {
            result.append("POSSIBLE\n");
            int from = k / n;
            IntStream.range(1, n + 1).forEach(row -> generateRow(result, from - row + 1, n));
        } else {
            result.append("IMPOSSIBLE\n");
        }
        return result.toString();
    }

    private void generateRow(StringBuilder result, int start, int n) {
        int current = start <= 0 ? start + n : start;
        String delimiter = "";
        for (int i = 0; i < n; i++) {
            if (current > n) {
                current = 1;
            }
            result.append(delimiter).append(current++);
            delimiter = " ";
        }
        result.append('\n');
    }

    protected void processTestCase(int caseNumber, Scanner scanner, PrintWriter writer) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        writer.print("Case #" + caseNumber + ": " + calculateOutput(n, k));
    }

    private void process(InputStream inputStream, OutputStream outputStream) {
        try (Scanner scanner = new Scanner(inputStream);
             PrintWriter writer = new PrintWriter(outputStream)) {
            int t = scanner.nextInt();
            for (int i = 0; i < t; i++) {
                processTestCase(i + 1, scanner, writer);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().process(System.in, System.out);
    }
}