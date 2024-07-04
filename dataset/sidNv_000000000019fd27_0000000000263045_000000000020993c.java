
import java.util.HashSet;
import java.util.Scanner;

/**
 * 
 */
public class Solution {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int noOfTestCases = s.nextInt();

        for (int k = 1; k <= noOfTestCases; k++) {
            int squareMatrixSize = s.nextInt();
            int noOfrowsNCols = squareMatrixSize;
            int rowSum = 0;
            int noOfDupeRows = 0;
            int[][] squareMatrix = new int[noOfrowsNCols][noOfrowsNCols];
            noOfrowsNCols = squareMatrixSize; // just for naming better
            int trace = 0;
            for (int i = 0; i < noOfrowsNCols; i++) {
                HashSet<Integer> hashSet = new HashSet<>();
                for (int j = 0; j < noOfrowsNCols; j++) {
                    squareMatrix[i][j] = s.nextInt();
                    hashSet.add(squareMatrix[i][j]);
                    if (i == j) {
                        trace += squareMatrix[i][j];
                    }
                    if (j == noOfrowsNCols - 1 && hashSet.size() < noOfrowsNCols - 1) {
                        noOfDupeRows++;
                    }

                }

            }
            computeMatrix(squareMatrix, k, trace, noOfrowsNCols, noOfDupeRows); // k - the testcase serialNo
        }
    }

    private static void computeMatrix(int[][] squareMatrix, int testCaseNo, int trace, int noOfrowsNCols, int noOfRowsWithDupes) {

        int noOfDupeColumns = 0;

        for (int i = 0; i < noOfrowsNCols; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < noOfrowsNCols; j++) {
                boolean isAdded = hashSet.add(squareMatrix[j][i]);
                if (!isAdded) {
                    noOfDupeColumns++;
                    break;
                }
            }
        }

        System.out.println("case #" + testCaseNo + ": " + trace + noOfRowsWithDupes + noOfDupeColumns);
    }


}