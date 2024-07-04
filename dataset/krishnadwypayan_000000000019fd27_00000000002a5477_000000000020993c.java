import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Krishna Kota on 05/04/20
 */

public class SolutionA {

    static class Result {
        int trace;
        int rows;
        int cols;

        public Result(int trace, int rows, int cols) {
            this.trace = trace;
            this.rows = rows;
            this.cols = cols;
        }
    }

    private static Result getResult(int[][] arr, int n) {
        int trace = 0, rows = 0, cols = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();

            // scan row
            for (int j = 0; j < n; j++) {
                if (set.contains(arr[i][j])) {
                    rows++;
                    break;
                } else {
                    set.add(arr[i][j]);
                }
            }
            set = new HashSet<>();

            // scan col
            for (int j = 0; j < n; j++) {
                if (set.contains(arr[j][i])) {
                    cols++;
                    break;
                } else {
                    set.add(arr[j][i]);
                }
            }

            trace += arr[i][i];
        }
        return new Result(trace, rows, cols);
    }

    public static void main(String[] args) {
        Scanner in;
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int arr[][] = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = in.nextInt();
                }
            }

            Result result = getResult(arr, n);
            System.out.println("Case #" + i + ": " + result.trace + " " + result.rows + " " + result.cols);
        }
    }
}
