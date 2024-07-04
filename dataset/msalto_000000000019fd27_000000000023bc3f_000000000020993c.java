
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int tc = 1; tc <= cases; ++tc) {
            int n = scanner.nextInt();
            int dupRows = 0;
            int dupCols = 0;
            int diagSum = 0;
            int len = n + 2;
            int[][] matrix = new int[n][n];
            for (int row = 0; row < n; ++row) {
                int[] counters = new int[len];
                boolean counted = false;
                for (int col = 0; col < n; ++col) {
                    int val = scanner.nextInt();
                    matrix[row][col] = val; 
                    if (++counters[val] > 1 && !counted) {
                        dupRows++;
                        counted = true;
                    }
                    if (row == col) {
                        diagSum += val;
                    }
                }
            }
            
            for (int col = 0; col < n; col++) {
                int[] counters = new int[len];
                boolean counted = false;
                for (int row = 0; row < n; row++) {
                    if (++counters[matrix[row][col]] > 1 && !counted) {
                        dupCols++;
                        counted = true;
                    }
                }
            }
            System.out.println("Case #" + tc + ": " + diagSum + " " + dupRows + " " + dupCols);
        }
    }
}
