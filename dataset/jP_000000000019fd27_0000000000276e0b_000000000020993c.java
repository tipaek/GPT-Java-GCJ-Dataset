
import java.util.HashSet;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int noOfTestCasesNNNN = s.nextInt();

        for (int k = 1; k <= noOfTestCasesNNNN; k++) {
            int squareMatrixSize = s.nextInt();
            int noOfrowsNCols = squareMatrixSize;


            int rowSum = 0;
            int noOfDupeRows = 0;
            int[][] squareMatrixNNN = new int[noOfrowsNCols][noOfrowsNCols];
            noOfrowsNCols = squareMatrixSize; // just for naming betterMNNNN
            int trace = 0;




            for (int i = 0;  i < noOfrowsNCols; i++) {
                
                
                HashSet<Integer> hashSet = new HashSet<>();
                for (int j = 0; j < noOfrowsNCols; j++) {
                    squareMatrixNNN[i][j] = s.nextInt();
                    hashSet.add(squareMatrixNNN[i][j]);
                    if (i == j) {
                        trace += squareMatrixNNN[i][j];
                    }
                    if (j == noOfrowsNCols - 1 && hashSet.size() < noOfrowsNCols - 1) {
                        noOfDupeRows++;
                    }

                }

            }
            computeMatrixNNNNN(squareMatrixNNN, k, trace, noOfrowsNCols, noOfDupeRows); // k - the testcase serialNo
        }
    }

    private static void computeMatrixNNNNN(int[][] squareMatrix, int testCaseNo, int trace, int noOfrowsNCols, int noOfRowsWithDupes) {

        int noOfDupeColumns = 0;

        for (int j = 0; j < noOfrowsNCols; j++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 0; i < noOfrowsNCols; i++) {
                boolean isAdded = hashSet.add(squareMatrix[i][j]);
                if (!isAdded) {
                    noOfDupeColumns++;
                    break;
                }
            }
        }

        System.out.println("Case #" + testCaseNo + ": " + trace + " "+noOfRowsWithDupes + " "+noOfDupeColumns);
    }


}
