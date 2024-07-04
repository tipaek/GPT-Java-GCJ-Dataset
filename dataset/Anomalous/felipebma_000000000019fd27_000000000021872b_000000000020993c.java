import java.util.Scanner;
import java.util.Arrays;

class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            processCase(caseIndex);
        }
    }

    private static void processCase(int caseIndex) {
        int matrixSize = scanner.nextInt();
        int trace = 0, invalidRows = 0, invalidColumns = 0;
        int cumulativeXor = 0;

        for (int i = 1; i <= matrixSize; i++) {
            cumulativeXor ^= i;
        }

        int[] rowXors = new int[matrixSize];
        int[] columnXors = new int[matrixSize];
        Arrays.fill(rowXors, cumulativeXor);
        Arrays.fill(columnXors, cumulativeXor);

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                int value = scanner.nextInt();
                if (row == col) {
                    trace += value;
                }
                rowXors[row] ^= value;
                columnXors[col] ^= value;
            }
        }

        for (int rowXor : rowXors) {
            if (rowXor != 0) {
                invalidRows++;
            }
        }

        for (int columnXor : columnXors) {
            if (columnXor != 0) {
                invalidColumns++;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", caseIndex, trace, invalidRows, invalidColumns);
    }
}