import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int rowsWithDuplicates = 0;
            int columnsWithDuplicates = 0;

            boolean[] columnDuplicates = new boolean[matrixSize];
            HashSet<Integer>[] columnSets = new HashSet[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                columnSets[i] = new HashSet<>();
            }

            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int j = 0; j < matrixSize; j++) {
                    int number = scanner.nextInt();
                    if (i == j) {
                        trace += number;
                    }

                    if (rowSet.contains(number)) {
                        rowHasDuplicate = true;
                    } else {
                        rowSet.add(number);
                    }

                    if (columnSets[j].contains(number)) {
                        if (!columnDuplicates[j]) {
                            columnDuplicates[j] = true;
                            columnsWithDuplicates++;
                        }
                    } else {
                        columnSets[j].add(number);
                    }
                }

                if (rowHasDuplicate) {
                    rowsWithDuplicates++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowsWithDuplicates + " " + columnsWithDuplicates);
        }
    }
}