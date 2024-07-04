import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Solution {
    FastScan1D fs;
    PrintWriter pw;

    Solution() {
        fs = new FastScan1D();
        pw = new PrintWriter(System.out);
    }

    public static void main(String[] args) {
        Solution pr = new Solution();
        int T = pr.fs.nextInt();

        for (int i = 0; i < T; i++) {
            int noOfPatterns = pr.fs.nextInt();
            String result = "";
            int maxLenLeft = 0;
            int maxLenRight = 0;
            String maxStringLeft = "";
            String maxStringRight = "";

            List<String> listLeft = new ArrayList<>();
            List<String> listRight = new ArrayList<>();


            for (int j = 0; j < noOfPatterns; j++) {
                String str = pr.fs.nextLine();
                int starPos = str.indexOf("*");
                String strLeft = str.substring(0, starPos);
                StringBuilder sb = new StringBuilder(str.substring(starPos + 1, str.length()));
                String strRight = sb.reverse().toString();

                if (strLeft.length() > maxLenLeft) {
                    maxLenLeft = strLeft.length();
                    maxStringLeft = strLeft;
                }
                if (strRight.length() > maxLenRight) {
                    maxLenRight = strRight.length();
                    maxStringRight = strRight;
                }

                listLeft.add(strLeft);
                listRight.add(strRight);

                StringBuilder sbRight = new StringBuilder(maxStringRight);
                result = maxStringLeft + sbRight.reverse();
            }

            boolean possible = true;

            for(String s : listLeft){
                int len = s.length();
                if(!maxStringLeft.substring(0,len).equals(s)){
                    possible = false;
                    break;
                }
            }

            if(possible){
                for(String s : listRight){
                    int len = s.length();
                    if(!maxStringRight.substring(0,len).equals(s)){
                        possible = false;
                        break;
                    }
                }
            }

            pr.pw.println("Case #" + (i + 1) + ": " + (possible ? result : "*"));
        }
        pr.pw.close();
    }
}

class FastScan1D {
    private InputStream mIs;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FastScan1D() {
        this(System.in);
    }

    public FastScan1D(InputStream is) {
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
