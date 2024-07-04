import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static boolean debug = false;
    private static int N, K;
    private static boolean[][] rows, columns;
    private static int[] indexSequence;
    private static List<List<Integer>> rowValues;
    private static Random rand = new Random();

    private static void solveProblem(InputStream input) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(input)));
        int testCount = scanner.nextInt();
        for (int t = 1; t <= testCount; t++) {
            N = scanner.nextInt();
            K = scanner.nextInt();
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        List<Integer> indexes = new ArrayList<>();
        indexSequence = new int[N * N];
        for (int i = 0; i < N * N; i++) {
            indexes.add(i);
        }
        int seq = 0;
        for (int i = 0; i < N; i++) {
            indexSequence[seq++] = N * i + i;
            indexes.remove(Integer.valueOf(N * i + i));
        }
        for (int index : indexes) {
            indexSequence[seq++] = index;
        }

        rowValues = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> rowData = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                rowData.add(1 + (i + j) % N);
            }
            rowValues.add(rowData);
        }

        boolean answer = false;
        int[][] grid = null;
        for (int d = 0; d < N; d++) {
            grid = new int[N][N];
            rows = new boolean[N][N + 1];
            columns = new boolean[N][N + 1];
            fillDiagonal(grid, d);
            if (solveGrid(grid, N)) {
                answer = true;
                break;
            }
        }

        if (answer) {
            return "POSSIBLE\n" + printGrid(grid);
        } else {
            return "IMPOSSIBLE";
        }
    }

    private static boolean solveGrid(int[][] grid, int seq) {
        if (seq >= N * N) {
            return true;
        }

        int index = indexSequence[seq];
        int row = index / N;
        int col = index % N;
        if (grid[row][col] != 0) {
            return solveGrid(grid, seq + 1);
        }

        List<Integer> rowData = rowValues.get(row);
        for (int value : rowData) {
            if (rows[row][value] || columns[col][value]) {
                continue;
            }

            if (row == col) {
                int sum = 0;
                int valueCount = 0;
                for (int i = 0; i < N; i++) {
                    if (grid[i][i] != 0) {
                        sum += grid[i][i];
                        valueCount++;
                    }
                }
                sum += value;
                valueCount++;
                if (sum > K || (valueCount == N && sum != K)) {
                    continue;
                }
            }

            grid[row][col] = value;
            rows[row][value] = true;
            columns[col][value] = true;
            if (solveGrid(grid, seq + 1)) {
                return true;
            } else {
                grid[row][col] = 0;
                rows[row][value] = false;
                columns[col][value] = false;
            }
        }
        return false;
    }

    private static void fillDiagonal(int[][] grid, int seed) {
        int lower = K / N;
        int reminder = K - lower * N;

        for (int i = 0; i < N; i++) {
            int value = lower;
            if (i >= (N - reminder)) {
                value++;
            }
            setGridValue(grid, i, i, value);
        }
        for (int i = 1; i < seed; i++) {
            if (grid[i][i] > 1 && grid[i + 1][i + 1] < N) {
                setGridValue(grid, i, i, grid[i][i] - 1);
                setGridValue(grid, i + 1, i + 1, grid[i][i] + 1);
            }
        }
    }

    private static void setGridValue(int[][] grid, int row, int col, int value) {
        grid[row][col] = value;
        rows[row][value] = true;
        columns[col][value] = true;
    }

    private static String printGrid(int[][] grid) {
        return Arrays.stream(grid)
                     .map(row -> Arrays.stream(row)
                                       .mapToObj(String::valueOf)
                                       .collect(Collectors.joining(" ")))
                     .collect(Collectors.joining("\n"));
    }

    public static void main(String[] args) throws Exception {
        long currTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - currTime));
        } else {
            solveProblem(System.in);
        }
    }
}