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

        for (int t = 0; t < testCases; t++) {
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

        int rowRepeats = countRowRepeats(matrix);
        int colRepeats = countColRepeats(matrix);

        System.out.println("Case #" + (caseNumber++) + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }

    private static int countRowRepeats(int[][] matrix) {
        int repeatCount = 0;

        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    repeatCount++;
                    break;
                }
            }
        }

        return repeatCount;
    }

    private static int countColRepeats(int[][] matrix) {
        int repeatCount = 0;

        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatCount++;
                    break;
                }
            }
        }

        return repeatCount;
    }
}