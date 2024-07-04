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
            String[] s = this.data.split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            String moves = s[2];
            int time = 0;


            for (char c : moves.toCharArray()) {
                if (c == 'N')
                    y++;
                if (c == 'S')
                    y--;
                if (c == 'E')
                    x++;
                if (c == 'W')
                    x--;
                time++;

                if (getDist(x, y) <= time)
                    return time + "";
            }

            return "IMPOSSIBLE";
        }

        public int getDist(int x, int y) {
            return Math.abs(x) + Math.abs(y);
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
        // testCases();
    }

    public static void testCases() {
        String input = "5\n" +
                "4 4 SSSS\n" +
                "3 0 SNSS\n" +
                "2 10 NSNNSN\n" +
                "0 1 S\n" +
                "2 7 SSSSSSSS";
        handleInput(new Scanner(input));
    }
}
