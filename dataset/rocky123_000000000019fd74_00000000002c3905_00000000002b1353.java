import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class Solution {
    FastScan1B fs;
    PrintWriter pw;

    Solution() {
        fs = new FastScan1B();
        pw = new PrintWriter(System.out);
    }

    public static void main(String[] args) {
        Solution pr = new Solution();
        int T = pr.fs.nextInt();

        for (int i = 0; i < T; i++) {
            int N = pr.fs.nextInt();
            List<int[]> result = new ArrayList<int[]>();

            if(N==1)
                result.add(new int[]{1,1});
            else if(N<=1000){
                int lowTwoPower = 0;
                double soFar = 1;
                int x = N;
                while(x > soFar){
                    lowTwoPower++;
                    soFar += Math.pow(2, lowTwoPower);
                }
                soFar = soFar - Math.pow(2, lowTwoPower);
                lowTwoPower = lowTwoPower>0 ? lowTwoPower-1 : lowTwoPower;
                lowTwoPower++;

                double rem = N-soFar;
                boolean leftToRight = true;

                for(int a=1;a<=lowTwoPower;a++){
                    for(int b=1;b<=a;b++){
                        if(leftToRight){
                            result.add(new int[]{a, b});
                        }
                        else{
                            result.add(new int[]{a, a-b+1});
                        }
                    }
                    leftToRight = !leftToRight;
                }

                lowTwoPower++;

                for(int k=0;k<rem;k++){
                    result.add(new int[]{lowTwoPower+k, leftToRight?1:lowTwoPower+k});
                }
            }

            pr.pw.println("Case #" + (i + 1));
            for(int[] arr : result){
                pr.pw.println(arr[0] + " " + arr[1]);
            }
        }
        pr.pw.close();
    }
}

class FastScan1B {
    private InputStream mIs;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FastScan1B() {
        this(System.in);
    }

    public FastScan1B(InputStream is) {
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

