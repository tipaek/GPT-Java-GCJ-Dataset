import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            solve(i, in);
        }
    }

    private static void solve(int caseNum, Scanner in) {
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                matrix[r][c] = in.nextInt();
            }
        }

        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        int rows = 0;
        for (int r = 0; r < n; r++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int c = 0; c < n; c++) {
                if (set.contains(matrix[r][c])) {
                    rows++;
                    break;
                }
                set.add(matrix[r][c]);
            }
        }

        int cols = 0;
        for (int c = 0; c < n; c++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int r = 0; r < n; r++) {
                if (set.contains(matrix[r][c])) {
                    cols++;
                    break;
                }
                set.add(matrix[r][c]);
            }
        }

        printTest(caseNum, new int[]{trace, rows, cols});
    }

    private static void printTest(int caseNum, int[] result) {
        System.out.print("Case #" + caseNum + "1:");
        for (int r: result) {
            System.out.print(" ");
            System.out.print(r);
        }
        System.out.println();
    }
}
