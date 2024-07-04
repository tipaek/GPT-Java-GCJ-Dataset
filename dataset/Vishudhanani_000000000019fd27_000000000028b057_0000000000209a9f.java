import java.io.*;
import java.util.*;

class Solution {

    public static void main(String args[]) throws Exception{
         Reader s = new Reader();
         int t = s.nextInt();
         OutputStream out = new BufferedOutputStream(System.out);

        for (int i = 1; i <=t ; i++) {

             out.write("Case #".getBytes());
             out.write((i+": ").getBytes());


             char ch[] = s.next().toCharArray();

             int num = ch[0] - 48;

             for(int j=0;j<num;j++){
                 out.write("(".getBytes());
             }


             for(int j=0;j<ch.length-1;j++){
                 int dif = ch[j+1] - ch[j];
                 out.write(String.valueOf(ch[j]).getBytes());
                 if(dif < 0){
                     dif = Math.abs(dif);
                     for (int k = 0; k <dif ; k++) {
                         out.write(")".getBytes());
                     }
                 }
                 else{
                     for (int k = 0; k <dif ; k++) {
                         out.write("(".getBytes());
                     }
                 }
             }




             num = ch[ch.length-1] - 48;
             out.write(String.valueOf(ch[ch.length-1]).getBytes());
             for(int j=0;j<num;j++){
                 out.write(")".getBytes());
             }

             out.write("\n".getBytes());
             out.flush();

         }



    }
    static class Reader {

        private InputStream mIs;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public Reader() {
            this(System.in);
        }

        public Reader(InputStream is) {
            mIs = is;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();

            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = mIs.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

    }

}
