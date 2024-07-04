import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[][] arr = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[j][k] = in.nextInt();
                }
            }
            int trace = getTrace(arr);
            int[] repeatedVectors = repeatedVectors(arr);
            System.out.println(String.format("Case #%d: %d %d %d", i, trace, repeatedVectors[0], repeatedVectors[1]));
        }
    }

    private static int[] repeatedVectors(int[][] arr) {
        int repeatedRows = 0;
        int repeatedCols = 0;
                for (int r = 0; r < arr.length; r++) {
            int[] tempRow = new int[arr.length + 1];
            for (int c = 0; c < arr[0].length; c++) {
                if (tempRow[arr[r][c]] != 0) {
                    repeatedRows++;
                    break;
                }
                else tempRow[arr[r][c]] = 1;
            }
        }
        for (int c = 0; c < arr.length; c++) {
            int[] tempCol = new int[arr.length + 1];
            for (int r = 0; r < arr[0].length; r++) {
                if (tempCol[arr[r][c]] != 0) {
                    repeatedCols++;
                    break;
                }
                else tempCol[arr[r][c]] = 1;
            }
        }
        return new int[]{repeatedRows, repeatedCols};
    }

    public static int getTrace(int[][] arr) {
        int trace = 0;
        for (int r = 0, c = 0; r < arr.length && c < arr.length; r++, c++) {
            trace += arr[r][c];
        }
        return trace;
    }

}
       