import java.util.*;
import java.io.*;
public class Solution {

    private boolean linSearch(int[] input, int key){
        for (int i = 0; i <input.length ; i++) {
            if (input[i] == key) return true;
        }
        return false;
    }

    public int[] solve (int n, int[][] matrix){
        int trace = 0;
        int numRows = 0;
        int numCols = 0;
        for (int i=0; i<n; i++){
           trace+= matrix[i][i];
           int[] row = matrix[i];
           int[] seen = new int[n];
           boolean valid = true;
           //Checking rows for errors
           for(int j=0; j<n && valid; j++){
               boolean contains = linSearch(seen, row[j]);
               if(!contains){
                   seen[j]= row[j];
               }else{
                   valid =false;
                   numRows++;
               }
           }
           int[] seen2 = new int[n];
           valid = true;
           for(int j=0; j<n && valid; j++){
              boolean contains = linSearch(seen2,matrix[j][i]);
               if(!contains){
                  seen2[j] = matrix[j][i];
              }
              else{
                  valid = false;
                  numCols++;
              }
           }

        }
        return new int[]{trace, numRows, numCols};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution v = new Solution();
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for(int j=0; j<n; j++){
                for( int k=0; k<n; k++){
                    matrix[j][k] = in.nextInt();
                }
            }
            int[] solved = v.solve(n, matrix);
            System.out.println("Case #" + i + ": " + solved[0] + " " + solved[1] + " " + solved[2]);
        }
    }

}
