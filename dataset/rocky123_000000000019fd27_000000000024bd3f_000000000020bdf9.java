import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

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
            int N = pr.fs.nextInt();
            List<int[]> list = new ArrayList<>();;

            for(int a=0;a<N;a++){
                int start = pr.fs.nextInt();
                int end = pr.fs.nextInt();
                list.add(new int[]{start, end, a});
            }

            Collections.sort(list, (a,b) -> a[0]-b[0]);

            char[] res = new char[N];
            int jamieEndTime = 0;
            int charlieEndTime = 0;
            boolean possible = true;

            for (int j = 0; j < N; j++) {
                int start = list.get(j)[0];
                int end = list.get(j)[1];
                int pos = list.get(j)[2];

                if (charlieEndTime <= start){
                    res[pos] = 'C';
                    charlieEndTime = end;
                }
                else if(jamieEndTime <= start){
                    res[pos] = 'J';
                    jamieEndTime = end;
                }
                else{
                    possible = false;
                    break;
                }
            }

            pr.pw.println("Case #" + (i + 1) + ": " + (possible ? new String(res) : "IMPOSSIBLE"));
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
