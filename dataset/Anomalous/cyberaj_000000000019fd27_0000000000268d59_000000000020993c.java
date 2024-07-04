import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner sc;
    static int caseNumber = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();

        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int size = sc.nextInt();
        int[][] matrix = new int[size][size];

        int trace = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        int rowCount = getRowCount(matrix);
        int colCount = getColCount(matrix);

        System.out.println("Case #" + (caseNumber++) + ": " + trace + " " + rowCount + " " + colCount);
    }

    private static int getRowCount(int[][] matrix) {
        int duplicateRows = 0;

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (uniqueElements.contains(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
                uniqueElements.add(matrix[i][j]);
            }
        }
        return duplicateRows;
    }

    private static int getColCount(int[][] matrix) {
        int duplicateCols = 0;

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (uniqueElements.contains(matrix[j][i])) {
                    duplicateCols++;
                    break;
                }
                uniqueElements.add(matrix[j][i]);
            }
        }
        return duplicateCols;
    }
}