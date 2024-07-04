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
            String pat[] = new String[N], pre = "", mid = "", post = "";
            for(int i = 0; i < N; ++i) pat[i] = readLine();
            for(String p : pat) {
                String preP = p.substring(0, p.indexOf('*'));
                int len = min(pre.length(), preP.length());
                for(int i = 0; i < len; ++i) if(pre.charAt(i) != preP.charAt(i)) {
                    println("Case #" + (x++) + ": *");
                    continue next;
                }
                if(preP.length() > pre.length()) pre = preP;

                String postP = p.substring(p.lastIndexOf('*') + 1);
                int postLen = post.length(), postPLen = postP.length();
                len = min(postLen, postPLen);
                for(int i = 1; i <= len; ++i) if(post.charAt(postLen - i) != postP.charAt(postPLen - i)) {
                    println("Case #" + (x++) + ": *");
                    continue next;
                }
                if(postPLen > postLen) post = postP;

                String midP = p.substring(p.indexOf('*') + 1);
                while(midP.length() > 0 && midP.charAt(0) == '*') midP = midP.substring(1);
                if(midP.indexOf('*') != -1) {
                    midP = midP.substring(0, midP.lastIndexOf('*'));
                    midP = midP.replace("*", "");
                    mid += midP;
                }
            }
            println("Case #" + (x++) + ": " + pre + mid + post);
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