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

            if (Math.abs(x) % 2 == 1) {
                if (x > 0) {
                    ret.append('E');
                    x--;
                }
                else {
                    ret.append('W');
                    x++;
                }
            }
            else {
                if (y > 0) {
                    ret.append('N');
                    y--;
                }
                else {
                    ret.append('S');
                    y++;
                }
            }

            int inc = 2;
            while (x > 0) {
                x -= inc;
                ret.append('E');
                inc *= 2;
            }
            while (y > 0) {
                y -= inc;
                ret.append('N');
                inc *= 2;
            }
            while (x < 0) {
                x += inc;
                ret.append('W');
                inc *= 2;
            }
            while (y < 0) {
                y += inc;
                ret.append('S');
                inc *= 2;
            }
            while (x > 0) {
                x -= inc;
                ret.append('E');
                inc *= 2;
            }
            while (y > 0) {
                y -= inc;
                ret.append('N');
                inc *= 2;
            }

            if (x != 0 || y != 0)
                return "IMPOSSIBLE";

            return ret.toString();
        }

        public String solve2() {
            StringBuilder ret = new StringBuilder();

            int x = Integer.parseInt(data.split(" ")[0]);
            int y = Integer.parseInt(data.split(" ")[1]);

            if (Math.abs(x) + Math.abs(y) % 2 == 0)
                return "IMPOSSIBLE";

            if (Math.abs(x) % 2 == 1) {
                if (x > 0) {
                    ret.append('W');
                    x++;
                }
                else {
                    ret.append('E');
                    x--;
                }
            }
            else {
                if (y > 0) {
                    ret.append('S');
                    y++;
                }
                else {
                    ret.append('N');
                    y--;
                }
            }

            int inc = 2;
            while (x > 0) {
                x -= inc;
                ret.append('E');
                inc *= 2;
            }
            while (y > 0) {
                y -= inc;
                ret.append('N');
                inc *= 2;
            }
            while (x < 0) {
                x += inc;
                ret.append('W');
                inc *= 2;
            }
            while (y < 0) {
                y += inc;
                ret.append('S');
                inc *= 2;
            }
            while (x > 0) {
                x -= inc;
                ret.append('E');
                inc *= 2;
            }
            while (y > 0) {
                y -= inc;
                ret.append('N');
                inc *= 2;
            }

            if (x != 0 || y != 0)
                return "IMPOSSIBLE";

            return ret.toString();
        }
    }

    private static void handleInput(Scanner inputReader) {
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            LineSolver s = new LineSolver(inputReader); // TODO
            String output = s.solve();
            String output2 = s.solve2();
            String r = "";
            if (output.equals("IMPOSSIBLE"))
                r = output2;
            else if (output2.equals("IMPOSSIBLE"))
                r = output;
            else if (output2.length() < output.length())
                r = output2;
            
            System.out.println(String.format("Case #%d: %s", (i + 1), r));
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
