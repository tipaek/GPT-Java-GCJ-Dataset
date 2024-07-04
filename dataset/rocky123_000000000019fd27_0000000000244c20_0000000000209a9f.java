import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Solution {
    FastScan fs;
    PrintWriter pw;

    Solution() {
        fs = new FastScan();
        pw = new PrintWriter(System.out);
    }

    public static void main(String[] args) {
        Solution pr = new Solution();
        int T = pr.fs.nextInt();

        for (int i = 0; i < T; i++) {
            String in = pr.fs.nextLine();
            StringBuilder sb = new StringBuilder();
            int open = 0;

            for (int j = 0; j < in.length(); j++) {
                char c = in.charAt(j);
                int digit = Character.getNumericValue(c);

                while (open < digit) {
                    sb.append('(');
                    open++;
                }

                while (open > digit) {
                    sb.append(')');
                    open--;
                }

                sb.append(c);
            }

            while (open > 0){
                sb.append(')');
                open--;
            }
            pr.pw.println("Case #" + (i + 1) + ": " + sb.toString());
        }
        pr.pw.close();
    }
}

class FastScan {
    private InputStream mIs;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FastScan() {
        this(System.in);
    }

    public FastScan(InputStream is) {
        mIs = is;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = mIs.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }


    public String nextLine() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public int nextInt() {
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

    public boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; }

    public boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
}