import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            Scanner scan = new Scanner(System.in);
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }
            
            int trace = 0, rowCount = 0, colCount = 0;
            
            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) {
                    rowCount++;
                }
            }
            
            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) {
                    colCount++;
                }
            }
            
            System.out.println("#" + t + ": " + trace + " " + rowCount + " " + colCount);
        }
        
        out.flush();
        out.close();
    }
}