import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        int caseCounter = 0;

        while (caseCounter++ < testCases) {
            int n = sc.nextInt();

            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // compute trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // compute rows with repeated numbers
            int rowsWithRepeatedNums = 0;
            for (int[] row : matrix) {
                BitSet bitSet = new BitSet();
                for (int cell : row) {
                    if (bitSet.get(cell)) {
                        rowsWithRepeatedNums++;
                        break;
                    }
                    bitSet.set(cell);
                }
            }

            // compute cols with repeated numbers
            int colsWithRepeatedNums = 0;
            for (int i = 0; i < n; i++) {
                BitSet bitSet = new BitSet();
                for (int j = 0; j < n; j++) {
                    if (bitSet.get(matrix[j][i])) {
                        colsWithRepeatedNums++;
                        break;
                    }
                    bitSet.set(matrix[j][i]);
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", caseCounter, trace, rowsWithRepeatedNums,
                    colsWithRepeatedNums);
        }
    }
}
