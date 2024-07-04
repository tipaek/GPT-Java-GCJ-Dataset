import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder res = new StringBuilder();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            int traceSum = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            boolean[] colRepeated = new boolean[matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowCheck = new boolean[matrixSize + 1];
                boolean rowRepeated = false;

                for (int j = 0; j < matrixSize; j++) {
                    int num = sc.nextInt();
                    matrix[i][j] = num;

                    if (i == j) {
                        traceSum += num;
                    }

                    if (!rowRepeated && rowCheck[num]) {
                        rowRepeated = true;
                    }
                    rowCheck[num] = true;

                    if (!colRepeated[j]) {
                        for (int k = 0; k < i; k++) {
                            if (matrix[k][j] == num) {
                                colRepeated[j] = true;
                                break;
                            }
                        }
                    }
                }

                if (rowRepeated) {
                    repeatedRows++;
                }
            }

            for (boolean col : colRepeated) {
                if (col) {
                    repeatedCols++;
                }
            }

            res.append("Case #").append(testCase + 1).append(": ")
               .append(traceSum).append(" ")
               .append(repeatedRows).append(" ")
               .append(repeatedCols).append(testCase + 1 < testCases ? "\n" : "");
        }

        System.out.print(res.toString());
    }
}