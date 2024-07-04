import java.io.*;
import java.util.HashSet;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            
            int trace = calculateTrace(matrix, n);
            int repeatedRows = countRepeatedRows(matrix, n);
            int repeatedCols = countRepeatedCols(matrix, n);
            
            writer.write("Case #" + t + ": " + trace + " " + repeatedRows + " " + repeatedCols + "\n");
        }
        
        writer.flush();
    }
    
    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countRepeatedRows(int[][] matrix, int n) {
        int repeatedRows = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() != n) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }
    
    private static int countRepeatedCols(int[][] matrix, int n) {
        int repeatedCols = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                colSet.add(matrix[j][i]);
            }
            if (colSet.size() != n) {
                repeatedCols++;
            }
        }
        return repeatedCols;
    }
}