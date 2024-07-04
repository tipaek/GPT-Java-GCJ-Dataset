import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        @SuppressWarnings("resource") 
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = in.nextInt();
            int cCount = 0, jCount = 0;
            boolean impossible = false;
            StringBuilder str = new StringBuilder();
            int[][] matrix = new int[matrixSize][2];
            int[][] cMatrix = new int[matrixSize][2];
            int[][] jMatrix = new int[matrixSize][2];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < 2; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            str = getString('J', matrix, cMatrix, jMatrix, cCount, jCount, 0, matrixSize, str,
                false);
            if (str.toString().equals("IMPOSSIBLE")) {
                str = getString('C', matrix, new int[matrixSize][2], new int[matrixSize][2], cCount,
                    jCount, 0, matrixSize, new StringBuilder(), true);
            }
            System.out.println("Case #" + t + ": " + str);
        }
    }    
    
    public static StringBuilder getString(char tryWith,
                                          int[][] matrix,
                                          int[][] cMatrix,
                                          int[][] jMatrix,
                                          int cCount,
                                          int jCount,
                                          int k,
                                          int matrixSize,
                                          StringBuilder str,
                                          boolean triedFromImpossible) {
        boolean isCAssign = false, isJAssign = false;
        StringBuilder newStr = str;
        int[][] cMatrix1 = cMatrix;
        int[][] jMatrix1 = jMatrix;
        if (tryWith == 'C') {
            for (int l = 0; l < cCount; l++) {
                if ((matrix[k][0] > cMatrix[l][0] && matrix[k][0] < cMatrix[l][1]) ||
                    (matrix[k][0] < cMatrix[l][0] && matrix[k][1] > cMatrix[l][0]) ||
                    (matrix[k][1] > jMatrix[l][0] && matrix[k][1] < jMatrix[l][1])) {
                    isCAssign = true;
                }
            }
            if (isCAssign) {
                for (int l = 0; l < jCount; l++) {
                    if ((matrix[k][0] > jMatrix[l][0] && matrix[k][0] < jMatrix[l][1]) ||
                        (matrix[k][0] < jMatrix[l][0] && matrix[k][1] > jMatrix[l][0]) ||
                        (matrix[k][1] > jMatrix[l][0] && matrix[k][1] < jMatrix[l][1])) {
                        isJAssign = true;
                    }
                }
            }
            if (!isCAssign) {
                str.append("C");
                cMatrix[cCount][0] = matrix[k][0];
                cMatrix[cCount][1] = matrix[k][1];
                cCount++;
            } else if (isCAssign && !isJAssign) {
                str.append("J");
                jMatrix[jCount][0] = matrix[k][0];
                jMatrix[jCount][1] = matrix[k][1];
                jCount++;
            } else if (isCAssign && isJAssign) {
                str = new StringBuilder("IMPOSSIBLE");
            }
            
        } else if (tryWith == 'J') {
            for (int l = 0; l < jCount; l++) {
                if ((matrix[k][0] > jMatrix[l][0] && matrix[k][0] < jMatrix[l][1]) ||
                    (matrix[k][0] < jMatrix[l][0] && matrix[k][1] > jMatrix[l][0]) ||
                    (matrix[k][1] > jMatrix[l][0] && matrix[k][1] < jMatrix[l][1])) {
                    isJAssign = true;
                }
            }
            if (isJAssign) {
                for (int l = 0; l < cCount; l++) {
                    if ((matrix[k][0] > cMatrix[l][0] && matrix[k][0] < cMatrix[l][1]) ||
                        (matrix[k][0] < cMatrix[l][0] && matrix[k][1] > cMatrix[l][0]) ||
                        (matrix[k][1] > cMatrix[l][0] && matrix[k][1] < cMatrix[l][1])) {
                        isCAssign = true;
                    }
                }
            }
            if (!isJAssign) {
                str.append("J");
                jMatrix[jCount][0] = matrix[k][0];
                jMatrix[jCount][1] = matrix[k][1];
                jCount++;
            } else if (isJAssign && !isCAssign) {
                str.append("C");
                cMatrix[cCount][0] = matrix[k][0];
                cMatrix[cCount][1] = matrix[k][1];
                cCount++;
            } else if (isCAssign && isJAssign) {
                str = new StringBuilder("IMPOSSIBLE");
            }
        }
        if (!str.toString().equals("IMPOSSIBLE") && k < matrixSize - 1) {
            str = getString(tryWith, matrix, cMatrix, jMatrix, cCount, jCount, k + 1, matrixSize,
                str, triedFromImpossible);
        }
        if (str.toString().equals("IMPOSSIBLE") && !triedFromImpossible && k > 0) {
            if (tryWith == 'C') {
                tryWith = 'J';
            } else if (tryWith == 'J') {
                tryWith = 'C';
            }
            String str1 = newStr.toString();
            for (int l = 0; l < matrixSize; l++) {
                System.out.println();
                System.out.println(jMatrix[l][0] + " jMatrix  " + jMatrix[l][1]);
                System.out.println();
                System.out.println(cMatrix[l][0] + " cMatrix  " + cMatrix[l][1]);
                
            }
            if (str1.charAt(str1.length() - 1) == 'C') {
                for (int m = 0; m < matrixSize; m++) {
                    if (cMatrix[m][0] == matrix[k - 1][0]) {
                        cMatrix[m][0] = 0;
                        cMatrix[m][1] = 0;
                        cCount--;
                        break;
                    }
                }
            } else {
                for (int n = 0; n < matrixSize; n++) {
                    if (jMatrix[n][0] == matrix[k - 1][0]) {
                        jMatrix[n][0] = 0;
                        jMatrix[n][1] = 0;
                        jCount--;
                        break;
                    }
                }
            }
            newStr.setLength(newStr.length() - 1);
            str = getString(tryWith, matrix, cMatrix1, jMatrix1, cCount, jCount, k - 1,
                matrixSize,
                newStr, true);
        }
        return str;
    }
}
