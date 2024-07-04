import java.io.*;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Solution {
    public static Print print = new Print();
    public static Scan scan = new Scan();

    public static void solve(int[][] mat, int n, int t) throws Exception {
        int trace = 0;
        int rows = 0;
        int cols = 0;

        for (int k = 0; k < n; k++) {
            trace += mat[k][k];
            HashSet<Integer> repRow = new HashSet<>();
            HashSet<Integer> repCol = new HashSet<>();
            boolean rowRep = false;
            boolean colRep = false;

            for (int i = 0; i < n; i++) {
                if (!rowRep && !repRow.add(mat[k][i])) {
                    rows++;
                    rowRep = true;
                }
                if (!colRep && !repCol.add(mat[i][k])) {
                    cols++;
                    colRep = true;
                }
                if (rowRep && colRep) break;
            }
        }
        print.println("Case #" + (t + 1) + ": " + trace + " " + rows + " " + cols);
    }

    public static void main(String[] args) throws Exception {
        int t = scan.scanInt();

        for (int i = 0; i < t; i++) {
            int n = scan.scanInt();
            int[][] mat = new int[n][n];

            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    mat[k][j] = scan.scanInt();
                }
            }
            solve(mat, n, i);
        }
        print.close();
    }
}

class Scan {
    private final byte[] buf = new byte[1024];
    private int index;
    private InputStream in;
    private int total;

    public Scan() {
        in = System.in;
    }

    public int scan() throws IOException {
        if (total < 0) throw new InputMismatchException();
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) return -1;
        }
        return buf[index++];
    }

    public int scanInt() throws IOException {
        int integer = 0;
        int n = scan();
        while (isWhiteSpace(n)) n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer = integer * 10 + (n - '0');
                n = scan();
            } else throw new InputMismatchException();
        }
        return neg * integer;
    }

    public double scanDouble() throws IOException {
        double doub = 0;
        int n = scan();
        while (isWhiteSpace(n)) n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n) && n != '.') {
            if (n >= '0' && n <= '9') {
                doub = doub * 10 + (n - '0');
                n = scan();
            } else throw new InputMismatchException();
        }
        if (n == '.') {
            n = scan();
            double temp = 1;
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    temp /= 10;
                    doub += (n - '0') * temp;
                    n = scan();
                } else throw new InputMismatchException();
            }
        }
        return doub * neg;
    }

    public String scanString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = scan();
        while (isWhiteSpace(n)) n = scan();
        while (!isWhiteSpace(n)) {
            sb.append((char) n);
            n = scan();
        }
        return sb.toString();
    }

    private boolean isWhiteSpace(int n) {
        return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1;
    }
}

class Print {
    private final BufferedWriter bw;

    public Print() {
        this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void print(Object object) throws IOException {
        bw.append(String.valueOf(object));
    }

    public void println(Object object) throws IOException {
        print(object);
        bw.append("\n");
    }

    public void close() throws IOException {
        bw.close();
    }
}