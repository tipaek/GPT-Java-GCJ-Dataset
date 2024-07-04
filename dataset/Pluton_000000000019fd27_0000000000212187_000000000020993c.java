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

        int T = readInt();
        while(T --> 0) {
            int N = readInt(), k = 0, r = 0, c = 0;
            boolean used[][] = new boolean[2 * N][N], repeat[] = new boolean[2 * N];
            for(int i = 0; i < N; ++i) {
                read();
                for(int j = 0; j < N; ++j) {
                    int M = nextInt();
                    if (i == j) k += M;
                    if (used[i][M - 1]) repeat[i] = true;
                    else used[i][M - 1] = true;
                    if (used[N + j][M - 1]) repeat[N + j] = true;
                    else used[N + j][M - 1] = true;
                }
            }
            for(int i = 0; i < N; ++i) {
                if(repeat[i]) ++r;
                if(repeat[N + i]) ++c;
            }
            println("Case #" + (T + 1) + ": " + k + " " + r + " " + c);
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