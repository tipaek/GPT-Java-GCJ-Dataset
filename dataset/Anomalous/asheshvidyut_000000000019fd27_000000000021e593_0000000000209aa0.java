import java.io.*;
import java.util.*;

public class Solution {
    private static int[][] sol;
    private static boolean gans;
    private static int[][] mat;

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = in.readInt();
        
        for (int t = 0; t < tc; t++) {
            gans = false;
            int n = in.readInt();
            int k = in.readInt();
            sol = new int[n][n];
            mat = new int[n][n];
            
            for (int[] row : sol) {
                Arrays.fill(row, -1);
            }
            
            backtrack(0, 0, n, k);
            
            if (gans) {
                out.write("Case #" + (t + 1) + ": POSSIBLE");
                out.newLine();
                for (int[] row : mat) {
                    for (int val : row) {
                        out.write(val + " ");
                    }
                    out.newLine();
                }
            } else {
                out.write("Case #" + (t + 1) + ": IMPOSSIBLE");
                out.newLine();
            }
        }
        out.close();
    }

    private static void backtrack(int row, int col, int n, int k) {
        if (row >= n || col >= n) {
            return;
        }
        if (row == n - 1 && col == n - 1) {
            for (int val = 1; val <= n; val++) {
                if (isSafe(n - 1, n - 1, val, n)) {
                    sol[n - 1][n - 1] = val;
                    if (checkSolution(n, k)) {
                        gans = true;
                        for (int i = 0; i < n; i++) {
                            System.arraycopy(sol[i], 0, mat[i], 0, n);
                        }
                    }
                    sol[n - 1][n - 1] = -1;
                }
            }
            return;
        }
        for (int val = 1; val <= n; val++) {
            if (isSafe(row, col, val, n)) {
                sol[row][col] = val;
                if (col + 1 >= n) {
                    backtrack(row + 1, 0, n, k);
                } else {
                    backtrack(row, col + 1, n, k);
                }
                sol[row][col] = -1;
            }
        }
    }

    private static boolean isSafe(int row, int col, int val, int n) {
        for (int i = 0; i < n; i++) {
            if (sol[row][i] == val || sol[i][col] == val) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSolution(int n, int k) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sol[i][i];
        }
        return sum == k;
    }
}

class InputReader {
    private final InputStream stream;
    private final byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    private int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    private static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}