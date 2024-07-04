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
            int currmin = Integer.MAX_VALUE;
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

                int currentsteps = nextcatmove + 1;
                int minutes = Math.abs(catx - myx) + Math.abs(caty - myy);
                if (minutes <= currentsteps) {
                    done = true;
                    if (currentsteps < currmin) {
                        currmin = currentsteps;
                    }
                }

                nextcatmove++;
            }
            if (done) {
                ps.print("Case #" + t + ": " + currmin);
            } else {
                ps.print("Case #" + t + ": " + "IMPOSSIBLE");
            }
            if (t != T) ps.println();
        }
    }
}