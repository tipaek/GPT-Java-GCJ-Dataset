import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        String res = "";

        for (int testCase=0; testCase < testCases; testCase++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            int tSum = 0;
            int rCol = 0;
            int rRow = 0;

            boolean[] colRepeated = new boolean[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                boolean rowRepeated = false;

                for (int j = 0; j < matrixSize; j++) {
                    int n = sc.nextInt();
                    matrix[i][j] = n;

                    if (i == j) {
                        tSum += n;
                    }

                    for (int rJ = 0; rJ < j && !rowRepeated; rJ++) {
                        if (matrix[i][rJ] == n) {
                            rowRepeated = true;
                        }
                    }

                    for (int cI = 0; cI < i && !colRepeated[j]; cI++) {
                        if (matrix[cI][j] == n) {
                            colRepeated[j] = true;
                        }
                    }
                }

                if (rowRepeated) {
                    rRow++;
                }
            }

            for (int c = 0; c < matrixSize; c++) {
                if (colRepeated[c]) {
                    rCol++;
                }
            }

            res += "Case #" + testCase + ": " + tSum + " " + rRow + " " + rCol + (testCase + 1 < testCases ? "\n" : "");
        }

        System.out.print(res);
    }
}