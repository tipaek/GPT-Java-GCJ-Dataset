import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Solution {
    FastScan1A fs;
    PrintWriter pw;

    Solution() {
        fs = new FastScan1A();
        pw = new PrintWriter(System.out);
    }

    public static void main(String[] args) {
        Solution pr = new Solution();
        int T = pr.fs.nextInt();

        for (int i = 0; i < T; i++) {
            int noOfPatterns = pr.fs.nextInt();
            StringBuilder result = new StringBuilder();
            int maxLen = 0;
            String maxString = "";
            List<String> list = new ArrayList<>();

            for (int j = 0; j < noOfPatterns; j++) {
                StringBuilder sb = new StringBuilder(pr.fs.nextLine());
                String s = sb.substring(1, sb.length());

                if(s.length() > maxLen){
                    maxLen = s.length();
                    maxString = s;
                }

                list.add(s);
            }

            for(String s : list){
                if(!maxString.contains(s)){
                    maxString = "*";
                    break;
                }
            }

            pr.pw.println("Case #" + (i + 1) + ": " + maxString);
        }
        pr.pw.close();
    }
}

class FastScan1A {
    private InputStream mIs;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FastScan1A() {
        this(System.in);
    }

    public FastScan1A(InputStream is) {
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
