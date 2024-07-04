
import java.util.*;

public class Solution {

    private int[][] triangle;

    private int N;



    private int getCellValue(int r, int k) {
        if (r - 1 < 0) return 1;

        int res = 0;
        if (k - 1 >= 0) {
            res += triangle[r - 1][k - 1];
        }
        if (k < triangle[r - 1].length) {
            res += triangle[r - 1][k];
        }

        return res;
    }

    private void init() {
        int rows = 1;
        int total = 10;

        triangle = new int[total][];

        for (int r = 0; r < total; r++) {
            triangle[r] = new int[rows];

            for (int k = 0; k < rows; k++) {
                triangle[r][k] = getCellValue(r, k);
            }

            rows++;
        }
    }


    public Solution() {
        init();

    }


    private class State implements Comparable<State> {
        int accumulated;
        Set<Position> used;
        StringBuilder sb = new StringBuilder();
        Position last;

        public State(int accumulated) {
            this.accumulated = accumulated;
            this.used = new HashSet<>();
            this.last = null;
        }

        public void add(Position p) {
            this.accumulated += triangle[p.r][p.k];
            used.add(p);
            if (last != null)
                sb.append("\n");
            sb.append(p.toString());
            last = p;
        }

        @Override
        public int compareTo(State o) {
            int diff = Integer.compare(N - accumulated, N - o.accumulated);
            if (diff == 0) {
                diff = Integer.compare(used.size(), o.used.size());
            }
            return diff;
        }

        public Position getLast() {
            return last;
        }

        public String getSolutionTrack() {
            return sb.toString();
        }
    }

    private static class Position {
        int r;
        int k;

        public Position(int r, int k) {
            this.r = r;
            this.k = k;
        }

        @Override
        public String toString() {
            return (r + 1) + " " + (k + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return r == position.r &&
                    k == position.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, k);
        }
    }

    private Position[] getPossiblePositions(int k, int r) {
        return new Position[]{
                new Position(r - 1, k - 1),
                new Position(r - 1, k),
                new Position(r, k - 1),
                new Position(r, k + 1),
                new Position(r + 1, k),
                new Position(r + 1, k + 1)
        };
    }


    private boolean isValid(State s, Position p) {

        if (p.r < 0) return false;
        if (p.k < 0 || p.k >= triangle[p.r].length) return false;

        return !s.used.contains(p) && s.accumulated + triangle[p.r][p.k] <= N;
    }

    public State solve(int N) {
        PriorityQueue<State> liveNodes = new PriorityQueue<>();
        State root = new State(0);
        root.add(new Position(0, 0));

        this.N = N;
        liveNodes.add(root);


        while (!liveNodes.isEmpty()) {
            State x = liveNodes.poll();

            if (x.accumulated == N)     // solution found
                return x;

            Position last = x.getLast();
            Position []options = getPossiblePositions(last.r, last.k);

            for (Position opt : options) {

                if (isValid(x, opt)) {

                    x.add(opt);
                    liveNodes.add(x);
                }
            }
        }

        return null;
    }

    public static void main(String []args) {
        Solution sol = new Solution();
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= T; t++) {

            System.out.println("Case #" + t + ":");
            int N = Integer.parseInt(scanner.nextLine());

            State state = sol.solve(N);
            System.out.println(state.getSolutionTrack());
        }
    }
}

