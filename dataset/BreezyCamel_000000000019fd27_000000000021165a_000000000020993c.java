import java.io.*;
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
                int[][] arr = new int[n][n];
                for(int a=0;a<n;a++){
                    for(int b=0;b<n;b++){
                        arr[a][b] = in.nextInt();
                    }
                }
                int k = 0;
                for(int j=0;j<n;j++){
                    k+=arr[j][j];
                }

                int r = 0;
                for(int a=0;a<n;a++){
                    HashSet<Integer> row = new HashSet<>();
                    for(int b=0;b<n;b++){
                        if(!row.add(arr[a][b])){
                            r++;
                            break;
                        }
                    }
                }

                int c = 0;
                for(int a=0;a<n;a++){
                    HashSet<Integer> col = new HashSet<>();
                    for(int b=0;b<n;b++){
                        if(!col.add(arr[b][a])){
                            c++;
                            break;
                        }
                    }
                }

                out.printf("Case #%d: %d %d %d\n", i,k,r,c);
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
