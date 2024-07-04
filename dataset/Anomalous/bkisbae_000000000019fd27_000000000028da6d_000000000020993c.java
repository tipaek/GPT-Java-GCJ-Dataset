import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner scanner;
    private static int caseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            processTestCase();
        }
    }

    private static void processTestCase() {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        int trace = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        int rowDuplicates = countRowDuplicates(matrix);
        int colDuplicates = countColumnDuplicates(matrix);

        System.out.println("Case #" + (caseNumber++) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }

    private static int countRowDuplicates(int[][] matrix) {
        int duplicates = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicates++;
                    break;
                }
            }
        }
        return duplicates;
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicates = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicates++;
                    break;
                }
            }
        }
        return duplicates;
    }
}