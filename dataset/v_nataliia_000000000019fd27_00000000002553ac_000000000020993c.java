import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int col = 1;
    int row = 1;
    int testCase = 1;
    
    while(in.hasNext()){
    int t = in.nextInt();
    int[] results = new int[3];
    int[][] matrix = new int[t][t];
    int diagonalSum = 0;

    for (int i = 0; i < t; ++i) {
        for(int j = 0; j < t; j++){
            int n = in.nextInt();
            matrix[i][j] = n;
            if(i == j){
                diagonalSum += n;
            }
        }
     }
    // TreeMap<Integer, Integer> rowMap = new TreeMap<Integer, Integer>();
   
    // TreeMap<Integer, Integer> columnMap = new TreeMap<Integer, Integer>();
     for(int i = 0; i <t; i++){
         TreeMap<Integer, Integer> rowMap = new TreeMap<Integer, Integer>();
            for(int j = 0; j< t; j++){
               // System.out.println(i);
                if(! rowMap.containsKey(matrix[i][j])){
                    rowMap.put(matrix[i][j], 1);
                }else{
                    results[1] += 1;
                    break;
                }
         }
     }
     
     for(int j = 0; j < t; j++){
        // System.out.println(j);
         TreeMap<Integer, Integer> columnMap = new TreeMap<Integer, Integer>();
            for(int i = 0; i < t; i++){
                if(! columnMap.containsKey(matrix[i][j])){
                    columnMap.put(matrix[i][j], 1);
                }else{
                    results[2] += 1;
                    break;
                }
                //  if(i == j){
                //     diagonalSum += n;
                // }
         }
     }
    //  System.out.println("rows:"+ results[1]);
    // System.out.println("columns:"+ results[2]);
    // System.out.println("diagonal sum"+diagonalSum);
    System.out.println("Case #"+testCase+ ": "+diagonalSum+" "+results[1]+" "+results[2]);
    testCase++;
    }
    
  }
  
    
}