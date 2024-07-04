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
    static int n, m, t, k, q, d;
    
    void solve(PrintWriter out, Reader in) throws IOException{
        t = in.nextInt();
        
        for (int itr = 1; itr <= t; itr++) {
            n = in.nextInt();
            d = in.nextInt();
            
            double[][] div = new double[n][d];
            double[] arr = new double[n];
            double sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                sum += arr[i];
            }
            
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                div[i][1] = arr[i];
            }
            
            ArrayList<Double> list = new ArrayList<>();
            double x = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < d; j++) {
                    x = arr[i]/(double)j;
                    div[i][j] = x;
                    list.add(x);
                }
            }
            
            boolean flag = false;
            int ans = d-1, rest = 0, cuts = 0, have = 0;
            for (int z = 0; z < list.size(); z++) {
                x = list.get(z);
                rest = 0; cuts = 0; have = 0;
                
                for (int i = 0; i < n; i++) {
                    flag = false;
                    for (int j = 1; j < d; j++) {
                        if (div[i][j] == x) {
                            if (have+j > d) {
                                cuts += d-have;
                                have = d;
                            } else {
                                have += j;
                                cuts += j-1;
                            }
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) rest += (int)(arr[i]/x);
                }
                if (have == d) ans = Math.min(ans, cuts);
                else {
                    if (rest+have >= d) ans = Math.min(ans, cuts+d-have);
                }
            }
            
            
            out.println("Case #"+itr+": "+ans);
        }
    }
 
    
    //<>
    
    static class Node {
        int pieces, cuts;
        
        Node (int pieces, int cuts) {
            this.pieces = pieces;
            this.cuts = cuts;
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
