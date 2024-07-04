import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {

        
        Scanner in = new Scanner(System.in);
        int numOfCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numOfCases; i++) {
            int N = in.nextInt();
            int[][] mat = new int[N][N];
            int target = N*(N+1)/2;
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;
            boolean t = false;
            for (int j = 0; j < N; j++) {
                int rowSum = 0;
                int[] h = new int[N+1];
                Arrays.fill(h,0);
                for (int k = 0; k < N; k++) {

                    mat[j][k] = in.nextInt();
                    if(j == k) {
                        trace = trace + mat[j][k];
                    }

                    rowSum = rowSum+mat[j][k];
                    if(mat[j][k]>N || h[mat[j][k]] == 1){ t = true; }
                    h[mat[j][k]] = 1;
                }
                if(rowSum != target || t == true) rowCount++;
                t = false;
            }
            for (int j = 0; j < N; j++) {
                int colSum = 0;
                int[] h = new int[N+1];
                Arrays.fill(h,0);
                for (int k = 0; k < N; k++) {

                    colSum = colSum+mat[k][j];
                    if(mat[k][j]>N || h[mat[j][k]] == 1){ t = true; }
                    h[mat[k][j]] = 1;
                }
                if(colSum != target || t == true) colCount++;
                t = false;
            }
            System.out.println("Case #" + (i+1) + ": " + trace+" "+rowCount+" "+colCount);
        }

    }
}
