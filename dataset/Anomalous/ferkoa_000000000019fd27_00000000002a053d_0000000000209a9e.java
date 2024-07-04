import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private static int readNextInt(Scanner scanner) {
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return value;
    }

    private static void printLine(PrintStream out, int value) {
        out.println(value);
        out.flush();
    }

    private static void printLine(PrintStream out, String message) {
        out.println(message);
        out.flush();
    }

    private static void processFor10(Scanner scanner, PrintStream out) {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            printLine(out, i);
            resultBuilder.append(readNextInt(scanner));
        }
        printLine(out, resultBuilder.toString());
        String response = scanner.nextLine();
        if (!"Y".equals(response)) {
            throw new RuntimeException("Wrong answer.");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;

        int testCases = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 1; i <= testCases; i++) {
            if (b == 10) {
                processFor10(scanner, out);
            }
        }
        scanner.close();
    }
}