import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            processTestCase(i + 1, scanner);
        }
    }

    private static void processTestCase(int caseId, Scanner scanner) {
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        List<String> resultLines = new ArrayList<>();

        generateSubResults(rows, columns, resultLines);

        System.out.println("Case #" + caseId + ": " + resultLines.size());
        for (String line : resultLines) {
            System.out.println(line);
        }
    }

    private static void generateSubResults(int rows, int columns, List<String> resultLines) {
        if (rows == 1) {
            return;
        }

        for (int i = 0; i < columns - 1; i++) {
            resultLines.add(((columns - i - 1) * rows + i * (rows - 1)) + " " + (rows - 1));
        }

        generateSubResults(rows - 1, columns, resultLines);
    }
}