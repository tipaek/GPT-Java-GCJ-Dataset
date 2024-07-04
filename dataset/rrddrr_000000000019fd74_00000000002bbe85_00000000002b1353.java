import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static interface Solver {
        public String solve(int[][] p);
    }

    ////////// TODO: solver /////////////////
    private static class LineSolver implements Solver {

        int data;

        public LineSolver(Scanner scanner) {
            this.data = Integer.parseInt(scanner.nextLine().trim());
        }

        @Override
        public String solve(int[][] p) {
            boolean[][] visited = new boolean[501][501];
            List<String> ret = new ArrayList<>();
            dfs(p, ret, 1, 1, data, visited);
            StringBuilder sb = new StringBuilder();
            for (String s : ret) {
                sb.append(s).append("\n");
            }
            return sb.toString().trim();
        }

        int[][] SHIFT = new int[][]{{0, -1}, {0, 1}, {-1,-1}, {-1,0},{1,0},{1,1}};

        public boolean dfs(int[][] p, List<String> ret, int r, int c, int target, boolean[][] visited) {
            if (p[r][c] == 0)
                return false;
            if (p[r][c] > target)
                return false;
            if (visited[r][c])
                return false;

            ret.add(r + " " + c);
            visited[r][c] = true;
            if (p[r][c] == target) {
                return true;
            }

            for (int[] move : SHIFT) {
                if (dfs(p, ret, r+move[0], c+move[1], target - p[r][c], visited)) return true;
            }
            ret.remove(ret.size() - 1);
            // FIXME: unset visited?  not sure
            return false;
        }
    }

    private static void handleInput(Scanner inputReader) {
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        int[][] p = computePascal();
        for (int i = 0; i < numTestCases; ++i) {
            Solver s = new LineSolver(inputReader); // TODO
            String output = s.solve(p);
            System.out.println(String.format("Case #%d:\n%s", (i + 1), output));
        }
    }

    public static int[][] computePascal() {
        int[][] p = new int[501][501];
        for (int i=1; i<=500; ++i) {
            for (int j=1; j<=i; ++j) {
                if (j == 1 || j == i) {
                    p[i][j] = 1;
                }
                else {
                    p[i][j] = p[i-1][j-1] + p[i-1][j];
                }
            }
        }
        return p;
    }

    public static void main(String[] args) {
        handleInput((new Scanner(new BufferedReader(new InputStreamReader(System.in)))));
        // testCases();
    }

    public static void testCases() {
        String input = "3\n" +
                "1\n" +
                "4\n" +
                "99999999";
        handleInput(new Scanner(input));
    }
}
