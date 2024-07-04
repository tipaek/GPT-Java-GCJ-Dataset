import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int T = Integer.parseInt(input.nextLine());
        String[] output = new String[T];
        
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(input.nextLine());
            int[][] matrix = new int[n][n];
            
            for (int x = 0; x < n; x++) {
                String[] lined = input.nextLine().split(" ");
                for (int y = 0; y < n; y++) {
                    matrix[x][y] = Integer.parseInt(lined[y]);
                }
            }
            output[t - 1] = latinSquare(t, n, matrix);
        }
        
        for (String result : output) {
            System.out.println(result);
        }
        
        input.close();
    }

    public static String latinSquare(int x, int n, int[][] matrix) {
        int k = 0;
        int r = 0;
        int c = 0;
        
        // Calculate the trace
        for (int i = 0; i < n; i++) {
            k += matrix[i][i];
        }
        
        // Check for repeated elements in rows
        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (rowCheck[matrix[i][j]]) {
                    r++;
                    break;
                }
                rowCheck[matrix[i][j]] = true;
            }
        }
        
        // Check for repeated elements in columns
        for (int j = 0; j < n; j++) {
            boolean[] colCheck = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                if (colCheck[matrix[i][j]]) {
                    c++;
                    break;
                }
                colCheck[matrix[i][j]] = true;
            }
        }
        
        return "Case #" + x + ": " + k + " " + r + " " + c;
    }
}