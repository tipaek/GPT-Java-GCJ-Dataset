import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                boolean hasRowDuplicates = false;
                
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowMap.put(matrix[i][j], rowMap.getOrDefault(matrix[i][j], 0) + 1);
                    if (rowMap.get(matrix[i][j]) > 1) {
                        hasRowDuplicates = true;
                    }
                }
                
                if (hasRowDuplicates) {
                    rowDuplicates++;
                }
            }
            
            for (int j = 0; j < N; j++) {
                HashMap<Integer, Integer> colMap = new HashMap<>();
                boolean hasColDuplicates = false;
                
                for (int i = 0; i < N; i++) {
                    colMap.put(matrix[i][j], colMap.getOrDefault(matrix[i][j], 0) + 1);
                    if (colMap.get(matrix[i][j]) > 1) {
                        hasColDuplicates = true;
                    }
                }
                
                if (hasColDuplicates) {
                    colDuplicates++;
                }
            }
            
            System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}