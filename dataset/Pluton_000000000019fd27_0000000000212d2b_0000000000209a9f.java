import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

class Solution {
    static BufferedReader $in;
    static PrintWriter $out;
    static StringTokenizer input;

    public static void main(String[] args) throws IOException {
        $in = new BufferedReader(new InputStreamReader(System.in));
        $out = new PrintWriter(new OutputStreamWriter(System.out));

        int T = readInt(), xx = 1;
        while(T --> 0) {
            char[] S = readLine().toCharArray();
            StringBuilder buf = new StringBuilder();
            int cnt = 0;
            for(char c : S) {
                int x = c - '0';
                if(x > cnt) for(; cnt < x; ++cnt) buf.append('(');
                else if(x < cnt) for(; cnt > x; --cnt) buf.append(')');
                buf.append(c);
            }
            while(cnt --> 0) buf.append(')');
            println("Case #" + (xx++) + ": " + buf.toString());
        }

        close();
    }

    static final int IMAX = 2147483647;
    static final long LMAX = 9223372036854775807L;
    static void read() throws IOException {input = new StringTokenizer($in.readLine());}
    static String readLine() throws IOException {return $in.readLine();}
    static int nextInt() {return Integer.parseInt(input.nextToken());}
    static int readInt() throws IOException {return Integer.parseInt($in.readLine());}
    static void print(Object o) {$out.print(o);}
    static void println(Object o) {$out.println(o);}
    static void close() {$out.close();}
}