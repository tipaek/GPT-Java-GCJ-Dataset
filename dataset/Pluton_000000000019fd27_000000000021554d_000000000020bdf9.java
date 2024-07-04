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

        int T = readInt(), x = 1;
        next: while(T --> 0) {
            int N = readInt();
            Set<int[]> q = new TreeSet<>((a, b) -> a[0] == b[0] ? a[2] - b[2] : a[0] - b[0]);
            for(int i = 0; i < N; ++i) {
                read();
                q.add(new int[] {nextInt(), nextInt(), i});
            }
            int j = 0, c = 0;
            char[] str = new char[N];
            for(int[] a : q) {
                if(j > a[0]) {
                    if(c > a[0]) {
                        println("Case #" + (x++) + ": IMPOSSIBLE");
                        continue next;
                    } else {
                        c = a[1];
                        str[a[2]] = 'C';
                    }
                } else {
                    j = a[1];
                    str[a[2]] = 'J';
                }
            }
            println("Case #" + (x++) + ": " + new String(str));
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