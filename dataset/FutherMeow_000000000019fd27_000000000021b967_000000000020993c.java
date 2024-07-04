

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Solution {

    static final int LIM = 1000000;

    static void solve() throws Exception {

        int n = scanInt();
        int sum = 0;
        int countVerticle = 0;
        int countHoz = 0;

        HashSet[]  verSets = new HashSet[n];

        Boolean[] checkver = new Boolean[n];
        for (int i = 0; i < n ; i++) {
            Set<Integer> setHz = new HashSet<>(n);
            boolean checkHz = true;
            for (int j = 0; j < n; j++) {
                int v = scanInt();
                if(i == j)
                    sum = sum + v;
                if(checkHz && !setHz.add(v)){
                    countHoz ++;
                    checkHz = false;
                }

                if(verSets[j] == null){
                    verSets[j]= new HashSet<>(n);
                    checkver[j] = true;
                }

                if(checkver[j] &&!verSets[j].add(v)){
                    countVerticle ++;
                    checkver[j] = false;
                }
            }
        }

        String  result = sum + " " + countHoz +" " + countVerticle;
    }

    static int scanInt() throws IOException {
        return parseInt(scanString());
    }

    static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    static void printCase(String result) {
        out.println("Case #" + test + ": " + result);
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
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