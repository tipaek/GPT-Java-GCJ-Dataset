import java.util.*;
import java.io.*;
class Solution{
    public static int trace(int[][] matrix){
        int trace = 0;
        for(int i=0;i<matrix.length;i++){
            trace+= matrix[i][i];
        }
        return trace;
    }
    public static int[] repeatRowsCols(int[][] matrix){
        int n = matrix.length;
        HashSet<Integer>[] rowSet = new HashSet[n];
        HashSet<Integer>[] colSet = new HashSet[n];
        int repeatCols = 0;
        int repeatRows = 0;
        for(int j=0;j<n;j++){
            colSet[j] = new HashSet<Integer>();
            rowSet[j] = new HashSet<Integer>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rowSet[i].add(matrix[i][j]);
                colSet[j].add(matrix[i][j]);
            }
        }
        for(int i=0;i<rowSet.length;i++){
            if(rowSet[i].size()<n) repeatRows++;
            if(colSet[i].size()<n) repeatCols++;
        }
        return new int[]{repeatRows, repeatCols};
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    matrix[j][k] = in.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + trace(matrix) + " " + repeatRowsCols(matrix)[0] + " " + repeatRowsCols(matrix)[1]);
        }
    }

}