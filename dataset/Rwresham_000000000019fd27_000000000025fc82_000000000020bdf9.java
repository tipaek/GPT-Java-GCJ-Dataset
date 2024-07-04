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
            str.append("C");
            cMatrix[cCount][0] = matrix[0][0];
            cMatrix[cCount][1] = matrix[0][1];
            cCount++;
            for (int k = 1; k < matrixSize; k++) {
                boolean isCAssign = false, isJAssign = false;
                if(!impossible) {
                    for (int l = 0; l < cCount; l++) {
                        if (matrix[k][0] > cMatrix[l][0] && matrix[k][0] < cMatrix[l][1] ||
                                matrix[k][1] > cMatrix[l][0] && matrix[k][1] < cMatrix[l][1]) {
                            isCAssign = true;
                        }
                    }
                    if (isCAssign) {
                        for (int l = 0; l < jCount; l++) {
                            if (matrix[k][0] > jMatrix[l][0] && matrix[k][0] < jMatrix[l][1] ||
                                    matrix[k][1] > jMatrix[l][0] && matrix[k][1] < jMatrix[l][1]) {
                                isJAssign = true;
                            }
                        }                        
                    }
                    if (!isCAssign) {
                        str.append("C");
                        cMatrix[0][0] = matrix[k][0];
                        cMatrix[0][1] = matrix[k][1];
                        cCount++;
                    } else if (isCAssign && !isJAssign) {
                        str.append("J");
                        jMatrix[jCount][0] = matrix[k][0];
                        jMatrix[jCount][1] = matrix[k][1];
                        jCount++;
                    } else if (isCAssign && isJAssign) {
                        impossible = true;
                        str.replace(0, str.length(), "IMPOSSIBLE");
                    }
                } else {
                    break;
                }
            }
            System.out.println("Case #" + t + ": " + str);
        }
    }    
}
