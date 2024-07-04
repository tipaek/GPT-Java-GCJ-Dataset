import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static int calTrace(int[][] m, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += m[i][i];
        }
        return trace;
    }

    public static int calRepeatedRows(int[][] m, int N) {
        int r = 0;
        for (int row = 0; row < N; row++) {
            int[] occurences = new int[N];
            for (int col = 0; col < N; col++) {
                occurences[m[row][col] - 1]++;
                if (occurences[m[row][col] - 1] > 1) {
                    r++;
                    break;
                }
            }
        }
        return r;
    }

    public static int calRepeatedCols(int[][] m, int N) {
        int c = 0;
        for (int col = 0; col < N; col++) {
            int[] occurences = new int[N];
            for (int row = 0; row < N; row++) {
                occurences[m[row][col] - 1]++;
                if (occurences[m[row][col] - 1] > 1) {
                    c++;
                    break;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            int N = Integer.parseInt(in.nextLine());
            int[][] matrix = new int[N][N];
            for (int row = 0; row < N; row++) {
                StringTokenizer st = new StringTokenizer(in.nextLine());
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            int trace = calTrace(matrix, N);
            int r = calRepeatedRows(matrix, N);
            int c = calRepeatedCols(matrix, N);
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }
}
