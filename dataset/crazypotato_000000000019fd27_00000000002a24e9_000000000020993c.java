
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] input = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    input[j][k] = in.nextInt();
                }
            }
            Result r = new Checker(n, input).getResult();
            System.out.println("Case #" + i + ": " + (r.sum) + " " + (r.numRows) + " " + (r.numCols));
        }

    }


    public static class Checker {
        private final int[][] input;
        private final int n;

        public Checker(int n, int[][] input) {
            this.n = n;
            this.input = input;
        }

        public Result getResult() {
            int sum = 0;
            BigInteger[] cols = new BigInteger[n];
            BigInteger[] rows = new BigInteger[n];
            for (int r = 0; r < n; r++) {
                cols[r] = new BigInteger("0");
                System.err.println("row_" + r + rows[r]);
                for (int c = 0; c < n; c++) {
                    if (r == 0) {
                        rows[c] = new BigInteger("0");
                        System.err.println("col_" + c + cols[c]);
                    }
                    int val = input[r][c];
                    cols[r] = cols[r].setBit(val);
                    rows[c] = rows[c].setBit(val);
                    System.err.println("row_" + r + rows[c]);
                    System.err.println("col_" + c + cols[r]);
                    if (r == c) {
                        sum += val;
                    }
                }
            }
            int wrongRows = 0;
            int wrongCols = 0;

            for (int i = 0; i < n; i++) {
                BigInteger expected = BigInteger.valueOf(2).pow(n+1).subtract(BigInteger.ONE).subtract(BigInteger.ONE);
                System.err.println(expected);
                if (!cols[i].equals(expected)) {
                    wrongRows++;
                }
                if (!rows[i].equals(expected)) {
                    wrongCols++;
                }
            }

            return new Result(sum, wrongRows, wrongCols);
        }
    }

    public static class Result {
        public final int sum;
        public final int numRows;
        public final int numCols;

        public Result(int s, int r, int c) {
            this.sum = s;
            this.numRows = r;
            this.numCols = c;
        }

    }
}
