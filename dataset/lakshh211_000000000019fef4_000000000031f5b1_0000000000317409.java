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
            int x = in.readInt();
            int y = in.readInt();
            String path = in.readString();
            int ans = -1;
            for(int i = 0; i<path.length(); i++){
                char ch = path.charAt(i);
                if(ch == 'S')y--;
                else if(ch == 'N')y++;
                else if(ch == 'E')x++;
                else if(ch == 'W')x--;

                if(((int)(Math.abs(x)+Math.abs(y))) <= (i+1) || (x==0 && y==0)){
                    if(ans != -1){
                        ans = (int)Math.min(ans, (i+1));
                    } else{
                        ans = i+1;
                    }
                }
            }
            if(ans == -1){
                out.printLine("Case #"+(ii+1)+": IMPOSSIBLE");
            } else{
                out.printLine("Case #"+(ii+1)+": "+ans);
            }
            
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