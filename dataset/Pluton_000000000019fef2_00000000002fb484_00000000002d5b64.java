import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

class Solution/*Change to Solution When Submitting*/ {
    static BufferedReader __in;
    static PrintWriter __out;
    static StringTokenizer input;
    static int __case = 1;

    public static void main(String[] args) throws IOException {
        __in = new BufferedReader(new InputStreamReader(System.in));
        __out = new PrintWriter(new OutputStreamWriter(System.out));

        int T = readInt();
        while(T --> 0) {
            read();
            int R = nextInt(), S = nextInt();
            List<int[]> ans = solve(R, S);
            printCase(ans.size());
            for(int[] m : ans) {
                print(m[0]);
                print(" ");
                println(m[1]);
            }
        }

        close();
    }

    static List<int[]> solve(int r, int s) {
        List<int[]> ans = new ArrayList<>();
        if(s == 1) {
            return ans;
        } else {
            for(int i = 0; i < r - 1; ++i) {
                ans.add(new int[] {(r - 1) * s - i, s - 1});
            }
            ans.addAll(solve(r, s - 1));
        }
        return ans;
    }

    static final int IMAX = 2147483647;
    static final long LMAX = 9223372036854775807L;
    static void read() throws IOException {input = new StringTokenizer(__in.readLine());}
    static String readLine() throws IOException {return __in.readLine();}
    static int nextInt() {return Integer.parseInt(input.nextToken());}
    static int readInt() throws IOException {return Integer.parseInt(__in.readLine());}
    static void print(String s) {__out.print(s);}
    static void println(String s) {__out.println(s);}
    static void print(Object o) {__out.print(o);}
    static void println(Object o) {__out.println(o);}
    static void println() {__out.println();}
    static void printCase() {println("Case #" + (__case++) + ":");}
    static void printCase(Object o) {println("Case #" + (__case++) + ": " + o.toString());}
    static void close() {__out.close();}
}