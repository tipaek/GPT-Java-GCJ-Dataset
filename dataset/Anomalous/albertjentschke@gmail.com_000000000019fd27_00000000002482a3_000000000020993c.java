import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test-cases
        ArrayList<String> outputs = new ArrayList<>();

        for (int k = 0; k < T; k++) {
            int N = scanner.nextInt(); // Size of matrix
            ArrayList<HashMap<Integer, Boolean>> columnMaps = new ArrayList<>();
            boolean[] corruptedColumns = new boolean[N];
            int diagonalSum = 0;
            int corruptedRowsCount = 0;
            int corruptedColumnsCount = 0;

            for (int i = 0; i < N; i++) {
                HashMap<Integer, Boolean> rowMap = new HashMap<>();
                boolean rowCorrupted = false;

                for (int j = 0; j < N; j++) {
                    if (i == 0) {
                        columnMaps.add(new HashMap<>());
                    }
                    int value = scanner.nextInt(); // Read entry

                    if (i == j) {
                        diagonalSum += value;
                    } // Count diagonal

                    if (rowMap.containsKey(value) && !rowCorrupted) {
                        rowCorrupted = true;
                        corruptedRowsCount++;
                    }
                    if (!rowCorrupted) {
                        rowMap.put(value, true);
                    } // Row operations

                    if (!corruptedColumns[j] && columnMaps.get(j).containsKey(value)) {
                        corruptedColumns[j] = true;
                        corruptedColumnsCount++;
                    }
                    if (!corruptedColumns[j]) {
                        columnMaps.get(j).put(value, true);
                    }
                }
            }

            String output = "Case #" + (k + 1) + ": " + diagonalSum + " " + corruptedRowsCount + " " + corruptedColumnsCount;
            outputs.add(output);
        }

        for (String output : outputs) {
            System.out.println(output);
        }

        scanner.close();
    }
}