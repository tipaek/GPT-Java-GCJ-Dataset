import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner sc;
    private static int caseNumber = 1;

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

        int rowDuplicates = countRowDuplicates(matrix);
        int columnDuplicates = countColumnDuplicates(matrix);

        System.out.println("Case #" + (caseNumber++) + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
    }

    private static int countRowDuplicates(int[][] matrix) {
        int duplicateCount = 0;

        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicateCount++;
                    break;
                }
            }
        }

        return duplicateCount;
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        int size = matrix.length;

        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
            }
        }

        return duplicateCount;
    }
}