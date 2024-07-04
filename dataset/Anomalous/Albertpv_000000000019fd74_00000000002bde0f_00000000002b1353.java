import java.util.*;

public class Solution {

    private int[][] triangle;
    private int N;

    private int getCellValue(int row, int col) {
        if (row - 1 < 0) return 1;

        int value = 0;
        if (col - 1 >= 0) {
            value += triangle[row - 1][col - 1];
        }
        if (col < triangle[row - 1].length) {
            value += triangle[row - 1][col];
        }

        return value;
    }

    private void initializeTriangle() {
        int rows = 1;
        int totalRows = 10;
        triangle = new int[totalRows][];

        for (int row = 0; row < totalRows; row++) {
            triangle[row] = new int[rows];
            for (int col = 0; col < rows; col++) {
                triangle[row][col] = getCellValue(row, col);
            }
            rows++;
        }
    }

    public Solution() {
        initializeTriangle();
    }

    private class State implements Comparable<State> {
        int accumulated;
        Set<Position> usedPositions;
        StringBuilder path;
        Position lastPosition;

        public State(int accumulated) {
            this.accumulated = accumulated;
            this.usedPositions = new HashSet<>();
            this.path = new StringBuilder();
            this.lastPosition = null;
        }

        public void addPosition(Position position) {
            this.accumulated += triangle[position.row][position.col];
            usedPositions.add(position);
            if (lastPosition != null) {
                path.append("\n");
            }
            path.append(position);
            lastPosition = position;
        }

        @Override
        public int compareTo(State other) {
            int difference = Integer.compare(N - accumulated, N - other.accumulated);
            if (difference == 0) {
                difference = Integer.compare(usedPositions.size(), other.usedPositions.size());
            }
            return difference;
        }

        public Position getLastPosition() {
            return lastPosition;
        }

        public String getSolutionPath() {
            return path.toString();
        }
    }

    private static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return (row + 1) + " " + (col + 1);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Position position = (Position) obj;
            return row == position.row && col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    private Position[] getPossiblePositions(int row, int col) {
        return new Position[]{
                new Position(row - 1, col - 1),
                new Position(row - 1, col),
                new Position(row, col - 1),
                new Position(row, col + 1),
                new Position(row + 1, col),
                new Position(row + 1, col + 1)
        };
    }

    private boolean isValid(State state, Position position) {
        if (position.row < 0) return false;
        if (position.col < 0 || position.col >= triangle[position.row].length) return false;
        return !state.usedPositions.contains(position) && state.accumulated + triangle[position.row][position.col] <= N;
    }

    public State solve(int targetSum) {
        this.N = targetSum;
        PriorityQueue<State> liveNodes = new PriorityQueue<>();
        State rootState = new State(0);
        rootState.addPosition(new Position(0, 0));
        liveNodes.add(rootState);

        while (!liveNodes.isEmpty()) {
            State currentState = liveNodes.poll();

            if (currentState.accumulated == N) {
                return currentState;
            }

            Position lastPosition = currentState.getLastPosition();
            Position[] possiblePositions = getPossiblePositions(lastPosition.row, lastPosition.col);

            for (Position position : possiblePositions) {
                if (isValid(currentState, position)) {
                    State newState = new State(currentState.accumulated);
                    newState.usedPositions.addAll(currentState.usedPositions);
                    newState.path.append(currentState.path);
                    newState.addPosition(position);
                    liveNodes.add(newState);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.println("Case #" + testCase + ":");
            int N = Integer.parseInt(scanner.nextLine());

            State solutionState = solution.solve(N);
            if (solutionState != null) {
                System.out.println(solutionState.getSolutionPath());
            } else {
                System.out.println("No solution found");
            }
        }
    }
}