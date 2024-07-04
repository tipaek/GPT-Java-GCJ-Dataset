import java.util.Scanner;
import java.util.Arrays;
//...


class Solution {
    
    public static long diagSum(int[][] d, int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += d[i][i];
        }
        return sum;
    }
    
    public static void getColumn(int[][] d, int c, int[] f) {
        for (int r = 0; r < d.length; r++) {
            f[r] = d[r][c];
        }
    }
    
    public static boolean hasRepeats(int[] f, int n) {
        Arrays.sort(f);
        for (int i = 1; i < n; i++) {
            if (f[i] == f[i-1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int it = 0; it < t; it++) {
            int n = in.nextInt();
            int[][] datum = new int[n][];
            for (int j = 0; j < n; j++) {
                datum[j] = new int[n];
            }
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    datum[r][c] = in.nextInt();
                }
            }
            
            //
            long trace = diagSum(datum, n);
            int col = 0, row = 0;
            int[] tmp = new int[n];
            for (int c = 0; c < n; c++) {
                getColumn(datum, c, tmp);
                if (hasRepeats(tmp, n)) {
                    col++;
                }
            }
            for (int r = 0; r < n; r++) {
                if (hasRepeats(datum[r], n)) {
                    row++;
                }
            }

            System.out.println("Case #" + (it+1) + ": " + trace + " " + row + " " + col);
        }
    }
}