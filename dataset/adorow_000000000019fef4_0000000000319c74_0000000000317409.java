import java.io.PrintStream;
import java.util.Scanner;


public class Solution {

    private static Scanner in;
    private static PrintStream out;


    private static final String CASE_N = "Case #";
    private static final String COLON_SPACE = ": ";

    static int[][] pep = new int[1001][2];

    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
//        in = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/round1c/A/A.in"));
        out = System.out;
        //out = new PrintStream(new FileOutputStream("A_RobotProgrammingStrategy.out"));

        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String M = in.next();

            pep[0][0] = X;
            pep[0][1] = Y;
            for (int i = 0; i < M.length(); i++) {
                int idx = i+1;
                char move = M.charAt(i);

                pep[idx][0] = pep[idx-1][0] + deltax(move);
                pep[idx][1] = pep[idx-1][1] + deltay(move);
            }

            int min = -1;
            for (int i = 1; i <= M.length(); i++) {
                int dist = distanceTo(pep[i][0], pep[i][1]);
                if (dist <= i) {
                    min = i;
                    break;
                }
            }
            // I am at (0,0)
//            int my_x = 0;
//            int my_y = 0;

            out.print(CASE_N);
            out.print(t);
            out.print(COLON_SPACE);

            // todo
            if (min < 0) {
                out.print("IMPOSSIBLE");
            } else {
                out.print(min);
            }

            out.println();
        }
        out.flush();
    }

    private static int distanceTo(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    static int deltax(char ch) {
        switch (ch) {
            case 'E': return 1;
            case 'W': return -1;
            default: return 0;
        }
    }

    static int deltay(char ch) {
        switch (ch) {
            case 'N': return 1;
            case 'S': return -1;
            default: return 0;
        }
    }

}
