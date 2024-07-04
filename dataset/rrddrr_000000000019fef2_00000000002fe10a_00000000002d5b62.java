import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static interface Solver {
        public String solve();
    }

    ////////// TODO: solver /////////////////
    private static class LineSolver implements Solver {

        String data;

        public LineSolver(Scanner scanner) {
            this.data = scanner.nextLine().trim();
        }

        @Override
        public String solve() {
            StringBuilder ret = new StringBuilder();

            int x = Integer.parseInt(data.split(" ")[0]);
            int y = Integer.parseInt(data.split(" ")[1]);

            if (Math.abs(x) + Math.abs(y) % 2 == 0)
                return "IMPOSSIBLE";

            String s = solve2(x+1, y);
            if (!s.equals("IMPOSSIBLE"))
                return 'W' + s;
            s = solve2(x-1, y);
            if (!s.equals("IMPOSSIBLE"))
                return 'E' + s;
            s = solve2(x, y+1);
            if (!s.equals("IMPOSSIBLE"))
                return 'S' + s;
            s = solve2(x, y-1);
            if (!s.equals("IMPOSSIBLE"))
                return 'N' + s;
            return "IMPOSSIBLE";
        }

        public String solve2(int x, int y) {
            StringBuilder ret = new StringBuilder();

            int nx = Math.abs(x);
            int ny = Math.abs(y);

            int i = 2;
            while (nx + ny > 0) {
                if ((nx&i) != 0 && (ny&i) != 0)
                    return "IMPOSSIBLE";
                else if ((nx&i) != 0) {
                    ret.append(x > 0 ? 'E' : 'W');
                    nx -= i;
                }
                else if ((ny&i) != 0) {
                    ret.append(y > 0 ? 'N' : 'S');
                    ny -= i;
                }
                else {
                    break;
                }
                i*=2;
            }

            if (Math.abs(nx + ny) != 0) return "IMPOSSIBLE";


            return ret.toString();
        }

    }

    private static void handleInput(Scanner inputReader) {
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            LineSolver s = new LineSolver(inputReader); // TODO
            String output = s.solve();
            System.out.println(String.format("Case #%d: %s", (i + 1), output));
        }
    }

    public static void main(String[] args) {
        handleInput((new Scanner(new BufferedReader(new InputStreamReader(System.in)))));
        // testCases();
    }

    public static void testCases() {
        String input = "4\n" +
                "2 3\n" +
                "-2 -3\n" +
                "3 0\n" +
                "-1 1";
        handleInput(new Scanner(input));
    }
}
