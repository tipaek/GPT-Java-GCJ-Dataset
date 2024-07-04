import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static int countDuplicateColumns(ArrayList<ArrayList<Integer>> matrix, int size) {
        int duplicateColumnCount = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (ArrayList<Integer> row : matrix) {
                uniqueElements.add(row.get(col));
            }
            if (uniqueElements.size() < size) {
                duplicateColumnCount++;
            }
        }
        return duplicateColumnCount;
    }

    public static int countDuplicateRows(ArrayList<ArrayList<Integer>> matrix, int size) {
        int duplicateRowCount = 0;
        for (ArrayList<Integer> row : matrix) {
            for (int num = 1; num <= size; num++) {
                if (row.indexOf(num) != row.lastIndexOf(num)) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        return duplicateRowCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            for (int row = 0; row < matrixSize; row++) {
                ArrayList<Integer> currentRow = new ArrayList<>();
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    currentRow.add(value);
                    if (row == col) {
                        trace += value;
                    }
                }
                matrix.add(currentRow);
            }
            int duplicateRows = countDuplicateRows(matrix, matrixSize);
            int duplicateColumns = countDuplicateColumns(matrix, matrixSize);
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        scanner.close();
    }
}