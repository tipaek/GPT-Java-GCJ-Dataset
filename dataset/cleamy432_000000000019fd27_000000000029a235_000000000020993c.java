import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            
          int matrixSize = in.nextInt();
          int[][] matrix = new int[matrixSize][matrixSize];
          
          int trace = 0;
          int rowRep = 0; // Number of rows with repeated values
          int colRep = 0; // Number of columns with repeated values
          
          for(int r = 0; r < matrixSize; ++r){
              for(int c = 0; c < matrixSize; ++c){
                  matrix[r][c] = in.nextInt();
              }
              trace = trace + matrix[r][r];
              if(containsDuplicates(matrix[r])){
                rowRep++;
              }
          }
          colRep = countDuplicatesInCols(matrix);
          System.out.printf("Case #%d: %d %d %d\n", testCase, trace, rowRep, colRep);
        }
    }
    
    public static int countDuplicatesInCols(int[][] array){
        int count = 0;
        for(int c = 0; c < array[0].length; ++c){
            Set<Integer> set = new HashSet<>();
            for(int r = 0; r < array.length; ++r){
                if(!set.add(array[r][c])){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    
    public static boolean containsDuplicates(int[] array){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            if(!set.add(array[i])){
                return true;
            }
        }
        return false;
    }
}