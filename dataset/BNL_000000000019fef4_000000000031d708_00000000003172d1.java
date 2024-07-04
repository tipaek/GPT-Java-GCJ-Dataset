import java.util.*;
import java.io.*;
import java.math.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        //PrintWriter out = new PrintWriter(new File("out.txt"));
        PrintWriter out = new PrintWriter(System.out);
        //Reader in = new Reader(new FileInputStream("in.txt"));
        Reader in = new Reader();
        Solution solver = new Solution();
        solver.solve(out, in);
        out.flush();
        out.close();
 
    }
 
 
    static int maxn = 5*(int)1e5+5;
    static long mod=(int)1e9+7;
    static int n, m, t, k, q;
    
    void solve(PrintWriter out, Reader in) throws IOException{
        t = in.nextInt();
        
        for (int itr = 1; itr <= t; itr++) {
            n = in.nextInt();
            int d = in.nextInt();
            
            long ans = 0, tmp = 0, max = 0;
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
                max = Math.max(max, arr[i]);
            }
            
            for (int i = 0; i < n; i++) {
                tmp = 1;
                for (int j = i+1; j < n; j++) {
                    if (arr[j] == arr[i]) tmp++;
                }
                ans = Math.max(ans, tmp);
            }
            
            if (ans >= d) out.println("Case #"+itr+": 0");
            else {
                if (d == 2) {
                    out.println("Case #"+itr+": 1");
                } else {
                    int res = 2;
                    if (ans == 2) {
                        for (int i = 0; i < n; i++) {
                            tmp = 1;
                            for (int j = i+1; j < n; j++) {
                                if (arr[i] == arr[j]) tmp++;
                            }
                            if (tmp == 2 && max > arr[i]) {
                                res = 1;
                            }
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (arr[i]*2 == arr[j]) res = 1;
                        }
                    }
                    out.println("Case #"+itr+": "+res);
                }
            }
        }
    }
 
    
    //<>
    
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
