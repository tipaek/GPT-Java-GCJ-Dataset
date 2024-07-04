import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static int checkCounts(int rowcol[]) {
        int result = 0;
        for(int i=0; i<rowcol.length; i++) {
            if(rowcol[i] == 0) {
                result = 1;
            }
        }
        return result;
    }

    private static String vestigium(int N, int matrix[][]) {
        // Calculate the "trace"
        int k = 0;
        for(int i=0; i<N; i++) {
            k += matrix[i][i];
        }
        // Appearances Count
        int[] row = new int[N];
        int[] col = new int[N];
        // Erroneous count
        int errorRows = 0;
        int errorCols = 0;
        // Calculate the erroneous lines
        for(int i=0; i<N; i++) {
            // Initialize Appearances Count
            for(int j=0; j<N; j++) {
                row[j] = 0;
                col[j] = 0;
            }
            // Flag Appearances Count
            for(int j=0; j<N; j++) {
                row[matrix[i][j]-1] = 1;
                col[matrix[j][i]-1] = 1;
            }
            // Evaluate erroneous Rows/Cols
            errorRows += checkCounts(row);
            errorCols += checkCounts(col);
        }
        return " "+k+" "+errorRows+" "+errorCols;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Read T
        int test_cases_T = in.nextInt();
        // For each testcase
        for(int tc = 1; tc <= test_cases_T; tc++) {
            // Read N
            int N = in.nextInt();
            int matrix[][] = new int[N][N];
            // Read Matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            // Solve
            System.out.println("Case #"+tc+":"+vestigium(N, matrix));
        }
    }
}
