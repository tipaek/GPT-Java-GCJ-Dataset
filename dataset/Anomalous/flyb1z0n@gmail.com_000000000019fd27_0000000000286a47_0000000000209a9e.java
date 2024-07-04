import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCaseCount = scanner.nextInt();
            int bitsCount = scanner.nextInt();
            PrintWriter writer = new PrintWriter(System.out, true);

            for (int t = 1; t <= testCaseCount; t++) {
                if (!processTestCase(scanner, writer, bitsCount)) {
                    System.exit(0);
                }
            }
        }
    }

    private static boolean processTestCase(Scanner scanner, PrintWriter writer, int bitsCount) {
        StringBuilder bitString = new StringBuilder(bitsCount);

        for (int i = 1; i <= bitsCount; i++) {
            writer.println(i);
            writer.flush();
            int bitValue = scanner.nextInt();
            bitString.append(bitValue);
        }

        writer.println(bitString.toString());
        writer.flush();
        String response = scanner.next();

        return "Y".equals(response);
    }
}