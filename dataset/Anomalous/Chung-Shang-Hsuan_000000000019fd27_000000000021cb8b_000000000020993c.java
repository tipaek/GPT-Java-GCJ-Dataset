import java.util.*;

public class Solution {

    private int[][] matrix;
    private int size;
    private int trace;
    private int rowRepeats;
    private int colRepeats;

    public Solution(int size, Scanner scanner) {
        this.size = size;
        this.matrix = new int[size][size];
        this.rowRepeats = 0;
        this.trace = 0;
        this.colRepeats = 0;

        // Reading matrix and checking for row duplicates
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() < size) {
                rowRepeats++;
            }
        }

        // Calculating the trace
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        // Checking for column duplicates
        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                colSet.add(matrix[j][i]);
            }
            if (colSet.size() < size) {
                colRepeats++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            Solution solution = new Solution(matrixSize, scanner);
            System.out.println("Case #" + t + ": " + solution.trace + " " + solution.rowRepeats + " " + solution.colRepeats);
        }
    }
}