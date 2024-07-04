import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        InputStream is = System.in;
        OutputStream os = System.out;
        InputReader in = new InputReader(is);
        OutputWriter out = new OutputWriter(os);
        int t = in.readInt();
        for(int ii = 0; ii<t; ii++){
            int n = in.readInt();
            int d = in.readInt();
            int[] a = new int[n];
            Set<Integer> s = new HashSet<>();
            for(int i = 0; i<n; i++){
                a[i] = in.readInt();
                s.add(a[i]);
            }
            int ans = 1000;
            if(d == 2){
                if(s.size() == n)ans = 1;
                else ans = 0;
            } else{
                for(int i = 0; i<n; i++){
                    for(int j = 0; j<n; j++){
                        if(s.size() == n){
                            //no duplicates
                            if(a[j] == 2*a[i])ans = (int)Math.min(ans, 1);
                            else ans = (int)Math.min(ans, 2);
                        } else if(s.size() - 1 == n){
                            //1 pair of duplicates
                            if(a[j]%a[i] == 0 && j != i){
                                ans = (int)Math.min(ans, 1);
                            } else{
                                ans = (int)Math.min(ans, 2);
                            }
                        } else if(s.size()-2 == n){
                            //3 are same
                            ans = 0;
                        }
                    }
                }
            }
            out.printLine("Case #"+(ii+1)+": "+ans);
        }
        out.close();
    }

}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private InputReader.SpaceCharFilter filter;

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

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
        return readString();
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object...objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object...objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }
}