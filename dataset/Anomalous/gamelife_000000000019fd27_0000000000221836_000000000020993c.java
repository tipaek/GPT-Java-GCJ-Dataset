import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %d %d %d";

    public static void main(String[] args) {
        try {
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int diagonalSum = calculateDiagonalSum(matrix, n);
        int rowRepeats = countRowRepeats(matrix, n);
        int colRepeats = countColRepeats(matrix, n);

        System.out.println(String.format(OUTPUT_FORMAT, caseNum, diagonalSum, rowRepeats, colRepeats));
    }

    private int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private int countRowRepeats(int[][] matrix, int n) {
        int repeats = 0;
        for (int i = 0; i < n; ++i) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                if (!seen.add(matrix[i][j])) {
                    repeats++;
                    break;
                }
            }
        }
        return repeats;
    }

    private int countColRepeats(int[][] matrix, int n) {
        int repeats = 0;
        for (int j = 0; j < n; ++j) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < n; ++i) {
                if (!seen.add(matrix[i][j])) {
                    repeats++;
                    break;
                }
            }
        }
        return repeats;
    }
}