import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    public static int sol[][];
    public static boolean gans;
    public static int mat[][];
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
            for (int i = 0; i < n; i++) {
                Arrays.fill(sol[i], -1);
            }
            backtrack(0, 0, n, k);
            if (gans) {
                out.write("Case #"+(t + 1)+": " +"POSSIBLE");
                out.newLine();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        out.write(Integer.toString(mat[i][j]) + " ");
                    }
                    out.newLine();
                }
            }
            else {
                out.write("Case #"+(t + 1)+": " +"IMPOSSIBLE");
                out.newLine();
                
            }
        }
        out.close();
    }
    private static void backtrack(int row, int col, int n, int k) {
        if (row >= n || col >= n)
            return;
        if (row == n - 1 && col == n - 1) {
            for (int val = 1; val <= n; val++) {
                if (isSafe(n - 1, n - 1, val, n, k)) {
                    sol[n - 1][n - 1] = val;
                    int ans = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i == j) {
                                ans += sol[i][j];
                            }
                        }
                    }
                    if (ans == k) {
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                mat[i][j] = sol[i][j];
                            }
                        }
                        gans = true;
                    }
                    sol[n - 1][n - 1] = -1;
                }
            }
            return;
        }
        for (int val = 1; val <= n; val++) {
            if (isSafe(row, col, val, n, k)) {
                sol[row][col] = val;
                if (col + 1 >= n) {
                    backtrack(row + 1, 0, n, k);
                }
                else {
                    backtrack(row, col + 1, n, k);
                }
                sol[row][col] = -1;
            }
        }
    }
    private static boolean isSafe(int row, int col, int val, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (sol[row][i] == val)
                return false;
        }
        for (int i = 0; i < n; i++) {
            if (sol[i][col] == val)
                return false;
        }
        return true;
    }
}
class InputReader {
    private boolean finished = false;

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int peek() {
        if (numChars == -1)
            return -1;
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                return -1;
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int length = readInt();
        if (length < 0)
            return null;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++)
            bytes[i] = (byte) read();
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bytes);
        }
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private String readLine0() {
        StringBuffer buf = new StringBuffer();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r')
                buf.appendCodePoint(c);
            c = read();
        }
        return buf.toString();
    }

    public String readLine() {
        String s = readLine0();
        while (s.trim().length() == 0)
            s = readLine0();
        return s;
    }

    public String readLine(boolean ignoreEmptyLines) {
        if (ignoreEmptyLines)
            return readLine();
        else
            return readLine0();
    }

    public BigInteger readBigInteger() {
        try {
            return new BigInteger(readString());
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }

    public char readCharacter() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        return (char) c;
    }

    public double readDouble() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E')
                return res * Math.pow(10, readInt());
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public boolean isExhausted() {
        int value;
        while (isSpaceChar(value = peek()) && value != -1)
            read();
        return value == -1;
    }

    public String next() {
        return readString();
    }

    public boolean readBoolean() {
        return readInt() == 1;
    }
}
