import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Solution {
    FastScan1CP1 fs;
    PrintWriter pw;

    Solution() {
        fs = new FastScan1CP1();
        pw = new PrintWriter(System.out);
    }

    public static void main(String[] args) {
        Solution pr = new Solution();
        int T = pr.fs.nextInt();

        for (int i = 0; i < T; i++) {
            int X = pr.fs.nextInt();
            int Y = pr.fs.nextInt();
            String M = pr.fs.nextString();
            char[] MArr = M.toCharArray();
            int result = 0;
            boolean isPossible = false;

            result += X-0;
            int currY = Y;
            int currMins = X-0;

            if(X>MArr.length){
                pr.pw.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
                continue;
            }

            for(int a=0;a<currMins && a<MArr.length;a++){
                if(MArr[a] == 'N'){
                    currY++;
                }
                else if(MArr[a] == 'S'){
                    currY--;
                }
            }

            int minsPassed = 0;

            if(currY == 0){
                isPossible = true;
            }
            else {
                for (int a = currMins; a < MArr.length; a++) {
                    minsPassed++;
                    if (MArr[a] == 'N') {
                        currY++;
                    } else if (MArr[a] == 'S') {
                        currY--;
                    }
                    if(Math.abs(currY) <= minsPassed){
                        isPossible = true;
                        break;
                    }
                }
            }


            pr.pw.println("Case #" + (i + 1) + ": " + (isPossible ? result+minsPassed : "IMPOSSIBLE"));
        }
        pr.pw.close();
    }
}

class FastScan1CP1 {
    private InputStream mIs;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FastScan1CP1() {
        this(System.in);
    }

    public FastScan1CP1(InputStream is) {
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

    public String nextString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
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
