import java.io.*;
import java.util.*;

public class Solution{
    
    public static void main(String[] args) {
        @SuppressWarnings("resource") 
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = in.nextInt();
            int[][] matrix = new int[matrixSize][2];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < 2; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            StringBuilder str = getString('J', matrix, new int[matrixSize][2],
                new int[matrixSize][2], 0, 0, 0, matrixSize, new StringBuilder(),
                false, 0);
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
                                          boolean triedFromImpossible,
                                          int triedFromCount) {
        boolean isCAssign = false, isJAssign = false;
        StringBuilder newStr = str;
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
                str, triedFromImpossible, triedFromCount);
        }
        if (str.toString().equals("IMPOSSIBLE") && !triedFromImpossible && k > 0) {
            
                String str1 = newStr.toString();
                if (str1.charAt(str1.length() - 1) == 'C') {
                    int count = cCount;
                    for (int m = 0; m < count; m++) {
                        if (cMatrix[m][0] == matrix[k - 1][0]) {
                            cMatrix[m][0] = 0;
                            cMatrix[m][1] = 0;
                            cCount--;
                            k--;
                            tryWith = 'J';
                            break;
                        }
                    }
                } else {
                    int count = jCount;
                    for (int n = 0; n < count; n++) {
                        if (jMatrix[n][0] == matrix[k - 1][0]) {
                            jMatrix[n][0] = 0;
                            jMatrix[n][1] = 0;
                            jCount--;
                            k--;
                            tryWith = 'C';
                            break;
                        }
                    }
                }
                if (newStr.length() > 0) {
                    newStr.setLength(newStr.length() - 1);
                }
            
            str = getString(tryWith, matrix, cMatrix, jMatrix, cCount, jCount, k,
                matrixSize,
                newStr, true, k);
        }
        return str;
    }
}
