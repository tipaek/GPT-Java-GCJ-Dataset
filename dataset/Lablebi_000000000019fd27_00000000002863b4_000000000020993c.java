import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int trace = 0;
            int rows = 0;
            int col = 0;
            int n = in.nextInt();
            int sum = (n * (n + 1)) / 2;
            int[] columnSum = new int[n];
            int diagIndex = 0;
            for (int r = 0; r < n; r++) {
                int rowSum = 0;
                for (int c = 0; c < n; c++) {
                    int m = in.nextInt();
                    if (c == diagIndex) {
                        trace += m;
                    }
                    columnSum[c] += m;
                    rowSum += m;
                }
                diagIndex++;
                if (rowSum != sum) {
                    rows++;
                }
            }
            for (int j = 0; j < n; j++) {
                if (columnSum[j] != sum) {
                    col++;
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + rows + " " + col);
        }
    }
}