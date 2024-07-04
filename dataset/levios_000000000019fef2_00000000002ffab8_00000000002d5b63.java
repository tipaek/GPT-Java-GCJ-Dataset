
import java.io.*;
import java.util.*;
import java.util.stream.*;
/**
 * Round 1B - Code Jam 2020
 * B.
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = false; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2019\\r1a\\B\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static void solve(int n, int m) {
        outer: for (int x = -5; x <= 5; x++) {
            for (int y = -5; y <= 5; y++) {
                String resp = request(x, y);
                if ("CENTER".equals(resp)) {
                    break outer;
                }
            }
        }
    }

    static String request(int x, int y) {
        String r = x + " " + y;
        out.println(r); out.flush();
        if (debug) file(r);
        String response = in.next();
        if (debug) file(response);
        if (response.equals("WRONG")) {
            System.exit(-1);
        }
        return response;
    }

    static void file(String s) {
        file.println(s); file.flush();
    }

    private static Scanner in;
    private static PrintStream out;
    private static PrintStream file;
    private static void run() throws Exception {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        out = System.out;
        if (debug) file = new PrintStream(new FileOutputStream(OUT));
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        if (debug) file("T, A, B: " + t + " " + a + " " + b);
        for (int i = 1; i <= t; i++) {
            solve(a, b);
        }
        in.close();
        out.close();
        if (debug) file.close();
    }

    public static void main(String[] args) throws Exception {
        run();
    }
}
