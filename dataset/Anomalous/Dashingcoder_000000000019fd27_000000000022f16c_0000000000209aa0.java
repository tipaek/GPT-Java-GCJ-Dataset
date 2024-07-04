import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(System.out, false);

    public static void main(String[] args) throws Exception {
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
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
                    pw.println("Case #" + t + ": IMPOSSIBLE");
                } else {
                    pw.println("Case #" + t + ": POSSIBLE");
                    fillMatrix(matrix, n, subMatrix, index);
                    printMatrix(matrix, n);
                }
            } else {
                pw.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        pw.flush();
    }

    private static void fillMatrix(int[][] matrix, int n, int[] subMatrix, int startIdx) {
        for (int i = 0; i < n; i++) {
            int e = (startIdx - i + n) % n;
            for (int j = 0; j < n; j++, e = (e + 1) % n) {
                matrix[i][j] = subMatrix[e];
            }
        }
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pw.print(matrix[i][j]);
                if (j < n - 1) {
                    pw.print(" ");
                }
            }
            pw.println();
        }
    }
}