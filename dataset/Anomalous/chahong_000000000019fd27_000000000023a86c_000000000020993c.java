import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int crossSum = 0;
            int row = 0, col = 0;
            int[][] matrix = new int[t][t];
            
            for (int j = 0; j < t; j++) {
                for (int k = 0; k < t; k++) {
                    int num = sc.nextInt();
                    matrix[j][k] = num;
                    if (j == k) {
                        crossSum += num;
                    }
                }
            }
            
            for (int j = 0; j < t; j++) {
                int[] rowSum = new int[t + 1];
                int[] colSum = new int[t + 1];
                boolean rowCheck = false;
                boolean colCheck = false;
                
                for (int k = 0; k < t; k++) {
                    rowSum[matrix[j][k]]++;
                    colSum[matrix[k][j]]++;
                    
                    if (rowSum[matrix[j][k]] >= 2 && !rowCheck) {
                        row++;
                        rowCheck = true;
                    }
                    
                    if (colSum[matrix[k][j]] >= 2 && !colCheck) {
                        col++;
                        colCheck = true;
                    }
                }
            }
            
            System.out.println(crossSum + " " + row + " " + col);
        }
    }
}