import java.io.*;
import java.util.*;

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
        //test();
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
        @SuppressWarnings("unchecked")
        Set<Integer>[] set = new Set[N];
        for (int x = 0; x < N; x++) {
            set[x] = new HashSet<>();
        }
        String solution = tryNext(expectedTrace, current, N, 0, 0, nextRowSet, set);
        return solution == null ? "IMPOSSIBLE" : solution;
    }

    private static String tryNext(int wanted, int[][] current, int N, int nextX, int nextY, List<Integer> rowSet, Set<Integer>[] colSets) {
        if (hasResult) return null;
        for (int i = 0; i < rowSet.size(); i++) {
            int tryN = rowSet.get(i);
            if (colSets[nextX].contains(tryN)) continue;
            int[][] next = clone(current, N);
            next[nextX][nextY] = tryN;
            Set<Integer>[] clonedSet = clone(colSets, nextX, tryN);
            if (rowSet.size() == 1) {
                if (nextY + 1 == N) {
                    if (calcDiagonal(N, next) == wanted) {
                        hasResult = true;
                        return stateToString(next, N);
                    }
                    return null;
                }
                List<Integer> nextRowSet = fullRowSet(N);
                String solution = tryNext(wanted, next, N, 0, nextY + 1, nextRowSet, clonedSet);
                if (solution != null) return solution;
            } else {
                List<Integer> nextRowSet = clone(rowSet, i);
                String solution = tryNext(wanted, next, N, nextX + 1, nextY, nextRowSet, clonedSet);
                if (solution != null) return solution;
            }
        }
        return null;
    }

    private static List<Integer> fullRowSet(int N) {
        List<Integer> newL = new ArrayList<>(N);
        for (int i = 0; i < N; i++) newL.add(i + 1);
        return newL;
    }

    private static List<Integer> clone(List<Integer> original, int except) {
        List<Integer> cloned = new ArrayList<>(original.size() - 1);
        for (int i = 0; i < original.size(); i++) {
            if (i != except) cloned.add(original.get(i));
        }
        return cloned;
    }

    @SuppressWarnings("unchecked")
    private static Set<Integer>[] clone(Set<Integer>[] original, int addCol, int addWhat) {
        Set<Integer>[] clone = new Set[original.length];
        for (int x = 0; x < original.length; x++) {
            clone[x] = new HashSet<>(original[x]);
        }
        clone[addCol].add(addWhat);
        return clone;
    }

    private static String stateToString(int[][] square, int N) {
        StringBuilder sb = new StringBuilder();
        sb.append("POSSIBLE\n");
        for (int[] row : square) {
            for (int j = 0; j < N; j++) {
                if (j > 0) sb.append(" ");
                sb.append(row[j]);
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    private static int[][] clone(int[][] square, int N) {
        int[][] cloned = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(square[i], 0, cloned[i], 0, N);
        }
        return cloned;
    }

    private static int calcDiagonal(int N, int[][] square) {
        int sum = 0;
        for (int i = 0; i < N; i++) sum += square[i][i];
        return sum;
    }
}