import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static interface Solver {
        public String solve();
    }

    ////////// TODO: solver /////////////////
    private static class MatrixSolver implements Solver {

        int[][] matrix;

        public MatrixSolver(Scanner scanner) {
            String[] tokens = scanner.nextLine().split(" ");
            int r = Integer.parseInt(tokens[0]);
            int c = Integer.parseInt(tokens[1]);
            this.matrix = new int[r][c];
            for (int j=0; j<r; ++j) {
                matrix[j] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        @Override
        public String solve() {
            int sum = 0;
            int prevSum = -1;
            while (true) {
                int s = getSum();
                if (s == prevSum) break;
                else prevSum = s;
                sum += s;
                int[][] nm = new int[matrix.length][matrix[0].length];
                for (int r=0; r<matrix.length; ++r) {
                    for (int c=0; c<matrix[0].length; ++c) {
                        nm[r][c] = getNewVal(r, c);
                    }
                }
                matrix = nm;
            }
            return sum + "";
        }

        public int getSum() {
            int sum = 0;
            for (int r=0; r<matrix.length; ++r) {
                for (int c=0; c<matrix[0].length; ++c) {
                    sum += matrix[r][c];
                }
            }
            return sum;
        }

        public int getNewVal(int r, int c) {
            List<Integer> ns = new ArrayList<>();
            int rr = r-1;
            while (rr >= 0) {
                if (matrix[rr][c] > 0) {
                    ns.add(matrix[rr][c]);
                    break;
                }
                rr--;
            }
            rr = r+1;
            while (rr < matrix.length) {
                if (matrix[rr][c] > 0) {
                    ns.add(matrix[rr][c]);
                    break;
                }
                rr++;
            }

            int cc = c-1;
            while (cc >= 0) {
                if (matrix[r][cc] > 0) {
                    ns.add(matrix[r][cc]);
                    break;
                }
                cc--;
            }
            cc = c+1;
            while (cc < matrix[0].length) {
                if (matrix[r][cc] > 0) {
                    ns.add(matrix[r][cc]);
                    break;
                }
                cc++;
            }

            if (ns.isEmpty()) return matrix[r][c];
            int sum = ns.stream().reduce(Integer::sum).get();
            if (sum > ns.size() * matrix[r][c]) return 0;
            return matrix[r][c];
        }
    }

    private static void handleInput(Scanner inputReader) {
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            Solver s = new MatrixSolver(inputReader); // TODO
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
                "1 1\n" +
                "15\n" +
                "3 3\n" +
                "1 1 1\n" +
                "1 2 1\n" +
                "1 1 1\n" +
                "1 3\n" +
                "3 1 2\n" +
                "1 3\n" +
                "1 2 3";
        handleInput(new Scanner(input));
    }
}
