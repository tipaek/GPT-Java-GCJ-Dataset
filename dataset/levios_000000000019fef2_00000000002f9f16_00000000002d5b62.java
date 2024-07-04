
import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * Round 1B - Code Jam 2020
 * A.
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = false; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2020\\r1b\\A\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int X,Y;
    private static void solve() {
        X = in.nextInt();
        Y = in.nextInt();
        String answer = "";
        if (X % 2 == Y % 2) {
            answer = "IMPOSSIBLE";
        } else {
            if (Y == -1) {
                if (X == -2) {
                    answer += "SW";
                } else if (X == -4) {
                    answer += "NSW";
                } else if (X == 2) {
                    answer += "SE";
                } else if (X == 4) {
                    answer += "NSE";
                }
            } else if (Y == -3) {
                if (X == -2) {
                    answer += "NWS";
                } else if (X == -4) {
                    answer += "SSW";
                } else if (X == 2) {
                    answer += "NES";
                } else if (X == 4) {
                    answer += "SSE";
                }
            } else if (Y == 1) {
                if (X == -2) {
                    answer += "NW";
                } else if (X == -4) {
                    answer += "SNW";
                } else if (X == 2) {
                    answer += "NE";
                } else if (X == 4) {
                    answer += "SNE";
                }
            } else if (Y == 3) {
                if (X == -2) {
                    answer += "SWN";
                } else if (X == -4) {
                    answer += "NNW";
                } else if (X == 2) {
                    answer += "SEN";
                } else if (X == 4) {
                    answer += "NNE";
                }
            } else if (Y == 0) {
                if (X == -1) {
                    answer += "W";
                } else if (X == -3) {
                    answer += "WW";
                } else if (X == 1) {
                    answer += "E";
                } else if (X == 3) {
                    answer += "EE";
                }
            } else if (Y == 2) {
                if (X == -1) {
                    answer += "WN";
                } else if (X == -3) {
                    answer += "ENW";
                } else if (X == 1) {
                    answer += "EN";
                } else if (X == 3) {
                    answer += "WEN";
                }
            } else if (Y == 4) {
                if (X == -1) {
                    answer += "EWN";
                } else if (X == -3) {
                    answer += "WWN";
                } else if (X == 1) {
                    answer += "WEN";
                } else if (X == 3) {
                    answer += "EEN";
                }
            } else if (Y == -2) {
                if (X == -1) {
                    answer += "WS";
                } else if (X == -3) {
                    answer += "ESW";
                } else if (X == 1) {
                    answer += "ES";
                } else if (X == 3) {
                    answer += "WSE";
                }
            } else if (Y == -4) {
                if (X == -1) {
                    answer += "EWS";
                } else if (X == -3) {
                    answer += "WWS";
                } else if (X == 1) {
                    answer += "WES";
                } else if (X == 3) {
                    answer += "EES";
                }
            }
        }

        print(answer);
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
