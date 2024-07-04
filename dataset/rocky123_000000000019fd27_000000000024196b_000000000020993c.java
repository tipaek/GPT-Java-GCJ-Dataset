import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
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
            int size = pr.fs.nextInt();
            int rowRes = 0;
            int colRes = 0;
            int trace = 0;
            HashSet<Integer>[] colSets = new HashSet[size];

            for(int a=0;a<size;a++)
                colSets[a] = new HashSet<>();

            boolean []colCounted = new boolean[size];

            for (int r = 0; r < size; r++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowCounted = false;
                for (int c = 0; c < size; c++){
                    int currNo = pr.fs.nextInt();
                    if(r==c)
                        trace += currNo;

                    if(rowSet.contains(currNo)){
                        if(!rowCounted)
                            rowRes++;
                            rowCounted = true;
                    }
                    else
                        rowSet.add(currNo);

                    if(colSets[c].contains(currNo)){
                        if(!colCounted[c]){
                            colRes++;
                            colCounted[c] = true;
                        }
                    }
                    else
                        colSets[c].add(currNo);
                }
            }
            pr.pw.print("Case #" + (i + 1) + ": " + trace + " " + rowRes + " " + colRes);
            if(i<T-1) pr.pw.println();
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

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}
