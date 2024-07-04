import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Solution {

    private int testCaseNumber;
    private Scanner scanner;
    private int matrixSize;
    private int[][] matrix;

    public Solution(int testCaseNumber, Scanner scanner) {
        this.testCaseNumber = testCaseNumber;
        this.scanner = scanner;
    }

    public void solve() {
        matrixSize = scanner.nextInt();
        matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int trace = calculateTrace();
        int rowsWithDuplicate = countRowsWithDuplicates();
        int colsWithDuplicate = countColsWithDuplicates();

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowsWithDuplicate + " " + colsWithDuplicate);
    }

    private int calculateTrace() {
        int trace = 0;
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countRowsWithDuplicates() {
        int rowsWithDuplicate = 0;
        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < matrixSize; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() != matrixSize) {
                rowsWithDuplicate++;
            }
        }
        return rowsWithDuplicate;
    }

    private int countColsWithDuplicates() {
        int colsWithDuplicate = 0;
        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < matrixSize; j++) {
                colSet.add(matrix[j][i]);
            }
            if (colSet.size() != matrixSize) {
                colsWithDuplicate++;
            }
        }
        return colsWithDuplicate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            new Solution(i + 1, scanner).solve();
        }
        scanner.close();
    }
}