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
        int[] cl;
        int[] cr;
        int[] cp;

        int[] starts;
        int[] ends;

        public IntArrSolver(Scanner scanner) {

            int progLen = Integer.parseInt(scanner.nextLine().trim().split(" ")[0]);
            prog = scanner.nextLine().trim();

            String[] tokens = scanner.nextLine().trim().split(" ");
            cl = new int[tokens.length];
            for (int j=0; j<tokens.length; ++j) {
                cl[j] = Integer.parseInt(tokens[j]) - 1;
            }

            tokens = scanner.nextLine().trim().split(" ");
            cr = new int[tokens.length];
            for (int j=0; j<tokens.length; ++j) {
                cr[j] = Integer.parseInt(tokens[j]) - 1;
            }

            tokens = scanner.nextLine().trim().split(" ");
            cp = new int[tokens.length];
            for (int j=0; j<tokens.length; ++j) {
                cp[j] = Integer.parseInt(tokens[j]) - 1;
            }

            tokens = scanner.nextLine().trim().split(" ");
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
                long[] cost = new long[prog.length()];
                Arrays.fill(cost, -1);
                cost[starts[i]] = 0;
                bfs(cost, pair, starts[i], ends[i]);
                sum += cost[ends[i]];
            }


            return "" + sum;
        }

        class IdxCost implements Comparable<IdxCost> {
            int idx;
            long cost;

            public IdxCost(int idx, long cost) {
                this.idx = idx;
                this.cost = cost;
            }

            @Override
            public int compareTo(IdxCost idxCost) {
                return Long.compare(this.cost, idxCost.cost);
            }
        }

        public void bfs(long[] cost, int[] pair, int si, int ei) {
            Queue<Integer> idx = new LinkedList<>();
            idx.add(si);

            while (!idx.isEmpty()) {
                int curr = idx.poll();
                if (curr == ei) break;

                if (curr < ei) {
                    int pairIdx = pair[curr];
                    if (Math.abs(pairIdx - ei) < Math.abs(curr - ei)) {
                        cost[pairIdx] = cost[curr] + 1;
                        idx.add(pairIdx);
                    }
                    else {
                        cost[curr+1] = cost[curr] +1;
                        idx.add(curr + 1);
                    }
                }
                else {
                    int pairIdx = pair[curr];
                    if (Math.abs(pairIdx - ei) < Math.abs(curr - ei)) {
                        cost[pairIdx] = cost[curr] + 1;
                        idx.add(pairIdx);
                    }
                    else {
                        cost[curr-1] = cost[curr] +1;
                        idx.add(curr - 1);
                    }
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
