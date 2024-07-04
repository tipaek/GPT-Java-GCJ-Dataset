import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();

        for (int n = 0; n < numTests; n++) {
            int matrixSize = in.nextInt();
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;

            int[][] temp = new int[matrixSize][matrixSize];

            // traversing rows
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> currRow = new HashSet<>();
                boolean rowFound = false;

                // traversing columns
                for (int j = 0; j < matrixSize; j++) {
                    // value at i,j
                    int curr = in.nextInt();
                    // System.out.println(curr);
                    temp[i][j] = curr;

                    // trace
                    if (i == j) {
                        trace += curr;
                    }

                    // row
                    if (!rowFound && currRow.contains(curr)) {
                        rowCount++;
                        rowFound = true;
                    }
                    currRow.add(curr);
                }
            }

            // column
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> currCol = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    int curr = temp[j][i];
                    if (currCol.contains(curr)) {
                        colCount++;
                        break;
                    }
                    currCol.add(curr);
                }
            }

            System.out.println("Case #" + (n + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}