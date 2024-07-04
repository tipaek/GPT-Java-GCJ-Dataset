import java.util.*;
import java.io.*;
import java.math.*;
 
class Solution {
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
        
        loop:for (int itr = 1; itr <= t; itr++) {
            n = in.nextInt();
            
            ArrayList<Node> act = new ArrayList<>();
            int arvC = 0, arvJ = 0;
            for (int i = 0; i < n; i++) {
                act.add(new Node(in.nextInt(), in.nextInt(), i));
            }
            Collections.sort(act);
            
            char[] ans = new char[n];
            for (int i = 0; i < n; i++) {
                if (arvC <= act.get(i).s) {
                    arvC = act.get(i).e;
                    ans[act.get(i).id] = 'C';
                } else if (arvJ <= act.get(i).s) {
                    arvJ = act.get(i).e;
                    ans[act.get(i).id] = 'J';
                } else {
                    out.println("Case #"+itr+": IMPOSSIBLE");
                    continue loop;
                }
            }
            StringBuilder res = new StringBuilder("");
            for (int i = 0; i < n; i++) res.append(ans[i]+"");
            
            out.println("Case #"+itr+": "+res);
        }
    }
 
    
    //<>
    
    static class Node implements Comparable<Node> {
        int s, e, id;
        
        Node (int s, int e, int id) {
            this.s = s;
            this.e = e;
            this.id = id;
        }
        
        public int compareTo(Node o) {
            return this.s - o.s;
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