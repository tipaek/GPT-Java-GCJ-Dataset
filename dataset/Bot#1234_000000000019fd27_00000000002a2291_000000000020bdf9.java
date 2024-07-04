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
            int t = Integer.parseInt(in.next());
            for(int i=1;i<=t;i++){
                int n = in.nextInt();
                int c = 0;
                int j = 0;
                int[][] activity = new int[n][3];
                for(int a=0;a<n;a++){
                    activity[a][0] = in.nextInt();
                    activity[a][1] = in.nextInt();
                    activity[a][2] = a;
                }

                Arrays.sort(activity, (a, b)-> a[0] - b[0]);

                boolean im = false;
                char[] ans = new char[n];
                for(int a=0;a<n;a++){
                    int start = activity[a][0];
                    int end = activity[a][1];
                    int index = activity[a][2];
                    if(start>=c&&!im){
                        c = end;
                        ans[index] = 'C';
                    }
                    else if(start>=j&&!im){
                        j = end;
                        ans[index] = 'J';
                    }
                    else{
                        im = true;
                        break;
                    }
                }
                if(!im){
                    out.printf("Case #%d: %s\n",i,new String(ans));
                }
                else{
                    out.printf("Case #%d: %s\n",i, "IMPOSSIBLE");
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
