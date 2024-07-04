import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer testCount = Integer.parseInt(in.nextLine());
    
        for(int test = 1; test <= testCount; test++){
            int n = Integer.parseInt(in.nextLine());
        
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] data = in.nextLine().split(" ");
                for(int j = 0; j < n; j++){
                    matrix[i][j] = Integer.parseInt(data[j]);
                }
            }
    
            int k = trace(matrix, n);
            int r = repetedRows(matrix, n);
            int c = repetedCols(matrix, n);

            System.out.println("Case #"+test+": "+k + " " + r + " " + c);
        }
    }
    
    private static int trace(int[][] matrix, int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += matrix[i][i];
        }
        
        return sum;
    }
    
    private static int repetedRows(int[][] matrix, int n){
        int count = 0;
        for(int i = 0; i < n; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < n; j++){
                if(set.contains(matrix[i][j])){
                    count++;
                    break;
                }
                set.add(matrix[i][j]);
            }
        }
        return count;
    }
    
    private static int repetedCols(int[][] matrix, int n){
        int count = 0;
        for(int j = 0; j < n; j++){
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i++){
                if(set.contains(matrix[i][j])){
                    count++;
                    break;
                }
                set.add(matrix[i][j]);
            }
        }
        return count;
    }
}