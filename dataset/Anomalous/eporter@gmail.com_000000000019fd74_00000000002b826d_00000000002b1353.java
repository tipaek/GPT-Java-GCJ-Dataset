import java.io.IOException;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner;

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            execute(scanner);
        }
    }

    public static void execute(Scanner scanner) {
        int numberOfCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            new Solution(scanner).processCase(caseNumber);
        }
    }

    public Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    private void processCase(int caseNumber) {
        int n = scanner.nextInt();
        printFormatted("Case #%d:", caseNumber);
        print("1 1");
        n--;
        int row = 2;
        while (row - 1 <= n) {
            print(row + " " + 2);
            n -= row - 1;
            row++;
        }
        row--;
        while (n > 0) {
            print(row + " " + 1);
            n--;
            row++;
        }
    }

    private static void printFormatted(String format, Object... args) {
        System.out.printf(format, args);
        System.out.println();
    }

    private static void print(String message) {
        System.out.println(message);
    }
}