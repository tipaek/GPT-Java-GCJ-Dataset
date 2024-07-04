import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(System.out, false);

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            if (k % n == 0) {
                int[][] matrix = new int[n][n];
                int[] subMatrix = new int[n];
                for (int j = 0; j < n; j++) {
                    subMatrix[j] = j + 1;
                }
                int diagNums = k / n;
                int index = Arrays.binarySearch(subMatrix, diagNums);
                
                if (index < 0) {
                    pw.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    pw.println("Case #" + i + ": POSSIBLE");
                    generateMatrix(matrix, n, subMatrix, index);
                    printMatrix(matrix, n);
                }
            } else {
                pw.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        
        pw.flush();
    }

    private static void generateMatrix(int[][] matrix, int n, int[] subMatrix, int index) {
        for (int i = 0; i < n; i++) {
            int e = (index - i + n) % n;
            for (int j = 0; j < n; j++) {
                matrix[i][j] = subMatrix[(e + j) % n];
            }
        }
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) pw.print(" ");
                pw.print(matrix[i][j]);
            }
            pw.println();
        }
    }
}