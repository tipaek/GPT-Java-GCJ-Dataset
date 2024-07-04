import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            int trace = 0, rowDupCount = 0, colDupCount = 0;
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                boolean rowHasDups = false;
                
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowMap.containsKey(matrix[i][j])) {
                        rowMap.put(matrix[i][j], rowMap.get(matrix[i][j]) + 1);
                        rowHasDups = true;
                    } else {
                        rowMap.put(matrix[i][j], 1);
                    }
                }
                
                if (rowHasDups) {
                    rowDupCount++;
                }
            }
            
            for (int j = 0; j < N; j++) {
                HashMap<Integer, Integer> colMap = new HashMap<>();
                boolean colHasDups = false;
                
                for (int i = 0; i < N; i++) {
                    if (colMap.containsKey(matrix[i][j])) {
                        colMap.put(matrix[i][j], colMap.get(matrix[i][j]) + 1);
                        colHasDups = true;
                    } else {
                        colMap.put(matrix[i][j], 1);
                    }
                }
                
                if (colHasDups) {
                    colDupCount++;
                }
            }
            
            System.out.println("Case #" + test + ": " + trace + " " + rowDupCount + " " + colDupCount);
        }
    }
}