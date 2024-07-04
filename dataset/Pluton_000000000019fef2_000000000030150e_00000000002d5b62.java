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
        next: while(T --> 0) {
            read();
            int X = nextInt(), Y = nextInt();
            boolean negX = X < 0, negY = Y < 0;
            X = abs(X);
            Y = abs(Y);
            char[] x = ("0" + Integer.toBinaryString(X)).toCharArray(), y = ("0" + Integer.toBinaryString(Y)).toCharArray();
            int xlen = x.length, ylen = y.length, len = min(xlen, ylen), xcnt = 0, ycnt = 0;
            for(int i = 1; i <= len; ++i) {
                if(x[xlen - i] != '0' && y[ylen - i] != '0') {
                    if(xcnt == 0 && ycnt == 0) {
                        printCase("IMPOSSIBLE");
                        continue next;
                    } else if(xcnt > 0) {
                        x[xlen - i + xcnt] = '-';
                        int j = xlen - i + xcnt;
                        while(j > 0 && x[--j] == '1') {
                            x[j] = '0';
                        }
                        x[j] = '1';
                    } else {
                        y[ylen - i + ycnt] = '-';
                        int j = ylen - i + ycnt;
                        while(j > 0 && y[--j] == '1') {
                            y[j] = '0';
                        }
                        y[j] = '1';
                    }
                } else if(x[xlen - i] == '1') {
                    ++xcnt;
                } else if(y[ylen - i] == '1') {
                    ++ycnt;
                } else {
                    printCase("IMPOSSIBLE");
                    continue next;
                }
            }
            if(negX) {
                for(int i = 0; i < xlen; ++i) {
                    if(x[i] == '1') {
                        x[i] = '-';
                    } else if(x[i] == '-') {
                        x[i] = '1';
                    }
                }
            }
            if(negY) {
                for(int i = 0; i < ylen; ++i) {
                    if(y[i] == '1') {
                        y[i] = '-';
                    } else if(y[i] == '-') {
                        y[i] = '1';
                    }
                }
            }

            StringBuilder ans = new StringBuilder();
            len = max(xlen, ylen);
            for(int i = 1; i <= len; ++i) {
                if(xlen - i < 0) {
                    if(y[ylen - i] == '1') {
                        ans.append('N');
                    } else if(y[ylen - i] == '-') {
                        ans.append('S');
                    }
                } else {
                    if(x[xlen - i] == '1') {
                        ans.append('E');
                    } else if(x[xlen - i] == '-') {
                        ans.append('W');
                    } else if(ylen - i >= 0) {
                        if(y[ylen - i] == '1') {
                            ans.append('N');
                        } else if(y[ylen - i] == '-') {
                            ans.append('S');
                        }
                    }
                }
            }
            printCase(ans.toString());

        }

        close();
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