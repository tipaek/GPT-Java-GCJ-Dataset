import java.util.*;
import java.io.*;

public class Solution{
    
    public static void main(String []args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = in.nextInt();
        for (int caseNum = 0; caseNum < numOfCases; caseNum++) {
            int matrixSize = in.nextInt();
            int[][] mat = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    mat[i][j] = in.nextInt();
                }
            }
            int[] result = new int[3];
            result = calcCase(mat, matrixSize);
            System.out.println("Case #" + (caseNum+1) + ": " + 
            result[0] + " " +  result[1] + " " + result[2]);
        }
    }
    
    private static int[] calcCase(int[][]mat, int matrixSize) {
        int diagSum = 0;
        int numOfUnUniqRows = 0;
        int numOfUnUniqCols = 0;
        int cols[][] = new int[matrixSize][matrixSize];
        
        for (int i = 0; i < matrixSize; i++){
            for (int j = 0; j < matrixSize; j++) {
                cols[j][i] = mat[i][j];
            }
        }
        
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (i == j) {
                    diagSum += mat[i][j];         
                }
            }
        }
        
        for (int i = 0; i < matrixSize; i++) {
            if (isRowUniq(mat[i], matrixSize)) {
                numOfUnUniqRows++;
            }
        }
        
        for (int i = 0; i < matrixSize; i++) {
            if (isRowUniq(cols[i], matrixSize)) {
                numOfUnUniqCols++;
            }
        }
        int result[] = new int[3];
        result[0] = diagSum;
        result[1] = numOfUnUniqRows;
        result[2] = numOfUnUniqCols;
        return (result);
    }
    
    
    private static boolean isRowUniq(int row[], int size) {
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (i != j) {
                    if (row[i] == row[j]) {
                        return (true);
                    }
                }
            }
        }
        return (false);
    }
}
