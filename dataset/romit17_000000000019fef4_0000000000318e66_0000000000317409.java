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
        int x = ni(), y = ni();
        char[] m = ns().toCharArray();
        int n = m.length;
        
        for(int i=0;i<n;i++)
        {
            if(m[i]=='N') y++;
            if(m[i]=='S') y--;
            if(m[i]=='E') x++;
            if(m[i]=='W') x--;
            
            if(Math.abs(x)+Math.abs(y) <= i+1) 
            {
                out.println(i+1); return;
            }
        }
        out.println("IMPOSSIBLE");
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
