import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            int traceSum = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            boolean[] colRepeated = new boolean[matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int j = 0; j < matrixSize; j++) {
                    int num = sc.nextInt();
                    matrix[i][j] = num;

                    if (i == j) {
                        traceSum += num;
                    }

                    if (!rowSet.add(num)) {
                        rowHasDuplicate = true;
                    }

                    if (!colRepeated[j]) {
                        for (int k = 0; k < i; k++) {
                            if (matrix[k][j] == num) {
                                colRepeated[j] = true;
                                break;
                            }
                        }
                    }
                }

                if (rowHasDuplicate) {
                    repeatedRows++;
                }
            }

            for (boolean colHasDuplicate : colRepeated) {
                if (colHasDuplicate) {
                    repeatedCols++;
                }
            }

            result.append("Case #").append(testCase + 1).append(": ")
                  .append(traceSum).append(" ")
                  .append(repeatedRows).append(" ")
                  .append(repeatedCols);

            if (testCase + 1 < testCases) {
                result.append("\n");
            }
        }

        System.out.print(result.toString());
    }
}