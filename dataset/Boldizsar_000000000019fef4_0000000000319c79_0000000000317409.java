import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        int testCount = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    private static class Solver {

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String[] line = in.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int time = 1;
            for (char chr : line[2].toCharArray()) {
                switch (chr) {
                    case 'S':
                        --y;
                        break;
                    case 'N':
                        ++y;
                        break;
                    case 'E':
                        ++x;
                        break;
                    case 'W':
                        --x;
                        break;
                }
                if (check(x, y, time)) {
                    out.printf("Case #%d: %d\n", testNumber, Math.max(Math.abs(x) + Math.abs(y), time));
                    out.flush();
                    return;
                }
                ++time;
            }
            out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
        }

        private static boolean check(int x, int y, int time) {
            return Math.abs(x) + Math.abs(y) <= time;
        }

    }


}
