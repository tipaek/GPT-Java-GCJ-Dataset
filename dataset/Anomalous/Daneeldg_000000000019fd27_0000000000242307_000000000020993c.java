import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private final Scanner input;
    private final PrintStream output;

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in); PrintStream output = System.out) {
            int numCases = input.nextInt();

            for (int t = 0; t < numCases; t++) {
                output.printf("Case #%d: ", t + 1);
                output.println(new Solution(input, output).solve());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Solution(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public String solve() {
        int n = input.nextInt();
        int[][] matrix = readMatrix(n);

        return calculateTrace(matrix) + " " + countRepeatedRows(matrix) + " " + countRepeatedCols(matrix);
    }

    private int[][] readMatrix(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        return matrix;
    }

    private int calculateTrace(int[][] matrix) {
        int trace = 0;

        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        return trace;
    }

    private int countRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;

        for (int[] row : matrix) {
            Set<Integer> seen = new HashSet<>();
            for (int value : row) {
                if (!seen.add(value)) {
                    repeatedRows++;
                    break;
                }
            }
        }

        return repeatedRows;
    }

    private int countRepeatedCols(int[][] matrix) {
        int repeatedCols = 0;
        int n = matrix.length;

        for (int col = 0; col < n; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (!seen.add(matrix[row][col])) {
                    repeatedCols++;
                    break;
                }
            }
        }

        return repeatedCols;
    }
}