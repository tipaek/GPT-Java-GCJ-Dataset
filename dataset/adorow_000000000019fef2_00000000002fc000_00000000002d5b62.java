import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;


public class Solution {

    private static Scanner in;
    private static PrintStream out;


    private static final String CASE_N = "Case #";
    private static final String COLON_SPACE = ": ";

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
//        in = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/round1b/A/A.in"));
        out = System.out;
        //out = new PrintStream(new FileOutputStream("A_RobotProgrammingStrategy.out"));

        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {

            int X = in.nextInt();
            int Y = in.nextInt();

            out.print(CASE_N);
            out.print(t);
            out.print(COLON_SPACE);

            out.print(solve(X,Y));

            out.println();
        }
        out.flush();
    }

    static class Part {
        private final int x;
        private final int y;
        private final String solution;

        Part(int x, int y, String solution) {
            this.x = x;
            this.y = y;
            this.solution = solution;
        }
    }

    private static String solve(int x, int y) {
        LinkedList<Part> q = new LinkedList<>();
        q.add(new Part(x, y, ""));

        while (!q.isEmpty()) {
            Part p = q.poll();

            // we found the solution
            if (p.x == 0 && p.y == 0) return p.solution;

                // one must be odd and the other even
            if (Math.abs(p.x + p.y) % 2 == 0) {
                //return IMPOSSIBLE;
                continue;
            }

            // check the size of the solution? // 100_000_000 uses 30 bits

            // When adding the direction of the solution we add the opposite, since we are going "backwards" to find the solution
            if (Math.abs(p.x) % 2 == 1) {
                // if X is the odd
                q.add(new Part((p.x - 1) / 2, p.y / 2, p.solution + 'E'));
                q.add(new Part((p.x + 1) / 2, p.y / 2, p.solution + 'W'));
            } else {
                // if Y is the odd
                q.add(new Part(p.x / 2, (p.y - 1) / 2, p.solution + 'N'));
                q.add(new Part(p.x / 2, (p.y + 1) / 2, p.solution + 'S'));
            }

        }

        return IMPOSSIBLE;
    }

}
