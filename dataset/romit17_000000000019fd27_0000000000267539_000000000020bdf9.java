/*
 * @author romit17
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {
    
    void solve(PrintWriter out) throws IOException {
        int n = ni();
        data[] a = new data[2*n];
        for(int i=0;i<2*n;i+=2)
        {
            a[i] = new data(i/2, ni(), 1);
            a[i+1] = new data(i/2, ni(), -1);
        }
        Arrays.sort(a);
        int ovp = 0;
        for(data d:a)
        {
            ovp += d.ty;
            if(ovp>2)
            {
                out.println("IMPOSSIBLE"); return;
            }
        }
        
        int[] res = new int[n];
        int cur = 0;
        for(data d:a)
        {
            if(d.ty==-1)
            {
                int pr = res[d.id];
                cur &= ~(1<<pr);
                continue;
            }
            int pr = 0;
            if((cur&1) != 0) pr = 1;
            res[d.id] = pr;
            cur |= 1<<pr;
        }
        for(int i:res) out.print(i==0?'C':'J');
        out.println();
    }
    
    class data implements Comparable<data>
    {
        int id;
        int t;
        int ty;

        public data(int id, int t, int ty) {
            this.id = id;
            this.t = t;
            this.ty = ty;
        }

        @Override
        public int compareTo(data o) {
            if(this.t==o.t) return this.ty-o.ty;
            return this.t-o.t;
        }
        
    }
    
    void solvesolve() throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        int tc = ni();
        for (int i = 1; i <= tc; i++) {
            out.print("Case #" + i + ": ");
            solve(out);            
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        new Solution().solvesolve();
    }    
    
    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;    
    InputStream is = System.in;
    
    private int readByte() {
        if (lenbuf == -1) {
            throw new InputMismatchException();
        }
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) {
                return -1;
            }
        }
        return inbuf[ptrbuf++];
    }
    
    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }
    
    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }
    
    private double nd() {
        return Double.parseDouble(ns());
    }
    
    private char nc() {
        return (char) skip();
    }
    
    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    
    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }
    
    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = ns(m);
        }
        return map;
    }
    
    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        return a;
    }
    
    private int[] na1(int n) {
        int[] a = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            a[i] = ni();
        }
        return a;
    }
    
    private long[] nb(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nl();
        }
        return a;
    }
    
    private long[] nb1(int n) {
        long[] a = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            a[i] = nl();
        }
        return a;
    }
    
    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    
    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    
}
