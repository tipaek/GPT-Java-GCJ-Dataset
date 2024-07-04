import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        // Input.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
           int N = Integer.parseInt(br.readLine());
           int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.print("Case #" + (i + 1) + ": ");
            Solve(N, matrix);
        }

    }

    // Solve method to process each input.
    public static void Solve(int N, int[][] matrix) {
        // Get diagonal sum.
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += matrix[i][i];
        }
        System.out.print(sum + " ");

        // Get Row duplicates.
        int RowDuplicate = 0;
        for (int i = 0; i < N; i++) {
            int[] duplicateCount = new int[N];
            for (int j = 0; j < N; j++) {
                duplicateCount[matrix[i][j] - 1]++;
                if(duplicateCount[matrix[i][j] - 1] > 1) {
                    RowDuplicate++;
                    break;
                }
            }
        }
        System.out.print(RowDuplicate + " ");

        // Get Column duplicates.
        int ColumnDuplicate = 0;
        for (int i = 0; i < N; i++) {
            int[] duplicateCount = new int[N];
            for (int j = 0; j < N; j++) {
                duplicateCount[matrix[j][i] - 1]++;
                if(duplicateCount[matrix[j][i] - 1] > 1) {
                    ColumnDuplicate++;
                    break;
                }
            }
        }
        System.out.println(ColumnDuplicate);

    }
}
