import java.io.IOException;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner;

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            execute(scanner);
        }
    }
    
    private static void execute(Scanner scanner) {
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
        printLine("1 1");
        n--;

        int i = 2;
        while (i <= n) {
            printLine(i + " " + 2);
            n -= i - 1;
            i++;
        }
        
        i--;
        while (n > 0) {
            printLine(i + " " + 1);
            n--;
            i++;
        }
    }
    
    private static void printFormatted(String format, Object... args) {
        System.out.println(String.format(format, args));
        System.out.flush();
    }

    private static void printLine(String line) {
        System.out.println(line);
        System.out.flush();
    }
}