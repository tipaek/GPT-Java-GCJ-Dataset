import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static interface Solver {
        public String solve();
    }

    private static class ReducedFraction implements Comparable<ReducedFraction> {
        private long num;
        private long denom;

        public ReducedFraction(long num, long denom) {
            this.num = num;
            this.denom = denom;

            if (this.num == 0 && this.denom == 0) {
                // nada
            }
            else if (this.num == 0 && this.denom != 0) {
                this.denom = 1;
            }
            else if (this.num != 0 && this.denom == 0) {
                this.num = 1;
            }
            else {
                reduce();
            }
        }

        private void reduce() {
            long gcd = findGCD(num, denom);
            num /= gcd;
            denom /= gcd;

            if (num * denom < 0 && denom < 0) {
                denom *= -1;
                num *= -1;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ReducedFraction that = (ReducedFraction) o;
            return num == that.num &&
                    denom == that.denom;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, denom);
        }

        private long findGCD(long i, long j) {
            if (j == 0) {
                return i;
            }
            return findGCD(j, i % j);
        }

        @Override
        public int compareTo(ReducedFraction o) {
            if (this.num == o.num && this.denom == o.denom) return 0;
            return Double.compare((double)this.num / (double)this.denom, (double)o.num / (double)o.denom);
        }
    }

    ////////// TODO: solver /////////////////
    private static class PointArrSolver implements Solver {

        List<Point> points;

        public PointArrSolver(Scanner scanner) {
            points = new ArrayList<>();

            String[] ts = scanner.nextLine().split(" ");
            int numLines = Integer.parseInt(ts[0]);
            // int maxCoord = Integer.parseInt(ts[1]);
            // mc = maxCoord;
            for (int i=0; i<numLines; ++i) {
                String[] tokens = scanner.nextLine().trim().split(" ");
                Point p = new Point(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
                points.add(p);
            }
        }

        @Override
        public String solve() {
            Map<ReducedFraction, Set<Point>> slopeToPoints = new HashMap<>();

            for (int i=0; i<points.size();++i) {
                for (int j=i+1; j<points.size(); ++j) {
                    ReducedFraction slope = getSlope(points.get(i), points.get(j));
                    if (!slopeToPoints.containsKey(slope)) {
                        slopeToPoints.put(slope, new HashSet<>());
                    }
                    slopeToPoints.get(slope).add(points.get(i));
                    slopeToPoints.get(slope).add(points.get(j));
                }
            }

            int max = 1;
            for (Set<Point> points : slopeToPoints.values()) {
                max = Math.max(max, points.size() + 2);
            }
            max = Math.min(max, points.size());
            return "" + max;
        }

        private ReducedFraction getSlope(Point p1, Point p2) {
            return new ReducedFraction(p2.y - p1.y, p2.x - p1.x);
        }

        private static class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }


    private static void handleInput(Scanner inputReader) {
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            Solver s = new PointArrSolver(inputReader); // TODO
            String output = s.solve();
            System.out.println(String.format("Case #%d: %s", (i + 1), output));
        }
    }

    public static void main(String[] args) {
        handleInput((new Scanner(new BufferedReader(new InputStreamReader(System.in)))));
//         testCases();
    }

    public static void testCases() {
        String input = "5\n" +
                "2\n" +
                "0 0\n" +
                "5 5\n" +
                "3\n" +
                "0 0\n" +
                "5 5\n" +
                "5 0\n" +
                "5\n" +
                "0 0\n" +
                "5 5\n" +
                "5 0\n" +
                "3 2\n" +
                "2 4\n" +
                "7\n" +
                "0 0\n" +
                "1 1\n" +
                "2 1\n" +
                "3 1\n" +
                "8 2\n" +
                "11 2\n" +
                "14 2\n" +
                "1\n" +
                "-1000000000 1000000000";
        handleInput(new Scanner(input));
    }
}
