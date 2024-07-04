import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader("data/testIn"))) {
            String s;
            while ((s = read.readLine()) != null) {
                total.append(s).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes("UTF-8"));
        System.setIn(testInput);
    }

    public static void main(String[] args) throws IOException {
        test();
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(in.nextLine());
            for (int c = 1; c <= t; ++c) {
                System.out.println("Case #" + c + ": " + getResult(in.nextLine().split(" ")));
            }
        }
    }

    private static boolean hasResult = false;
    private static int expectedTrace = 0;

    private static String getResult(String[] input) {
        int N = Integer.parseInt(input[0]);
        expectedTrace = Integer.parseInt(input[1]);
        hasResult = false;
        List<Integer> nextRowSet = fullRowSet(N);
        int[][] current = new int[N][N];
        Set<Integer>[] colSets = createColumnSets(N);

        String solution = tryNext(expectedTrace, current, N, 0, 0, nextRowSet, colSets);
        return solution == null ? "IMPOSSIBLE" : solution;
    }

    private static Set<Integer>[] createColumnSets(int N) {
        Set<Integer>[] colSets = new Set[N];
        for (int x = 0; x < N; x++) {
            colSets[x] = new HashSet<>();
        }
        return colSets;
    }

    private static String tryNext(int wanted, int[][] current, int N, int nextX, int nextY, List<Integer> rowSet, Set<Integer>[] colSets) {
        if (hasResult) return null;
        for (int i = 0; i < rowSet.size(); i++) {
            int tryN = rowSet.get(i);
            if (colSets[nextX].contains(tryN)) continue;
            int[][] next = cloneArray(current, N);
            next[nextX][nextY] = tryN;
            Set<Integer>[] clonedSet = cloneSets(colSets, nextX, tryN);
            List<Integer> nextRowSet = new ArrayList<>(rowSet);
            nextRowSet.remove(i);

            if (nextRowSet.isEmpty()) {
                if (nextY + 1 == N) {
                    if (calcDiagonal(N, next) == wanted) {
                        hasResult = true;
                        return stateToString(next, N);
                    }
                    return null;
                }
                nextRowSet = fullRowSet(N);
                String solution = tryNext(wanted, next, N, 0, nextY + 1, nextRowSet, clonedSet);
                if (solution != null) return solution;
            } else {
                String solution = tryNext(wanted, next, N, nextX + 1, nextY, nextRowSet, clonedSet);
                if (solution != null) return solution;
            }
        }
        return null;
    }

    private static List<Integer> fullRowSet(int N) {
        List<Integer> newL = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            newL.add(i + 1);
        }
        return newL;
    }

    private static int[][] cloneArray(int[][] original, int N) {
        int[][] cloned = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, cloned[i], 0, N);
        }
        return cloned;
    }

    @SuppressWarnings("unchecked")
    private static Set<Integer>[] cloneSets(Set<Integer>[] original, int addCol, int addWhat) {
        int N = original.length;
        Set<Integer>[] clone = new Set[N];
        for (int x = 0; x < N; x++) {
            clone[x] = new HashSet<>(original[x]);
        }
        clone[addCol].add(addWhat);
        return clone;
    }

    private static String stateToString(int[][] square, int N) {
        StringBuilder sb = new StringBuilder("POSSIBLE\n");
        for (int[] row : square) {
            for (int j = 0; j < N; j++) {
                sb.append(j > 0 ? " " : "").append(row[j]);
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    private static class State implements Comparable<State> {
        final int[][] square;
        final int diff;

        public State(int[][] square) {
            this.square = square;
            this.diff = Math.abs(calcDiagonal(square.length, square) - expectedTrace);
        }

        @Override
        public int compareTo(State o) {
            return Integer.compare(this.diff, o.diff);
        }
    }

    private static int calcDiagonal(int N, int[][] square) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += square[i][i];
        }
        return sum;
    }

    private static int[][] shuffleArray(int[][] squareOrig, int N, boolean isColumn) {
        int[][] square = cloneArray(squareOrig, N);
        int idx1 = (int) (Math.random() * N);
        int idx2 = (int) (Math.random() * N);
        for (int i = 0; i < N; i++) {
            if (isColumn) {
                int temp = square[i][idx1];
                square[i][idx1] = square[i][idx2];
                square[i][idx2] = temp;
            } else {
                int temp = square[idx1][i];
                square[idx1][i] = square[idx2][i];
                square[idx2][i] = temp;
            }
        }
        return square;
    }

    private static int[][] shuffleRandomColumn(int[][] squareOrig, int N) {
        return shuffleArray(squareOrig, N, true);
    }

    private static int[][] shuffleRandomRow(int[][] squareOrig, int N) {
        return shuffleArray(squareOrig, N, false);
    }

    private static int[][] shuffleRandomNumbers(int[][] squareOrig, int N) {
        int[][] square = cloneArray(squareOrig, N);
        int num1 = 1 + (int) (Math.random() * N);
        int num2 = 1 + (int) (Math.random() * N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (square[i][j] == num1) {
                    square[i][j] = num2;
                } else if (square[i][j] == num2) {
                    square[i][j] = num1;
                }
            }
        }
        return square;
    }
}