
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int noOfTestCasesNNNN = s.nextInt();
        for (int k = 1; k <= noOfTestCasesNNNN; k++) {
            int squareMatrixSize = s.nextInt();
            int noOfrowsNCols = squareMatrixSize;
            int[][] squareMatrixNNN = new int[noOfrowsNCols][noOfrowsNCols];
            noOfrowsNCols = squareMatrixSize; // just for naming betterMNNNN
            int trace = 0;
            for (int i = 0; i < noOfrowsNCols; i++) {
                for (int j = 0; j < noOfrowsNCols; j++) {
                    squareMatrixNNN[i][j] = s.nextInt();
                    if (i == j) {
                        trace += squareMatrixNNN[i][j];
                    }

                    }
                }
            computeMatrixNNNNN(squareMatrixNNN, k, trace, noOfrowsNCols); // k - the testcase serialNo
            }

        }

    private static void computeMatrixNNNNN(int[][] sqMtrx, int testCaseNo, int trace, int noOfrowsNCols) {

        int noOfDupeColumns = 0;
        int noOfDupeRows =0;
//        int[] aux = new int[noOfrowsNCols];
//        int[] auxForColumns = new int[noOfrowsNCols];
//        System.out.println(Arrays.toString(sqMtrx[noOfrowsNCols - 2]));

        for (int j = 0; j < noOfrowsNCols; j++) {
            HashSet<Integer> hs = new HashSet<>();
            for(int i = 0; i < noOfrowsNCols; i++) {
                boolean isAdded = hs.add(sqMtrx[j][i]);
                if(!isAdded) {
                    noOfDupeRows++;
                    break;
                }
            }
        }
//        Arrays.stream(sqMtrx[noOfrowsNCols]).
        for (int j = 0; j < noOfrowsNCols; j++) {
            HashSet<Integer> hs = new HashSet<>();
            for(int i = 0; i < noOfrowsNCols; i++) {
                boolean isAdded = hs.add(sqMtrx[i][j]);
                if(!isAdded) {
                    noOfDupeColumns++;
                    break;
                }
            }
        }


        System.out.println("Case #" + testCaseNo + ": " + trace + " "+noOfDupeRows + " "+noOfDupeColumns);
    }

}
