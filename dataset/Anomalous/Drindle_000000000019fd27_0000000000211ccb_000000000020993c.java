import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 0; i < t; ++i) {
            int length = in.nextInt();
            int[][] matrix = new int[length][length];
            
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix, length);
            int duplicateCols = countDuplicateColumns(matrix, length);
            
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
    
    public static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    public static int countDuplicateRows(int[][] matrix, int length) {
        int duplicateRows = 0;
        for (int j = 0; j < length; j++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int k = 0; k < length; k++) {
                if (!rowSet.add(matrix[j][k])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }
    
    public static int countDuplicateColumns(int[][] matrix, int length) {
        int duplicateCols = 0;
        for (int j = 0; j < length; j++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int k = 0; k < length; k++) {
                if (!colSet.add(matrix[k][j])) {
                    duplicateCols++;
                    break;
                }
            }
        }
        return duplicateCols;
    }
}