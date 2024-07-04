
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Round 1C - Code Jam 2020
 * A.
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = false; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2020\\r1c\\A\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int x,y;
    static String m;
    private static void solve() {
        x = in.nextInt();
        y = in.nextInt();
        m = in.next();
        int steps = -1;
        boolean impossible = true;
        for (int i = 0; i < m.length(); i++) {
            char c = m.charAt(i);
            if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            } else if (c == 'S') {
                y--;
            } else if (c == 'N') {
                y++;
            }
            if(canGetThere(i+1)){
                impossible = false;
                steps = i + 1;
                break;
            }
        }
        if (impossible)
            print("IMPOSSIBLE");
        else {
            print("" + steps);
        }
    }

    private static boolean canGetThere(int steps) {
        int distance = Math.abs(x) + Math.abs(y);
        boolean isDistOk = distance <= steps;
        boolean exctly = true; //(steps - distance) % 2 == 0;
        return isDistOk & exctly;
    }

    private static void print(String s) {
        out.println(s); out.flush();
        if (debug) System.out.println(s);
    }

    private static Scanner in;
    private static PrintStream out;

    private static void run() throws Exception {
        if (debug) {
            in = new Scanner(new File(IN)); // new Scanner(Quali4.class.getResourceAsStream(IN));
            out = new PrintStream(new FileOutputStream(OUT));
        } else {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            out = System.out;
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            if (debug) System.out.print("Case #" + i + ": ");
            solve();
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        run();
    }
}
