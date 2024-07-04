import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(in,out);
        out.close();

    }

    static class Solver{
        public void solve(InputReader in, OutputWriter out){
            int t = in.nextInt();
            for(int i=1;i<=t;i++){
                int e = in.nextInt();
                int n = in.nextInt();
                String path = in.next();
                int min=0;
                char[] pathArr = path.toCharArray();
                for(int j=0;j<pathArr.length;j++){
                    if(e==0&&n==0){
                        break;
                    }
                    if(pathArr[j]=='N'){
                        n++;
                    }
                    else if(pathArr[j]=='S'){
                        n--;
                    }
                    else if(pathArr[j]=='E'){
                        e++;
                    }
                    else{
                        e--;
                    }
                    if(e>0){
                        e--;
                    }
                    else if(e<0){
                        e++;
                    }
                    else if(n>0){
                        n--;
                    }
                    else if(n<0){
                        n++;
                    }
                    min++;
                }
                if(e!=0||n!=0){
                    out.printf("Case #%d: IMPOSSIBLE\n",i);
                }
                else{
                    out.printf("Case #%d: %d\n",i,min);
                }


            }

        }
    }


    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            } else {
                if (this.curChar >= this.numChars) {
                    this.curChar = 0;

                    try {
                        this.numChars = this.stream.read(this.buf);
                    } catch (IOException var2) {
                        throw new InputMismatchException();
                    }

                    if (this.numChars <= 0) {
                        return -1;
                    }
                }

                return this.buf[this.curChar++];
            }
        }

        public int nextInt() {
            int c;
            for (c = this.read(); isSpaceChar(c); c = this.read()) {
                ;
            }

            byte sgn = 1;
            if (c == 45) {
                sgn = -1;
                c = this.read();
            }

            int res = 0;

            while (c >= 48 && c <= 57) {
                res *= 10;
                res += c - 48;
                c = this.read();
                if (isSpaceChar(c)) {
                    return res * sgn;
                }
            }

            throw new InputMismatchException();
        }

        public String next() {
            int c;
            while (isSpaceChar(c = this.read())) {
                ;
            }

            StringBuilder result = new StringBuilder();
            result.appendCodePoint(c);

            while (!isSpaceChar(c = this.read())) {
                result.appendCodePoint(c);
            }

            return result.toString();
        }

        public static boolean isSpaceChar(int c) {
            return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }

    }


}
