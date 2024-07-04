import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        outer:
        for (int t = 1; t <= T; t++) {
            String[] s = reader.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int K = Integer.parseInt(s[1]);

            Set<List<Integer>> possibleTraces = getPossibleTraces(N, K);

            for (List<Integer> trace : possibleTraces) {
                int[][] matrix = new int[N][N];
                List<Set<Integer>> rows = new ArrayList<>();
                List<Set<Integer>> cols = new ArrayList<>();

                for (int x = 0; x < N; x++) {
                    rows.add(new HashSet<>());
                    cols.add(new HashSet<>());
                }

                fillInTraceElements(matrix, trace, rows, cols);

                matrix = fillInRestOfTheMatrix(matrix, rows, cols);
                if (matrix != null) {
                    System.out.println(String.format("Case #%d: POSSIBLE", t));
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    continue outer;
                }
            }

            System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
        }

    }

    private static int[][] fillInRestOfTheMatrix(int[][] matrix, List<Set<Integer>> rows,
                                                 List<Set<Integer>> cols) {
        boolean success = tryFilling(matrix, rows, cols);
        if (success) {
            return matrix;
        }
        return null;
    }

    private static boolean tryFilling(int[][] matrix, List<Set<Integer>> rows, List<Set<Integer>> cols) {
        int N = matrix.length;
        if (checkIfFilled(matrix, N)) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 1; k <= N; k++) {
                        if (!rows.get(i).contains(k) && !cols.get(j).contains(k)) {
                            matrix[i][j] = k;
                            if (tryFilling(matrix, deepCopy(rows), deepCopy(cols))) {
                                return true;
                            }
                            matrix[i][j] = 0;
                        }
                    }
                }
            }
        }

        return false;
    }

    private static List<Set<Integer>> deepCopy(List<Set<Integer>> rows) {
        List<Set<Integer>> copy = new ArrayList<>();
        for (Set<Integer> inner : rows) {
            Set<Integer> innerCopy = new HashSet<>(inner);
            copy.add(innerCopy);
        }
        return copy;
    }

    private static boolean checkIfFilled(int[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void fillInTraceElements(int[][] matrix, List<Integer> trace, List<Set<Integer>> rows, List<Set<Integer>> cols) {
        int index = 0;
        for (Integer traceElement : trace) {
            rows.get(index).add(traceElement);
            cols.get(index).add(traceElement);
            matrix[index][index++] = traceElement;
        }
    }

    private static Set<List<Integer>> getPossibleTraces(int n, int k) {
        Set<List<Integer>> traces = new HashSet<>();
        getTracesRecursively(n, k, traces, new ArrayList<>());

        return traces;
    }

    private static void getTracesRecursively(int n, int k, Set<List<Integer>> traces,
                                             List<Integer> currentTrace) {
        if (currentTrace.size() == n && k == 0) {
            Collections.sort(currentTrace);
            traces.add(currentTrace);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (k - i >= 0) {
                currentTrace.add(i);
                getTracesRecursively(n, k - i, traces, new ArrayList<>(currentTrace));
                currentTrace.remove(currentTrace.size() - 1);
            }
        }
    }
}
