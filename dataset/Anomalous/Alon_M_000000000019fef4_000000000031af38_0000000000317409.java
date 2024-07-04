import java.io.*;
import java.util.*;

public class Solution {

    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tok;
    private static int test;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int tests = Integer.parseInt(in.readLine().trim());
            for (test = 1; test <= tests; test++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void solve() throws IOException {
        boolean possible = false;
        int x = scanInt(), y = scanInt();
        String moves = scanString();
        int[] currPos = {x, y};

        printCase();

        for (int i = 0; !possible && i < moves.length(); i++) {
            currPos = updatePosition(currPos, moves.charAt(i));
            int dist = Math.abs(currPos[0]) + Math.abs(currPos[1]);
            if (dist <= (i + 1)) {
                out.println(i + 1);
                possible = true;
            }
        }
        if (!possible) {
            out.println("IMPOSSIBLE");
        }
    }

    private static int[] updatePosition(int[] curr, char direction) {
        switch (direction) {
            case 'E':
                curr[0]++;
                break;
            case 'W':
                curr[0]--;
                break;
            case 'N':
                curr[1]++;
                break;
            case 'S':
                curr[1]--;
                break;
        }
        return curr;
    }

    private static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    private static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    private static void printCase() {
        out.print("Case #" + test + ": ");
    }
}