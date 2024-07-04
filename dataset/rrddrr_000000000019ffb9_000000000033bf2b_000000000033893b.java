import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static interface Solver {
        public String solve();
    }

    ////////// TODO: solver /////////////////
    private static class IntArrSolver implements Solver {

        String prog;
        int[] starts;
        int[] ends;

        public IntArrSolver(Scanner scanner) {

            int progLen = Integer.parseInt(scanner.nextLine().trim().split(" ")[0]);
            prog = scanner.nextLine().trim();
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();

            String[] tokens = scanner.nextLine().trim().split(" ");
            starts = new int[tokens.length];
            for (int j=0; j<tokens.length; ++j) {
                starts[j] = Integer.parseInt(tokens[j]) - 1;
            }

            tokens = scanner.nextLine().trim().split(" ");
            ends = new int[tokens.length];
            for (int j=0; j<tokens.length; ++j) {
                ends[j] = Integer.parseInt(tokens[j]) - 1;
            }
        }

        @Override
        public String solve() {
            int[] pair = new int[prog.length()];

            Stack<Integer> lastOpen = new Stack<>();
            for (int i=0; i<prog.length(); ++i) {
                if (prog.charAt(i) == '(')
                    lastOpen.push(i);
                else {
                    int lo = lastOpen.pop();
                    pair[i] = lo;
                    pair[lo] = i;
                }
            }

            int sum = 0;
            for (int i=0; i<starts.length; ++i) {
                int[] cost = new int[prog.length()];
                Arrays.fill(cost, -1);
                cost[starts[i]] = 0;
                bfs(cost, pair, starts[i]);
                sum += cost[ends[i]];
            }


            return "" + sum;
        }

        public void bfs(int[] cost, int[] pair, int si) {
            Queue<Integer> idx = new LinkedList<>();
            idx.add(si);

            while (!idx.isEmpty()) {
                int curr = idx.poll();
                if (curr != 0 && cost[curr-1] == -1) {
                    cost[curr-1] = cost[curr] + 1;
                    idx.add(curr - 1);
                }
                if (curr != cost.length - 1 && cost[curr+1] == -1) {
                    cost[curr+1] = cost[curr] +1;
                    idx.add(curr + 1);
                }
                int pairIdx = pair[curr];
                if (cost[pairIdx] == -1) {
                    cost[pairIdx] = cost[curr] + 1;
                    idx.add(pairIdx);
                }
            }
        }
    }

    private static void handleInput(Scanner inputReader) {
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            Solver s = new IntArrSolver(inputReader); // TODO
            String output = s.solve();
            System.out.println(String.format("Case #%d: %s", (i + 1), output));
        }
    }

    public static void main(String[] args) {
        handleInput((new Scanner(new BufferedReader(new InputStreamReader(System.in)))));
//         testCases();
    }

    public static void testCases() {
        String input = "1\n" +
                "12 5\n" +
                "(()(((()))))\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "7 4 4 12 5\n" +
                "12 11 10 1 6";
        handleInput(new Scanner(input));
    }
}
