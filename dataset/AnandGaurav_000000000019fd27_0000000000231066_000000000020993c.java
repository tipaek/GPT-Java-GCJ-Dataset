/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class Solution{
    public static int[] computeDuplicates(int size, int[][] matrix){
        int row_dup = 0; int col_dup = 0;
        int xor = 0;
        for(int i = 0; i < size; i++){
            HashSet<Integer> hs = new HashSet<>();
            hs.add(matrix[i][0]);
            for(int j = 1; j < size; j++){
                if (hs.contains(matrix[i][j]))
                {
                    row_dup++;
                    break;
                }
                hs.add(matrix[i][j]);
            }
        }
        
        for(int j = 0; j < size; j++){
            HashSet<Integer> hs = new HashSet<>();
            hs.add(matrix[0][j]);
            for(int i = 1; i < size; i++){
                
                if (hs.contains(matrix[i][j]))
                {
                    col_dup++;
                    break;
                }
                hs.add(matrix[i][j]);
            }
        }
        int[] dup_val = new int[]{row_dup, col_dup};
        
        return dup_val;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num_test = sc.nextInt();
        
        for(int test_num = 0; test_num < num_test; test_num++){
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];
            int diag_sum = 0;
            
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    matrix[i][j] = sc.nextInt();
                    
                    if ((i^j) == 0) diag_sum += matrix[i][j];
                }
            }
            
            int[] dup_val = computeDuplicates(size, matrix);
            
            System.out.println("Case #" + (test_num+1) + ": " + diag_sum + " " + dup_val[0] + " " + dup_val[1]);
        }
    }
}
