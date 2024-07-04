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
            long sum = getSum();
            List<Point> changed = solveFirstTime();
            while (!changed.isEmpty()) {
                for (Point p : changed) {
                    matrix[p.r][p.c] = 0;
                }
                sum += getSum();
                List<Point> newChanges = new ArrayList<>();
                for (Point p : changed) {
                    getChanges(p.r, p.c, newChanges);
                }
                changed = newChanges;
            }
            return sum + "";
        }

        public List<Point> solveFirstTime() {
            List<Point> changed = new ArrayList<>();
            int[][] nm = new int[matrix.length][matrix[0].length];
            for (int r=0; r<matrix.length; ++r) {
                for (int c=0; c<matrix[0].length; ++c) {
                    nm[r][c] = getNewVal(r, c);
                    if (nm[r][c] == 0) {
                        changed.add(new Point(r, c));
                    }
                }
            }
            matrix = nm;
            return changed;
        }

        public long getSum() {
            long sum = 0;
            for (int r=0; r<matrix.length; ++r) {
                for (int c=0; c<matrix[0].length; ++c) {
                    sum += matrix[r][c];
                }
            }
            return sum;
        }

        public void getChanges(int r, int c, List<Point> changed) {
            int rr = r-1;
            while (rr >= 0) {
                if (matrix[rr][c] > 0) {
                    if (getNewVal(rr, c) == 0)
                      changed.add(new Point(rr, c));
                    break;
                }
                rr--;
            }
            rr = r+1;
            while (rr < matrix.length) {
                if (matrix[rr][c] > 0) {
                    if (getNewVal(rr, c) == 0)
                        changed.add(new Point(rr, c));
                    break;
                }
                rr++;
            }

            int cc = c-1;
            while (cc >= 0) {
                if (matrix[r][cc] > 0) {
                    if (getNewVal(r, cc) == 0)
                        changed.add(new Point(r, cc));
                    break;
                }
                cc--;
            }
            cc = c+1;
            while (cc < matrix[0].length) {
                if (matrix[r][cc] > 0) {
                    if (getNewVal(r, cc) == 0)
                        changed.add(new Point(r, cc));
                    break;
                }
                cc++;
            }
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

        private static class Point {
            int r;
            int c;

            public Point(int r, int c) {
                this.r = r;
                this.c = c;
            }
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
