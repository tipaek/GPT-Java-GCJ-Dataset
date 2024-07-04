import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                System.out.printf("Case #%d: ", testCase);
                processTestCase(scanner);
            }
        }
    }

    private static void processTestCase(Scanner scanner) {
        int size = scanner.nextInt();
        boolean[][] rowCheck = new boolean[size][size];
        boolean[][] colCheck = new boolean[size][size];
        int trace = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int value = scanner.nextInt();
                if (row == col) {
                    trace += value;
                }
                rowCheck[row][value - 1] = true;
                colCheck[col][value - 1] = true;
            }
        }

        int duplicateRows = countDuplicates(rowCheck, size);
        int duplicateCols = countDuplicates(colCheck, size);

        System.out.println(trace + " " + duplicateRows + " " + duplicateCols);
    }

    private static int countDuplicates(boolean[][] checkArray, int size) {
        int duplicates = 0;
        for (int i = 0; i < size; i++) {
            boolean hasDuplicate = false;
            for (int j = 0; j < size; j++) {
                if (!checkArray[i][j]) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                duplicates++;
            }
        }
        return duplicates;
    }
}