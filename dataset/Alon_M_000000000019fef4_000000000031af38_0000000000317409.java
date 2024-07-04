import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

import java.io.*;
import java.util.*;


public class Solution {


    static void solve() throws Exception {
        boolean possible = false;
        int x = scanInt(), y = scanInt();
        String moves = scanString();
        int[] currPos = {x,y};

        printCase();

        for (int i = 0; !possible && i<moves.length(); i++){
            currPos = position(currPos, moves.charAt(i));
            int dist = Math.abs(currPos[0]) + Math.abs(currPos[1]);
            if (dist <= (i + 1)){
                out.println(i+1);
                possible = true;
            }
        }
        if (!possible){
            out.println("IMPOSSIBLE");
        }
    }

    static int[] position(int[] curr, char direction){
        if (direction == 'E'){
            curr[0] ++;
        }
        else if (direction == 'W'){
            curr[0] --;
        }
        else if (direction == 'N'){
            curr[1] ++;
        }
        else {
            curr[1] --;
        }

        return curr;
    }

    static int scanInt() throws IOException {
        return parseInt(scanString());
    }

    static long scanLong() throws IOException {
        return parseLong(scanString());
    }

    static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    static void printlnCase() {
        out.println("Case #" + test + ":");
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