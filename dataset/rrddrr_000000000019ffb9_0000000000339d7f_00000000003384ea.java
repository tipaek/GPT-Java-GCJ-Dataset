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
        long l;
        long r;

        public LineSolver(Scanner scanner) {
            this.data = scanner.nextLine().trim();
            String[] ss = data.split(" ");
            l = Long.parseLong(ss[0]);
            r = Long.parseLong(ss[1]);
        }

        @Override
        public String solve() {
            long i = 1;
            for (i=1; i<Long.MAX_VALUE; ++i) {
                if (r > l) {
                    if (r >= i) {
                        r -= i;
                    }
                    else {
                        break;
                    }
                }
                else {
                    if (l >= i) {
                        l -= i;
                    }
                    else {
                        break;
                    }
                }
            }
            return String.format("%s %s %s", i-1, l, r);
        }
    }

    private static void handleInput(Scanner inputReader) {
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            Solver s = new LineSolver(inputReader); // TODO
            String output = s.solve();
            System.out.println(String.format("Case #%d: %s", (i + 1), output));
        }
    }

    public static void main(String[] args) {
        handleInput((new Scanner(new BufferedReader(new InputStreamReader(System.in)))));
//         testCases();
    }

    public static void testCases() {
        String input = "3\n" +
                "1 2\n" +
                "2 2\n" +
                "1000000000000000000 1000000000000000000";
        handleInput(new Scanner(input));
    }
}
