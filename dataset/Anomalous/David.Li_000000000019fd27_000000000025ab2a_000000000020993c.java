import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeJam2020QP1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            
            int trace = 0, rowCount = 0, colCount = 0;
            
            // Calculate trace
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }
            
            // Check for duplicate elements in rows
            for (int j = 0; j < n; j++) {
                boolean[] rowCheck = new boolean[n];
                for (int k = 0; k < n; k++) {
                    if (rowCheck[matrix[j][k] - 1]) {
                        rowCount++;
                        break;
                    }
                    rowCheck[matrix[j][k] - 1] = true;
                }
            }
            
            // Check for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n];
                for (int k = 0; k < n; k++) {
                    if (colCheck[matrix[k][j] - 1]) {
                        colCount++;
                        break;
                    }
                    colCheck[matrix[k][j] - 1] = true;
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}