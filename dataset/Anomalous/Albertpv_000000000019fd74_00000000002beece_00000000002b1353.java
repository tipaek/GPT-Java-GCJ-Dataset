import java.util.*;

public class Solution {

    private int[][] triangle;
    private int N;

    private int getCellValue(int r, int k) {
        if (r - 1 < 0) return 1;
        int res = 0;
        if (k - 1 >= 0) res += triangle[r - 1][k - 1];
        if (k < triangle[r - 1].length) res += triangle[r - 1][k];
        return res;
    }

    private void init() {
        int totalRows = 500;
        triangle = new int[totalRows][];
        for (int r = 0; r < totalRows; r++) {
            triangle[r] = new int[r + 1];
            for (int k = 0; k <= r; k++) {
                triangle[r][k] = getCellValue(r, k);
            }
        }
    }

    public Solution() {
        init();
    }

    private class State implements Comparable<State> {
        int accumulated;
        Set<Position> used;
        StringBuilder sb;
        Position last;

        public State(int accumulated) {
            this.accumulated = accumulated;
            this.used = new HashSet<>();
            this.sb = new StringBuilder();
            this.last = null;
        }

        public void add(Position p) {
            this.accumulated += triangle[p.r][p.k];
            used.add(p);
            if (last != null) sb.append("\n");
            sb.append(p);
            last = p;
        }

        @Override
        public int compareTo(State o) {
            int diff = Integer.compare(N - accumulated, N - o.accumulated);
            if (diff == 0) diff = Integer.compare(used.size(), o.used.size());
            return diff;
        }

        public Position getLast() {
            return last;
        }

        public String getSolutionTrack() {
            return sb.toString();
        }

        @Override
        public State clone() {
            State copy = new State(this.accumulated);
            copy.last = this.last;
            copy.used = new HashSet<>(this.used);
            copy.sb = new StringBuilder(this.sb);
            return copy;
        }
    }

    private static class Position {
        int r, k;

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
            return r == position.r && k == position.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, k);
        }
    }

    private Position[] getPossiblePositions(int r, int k) {
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
        if (p.r < 0 || p.r >= triangle.length) return false;
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
            State currentState = liveNodes.poll();
            if (currentState.accumulated == N) return currentState;

            Position last = currentState.getLast();
            for (Position next : getPossiblePositions(last.r, last.k)) {
                if (isValid(currentState, next)) {
                    State newState = currentState.clone();
                    newState.add(next);
                    liveNodes.add(newState);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(scanner.nextLine());
            State result = solution.solve(N);
            System.out.println("Case #" + t + ":");
            if (result != null) {
                System.out.println(result.getSolutionTrack());
            } else {
                System.out.println("No solution found.");
            }
        }
    }
}