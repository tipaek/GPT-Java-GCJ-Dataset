import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

//ROUND 1B
public class Solution {

    public static void main(String[] args) {
        solveProblem1(System.in, System.out);
    }

    public static void solveProblem1(InputStream is, PrintStream ps) {
        Scanner s = new Scanner(new BufferedInputStream(is));
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            final int x = s.nextInt();
            final int y = s.nextInt();
            final String m = s.next();
            int catx = x;
            int caty = y;
            int myx = 0;
            int myy = 0;
            final int steps = m.length();
            int nextcatmove = 0;
            int minutes = 0;
            boolean done = false;
            while (nextcatmove < steps) {
                char c = m.charAt(nextcatmove);
                if (c == 'N') {
                    caty++;
                } else if (c == 'S') {
                    caty--;
                } else if (c == 'W') {
                    catx--;
                } else if (c == 'E') {
                    catx++;
                }
                if (myx == catx && myy == caty) {
                    //DONT MOVE
                } else if (catx > myx) {
                    myx++;
                } else if (catx < myx) {
                    myx--;
                } else if (caty > myy) {
                    myy++;
                } else if (caty < myy) {
                    myy--;
                }

                minutes++;
                nextcatmove++;
                if (myx == catx && myy == caty) {
                    done = true;
                    break;
                }
            }
            if (done) {
                ps.print("Case #" + t + ": " + minutes);
            } else {
                ps.print("Case #" + t + ": " + "IMPOSSIBLE");
            }
            if (t != T) ps.println();
        }
    }

    public static void solveProblem2(InputStream is, PrintStream ps) {
        Scanner s = new Scanner(new BufferedInputStream(is));
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            StringBuilder sol = new StringBuilder();
            ps.print("Case #" + t + ": " + sol.toString());
        }
    }

    public static void solveProblem3(InputStream is, PrintStream ps) {
        Scanner s = new Scanner(new BufferedInputStream(is));
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            StringBuilder sol = new StringBuilder();
            ps.print("Case #" + t + ": " + sol.toString());
        }
    }
}