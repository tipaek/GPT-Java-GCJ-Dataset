import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        
        for (int s = 0; s < T; s++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            Map<Integer, Integer> map = new HashMap<>();
            
            // Read the matrix and calculate the trace
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    map.put(i * N + j, matrix[i][j]);
                }
            }
            
            // Check for row repetitions
            for (int i = 0; i < N; i++) {
                boolean[] rowCheck = new boolean[N + 1];
                for (int j = 0; j < N; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }
            
            // Check for column repetitions
            for (int j = 0; j < N; j++) {
                boolean[] colCheck = new boolean[N + 1];
                for (int i = 0; i < N; i++) {
                    if (colCheck[matrix[i][j]]) {
                        colRepeats++;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }
            }
            
            System.out.println("Case #" + (s + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}