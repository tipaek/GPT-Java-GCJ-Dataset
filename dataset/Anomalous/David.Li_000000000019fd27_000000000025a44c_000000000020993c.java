import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeJam2020QP1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }
            
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(matrix[j])) {
                    rowDuplicates++;
                }
            }
            
            for (int j = 0; j < n; j++) {
                int[] col = new int[n];
                for (int k = 0; k < n; k++) {
                    col[k] = matrix[k][j];
                }
                if (hasDuplicates(col)) {
                    colDuplicates++;
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
    
    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }
}