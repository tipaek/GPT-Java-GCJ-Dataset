import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            boolean[][] rowTracker = new boolean[size + 1][size + 1];
            boolean[][] columnTracker = new boolean[size + 1][size + 1];
            boolean[] columnDuplicates = new boolean[size + 1];
            
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int row = 0; row < size; row++) {
                boolean rowHasDuplicates = false;

                for (int col = 0; col < size; col++) {
                    int value = scanner.nextInt();

                    // Check for duplicates in the current row
                    if (rowTracker[row][value]) {
                        rowHasDuplicates = true;
                    } else {
                        rowTracker[row][value] = true;
                    }

                    // Check for duplicates in the current column
                    if (columnTracker[col][value] && !columnDuplicates[col]) {
                        columnDuplicates[col] = true;
                        duplicateColumns++;
                    } else {
                        columnTracker[col][value] = true;
                    }

                    // Calculate the trace
                    if (row == col) {
                        trace += value;
                    }
                }

                if (rowHasDuplicates) {
                    duplicateRows++;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", testCase, trace, duplicateRows, duplicateColumns);
        }

        scanner.close();
    }
}