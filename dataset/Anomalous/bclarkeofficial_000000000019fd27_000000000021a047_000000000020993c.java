import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine();

            int trace = 0;
            int[] rowDuplicates = new int[matrixSize];
            int[] columnDuplicates = new int[matrixSize];
            List<Set<Integer>> columns = new ArrayList<>(Collections.nCopies(matrixSize, new HashSet<>()));

            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                String[] rowValues = scanner.nextLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();

                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    int value = Integer.parseInt(rowValues[colIndex]);

                    if (rowIndex == colIndex) {
                        trace += value;
                    }

                    if (!rowSet.add(value)) {
                        rowDuplicates[rowIndex] = 1;
                    }

                    if (!columns.get(colIndex).add(value)) {
                        columnDuplicates[colIndex] = 1;
                    }
                }
            }

            int duplicateRowsCount = Arrays.stream(rowDuplicates).sum();
            int duplicateColumnsCount = Arrays.stream(columnDuplicates).sum();

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRowsCount + " " + duplicateColumnsCount);
        }
    }
}