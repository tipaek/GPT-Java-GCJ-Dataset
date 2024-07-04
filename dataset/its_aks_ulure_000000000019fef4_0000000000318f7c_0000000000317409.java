import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Hola solver = new Hola();
        solver.solve(1, in, out);
        out.close();
    }

    static class Hola {
        PrintWriter out;
        InputReader in;
        long mod = (long)1e9 + 7;
        int MAXN = (int)2e5 + 5;
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.out = out;
            this.in = in;
            int t = ni();
            for(int test = 1; test <= t; test++){
                int x = ni(), y = ni();
                String s = in.next();
                int i = 0;
                int ans = -1;
                for(i = 0; i < s.length(); i++){
                    if(s.charAt(i) == 'E')
                        x++;
                    else if(s.charAt(i) == 'W')
                        x--;
                    else if(s.charAt(i) == 'S')
                        y--;
                    else
                        y++;
                    if(Math.abs(x) + Math.abs(y) <= i + 1) {
                        //pn(x +" "+y);
                        ans = i + 1;
                        break;
                    }
                }
                p("Case #"+test+": ");
                if(ans == -1)
                    pn("IMPOSSIBLE");
                else
                    pn(ans);
            }
        }


        void sort(int[] A){
            PriorityQueue<Integer> pq = new PriorityQueue();
            int i = 0;
            for(i = 0; i < A.length; i++)
                pq.add(A[i]);
            for(i = 0; i < A.length; i++)
                A[i] = pq.poll();
        }
        int gcd(int a, int b)
        {
            if (a == 0)
                return b;

            return gcd(b%a, a);
        }
        long mul(long a,long b){
            if(a>=mod)a%=mod;
            if(b>=mod)b%=mod;
            a*=b;
            if(a>=mod)a%=mod;
            return a;
        }
        long modPow(long a, long p){
            long o = 1;
            while(p>0){
                if((p&1)==1)o = mul(o,a);
                a = mul(a,a);
                p>>=1;
            }
            return o;
        }
        final Comparator<Tuple> com = new Comparator<Tuple>() {
            @Override
            public int compare(Tuple t1, Tuple t2) {
                if(t1.x != t2.x)
                    return Long.compare(t1.x, t2.x);
                else
                    return Long.compare(t1.y, t2.y);
            }
        };
        class Tuple{
            int x, y, z;
            Tuple(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        int ni() {
            return in.nextInt();
        }
        long nl() {
            return in.nextLong();
        }
        void pn(Object o) {
            out.println(o);
        }
        void p(Object o) {
            out.print(o);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
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

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}