import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        OverexcitedFan solver = new OverexcitedFan();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static final class OverexcitedFan {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String moves = in.next();

            int soonest = moves.length() + 1;
            if (X == 0 && Y == 0) {
                soonest = 0;
            } else {
                for (int step = 1; step <= moves.length(); ++step) {
                    switch (moves.charAt(step - 1)) {
                        case 'S':
                            --Y;
                            break;
                        case 'N':
                            ++Y;
                            break;
                        case 'E':
                            ++X;
                            break;
                        case 'W':
                            --X;
                            break;
                    }
                    if (step >= Math.abs(X) + Math.abs(Y)) {
                        soonest = step;
                        break;
                    }
                }
            }

            if (soonest <= moves.length()) {
                out.println(String.format("Case #%d: %d", testNumber, soonest));
            } else {
                out.println(String.format("Case #%d: IMPOSSIBLE", testNumber));
            }
        }

    }
}

