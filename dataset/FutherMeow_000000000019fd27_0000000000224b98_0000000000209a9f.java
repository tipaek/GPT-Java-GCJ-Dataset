import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

public class Solution {

    static final int LIM = 1000000;
    static char pre = '(';
    static char after = ')';
    static byte coutClose = 0;
    static boolean close;
    static void solve() throws Exception {
        close = false;
        coutClose = 0;
        StringBuilder result = new StringBuilder();
        String line = scanString();
        String[] chars = line.split("");
        byte first = Byte.valueOf(chars[0]);
        addPre(first, result);
        for(int i = 0; i < chars.length -1; i ++){
            byte start = Byte.valueOf(chars[i]);
            Byte end = Byte.valueOf(chars[i+1]);

            add(start, end, result);
        }

        byte end = Byte.valueOf(chars[chars.length-1]);
        result.append(end);
        addAfter(coutClose, result);
        printCase(result.toString());
    }

    static void addPre(int i, StringBuilder sb){
        close = false;
        for(int j = 0; j < i; j ++){
            sb.append(pre);
        }
        coutClose += i;
    }

    static void addAfter(int i, StringBuilder sb){
        close = true;
        for(int j = 0; j < i; j ++){
            sb.append(after);
        }
        coutClose -= i;
    }

    static void add(byte start, byte end, StringBuilder sb){
        sb.append(start);
        if(!close) {
           addWhenOpen(start, end, sb);
        }else {
            addWhenclose(start, end, sb);
        }
    }

    static void addWhenOpen(byte start, byte end, StringBuilder sb){
        if(start < end) {
            addPre(end -start, sb);
        }else {
            addAfter(start -end, sb);
        }
    }

    static void addWhenclose(byte start, byte end, StringBuilder sb){
        if(start > end){
            addAfter(start -end, sb);
        }else {
            addPre(end - start, sb);
        }
    }

    static int scanInt() throws IOException {
        return parseInt(scanString());
    }

    static String scanString() throws IOException {
            return in.readLine();
    }

    static void printCase(String result) {
        out.println("Case #" + test + ": " + result);
    }

    static BufferedReader in;
    static PrintWriter out;
    static int test;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int tests = scanInt();
            for (test = 1; test <= tests; test++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
}