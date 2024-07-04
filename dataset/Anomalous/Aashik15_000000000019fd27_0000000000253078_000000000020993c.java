import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static Scanner scanner;
    static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            solve();
        }
    }

    private static void solve() {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        int diagonalSum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
            }
        }

        int repeatedRows = countRepeatedRows(matrix);
        int repeatedColumns = countRepeatedColumns(matrix);

        System.out.println("Case #" + (testCaseNumber++) + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
    }

    private static int countRepeatedRows(int[][] matrix) {
        int repeatedRowCount = 0;

        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    repeatedRowCount++;
                    break;
                }
            }
        }

        return repeatedRowCount;
    }

    private static int countRepeatedColumns(int[][] matrix) {
        int repeatedColumnCount = 0;

        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatedColumnCount++;
                    break;
                }
            }
        }

        return repeatedColumnCount;
    }
}