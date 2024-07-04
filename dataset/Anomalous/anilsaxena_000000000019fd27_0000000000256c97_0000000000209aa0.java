import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;
    private static int N, K;
    private static Slot[] slots;

    public static void main(String[] args) throws Exception {
        long currTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - currTime));
        } else {
            solveProblem(System.in);
        }
    }

    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int testCount = sc.nextInt();
        for (int t = 1; t <= testCount; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        int[][] grid = new int[N][N];
        boolean answer = solveGrid(grid, 0);
        StringBuilder result = new StringBuilder();
        if (answer) {
            result.append("POSSIBLE\n").append(printGrid(grid));
        } else {
            result.append("IMPOSSIBLE");
        }
        return result.toString();
    }

    private static boolean solveGrid(int[][] grid, int index) {
        if (index >= N * N) {
            return true;
        }
        int row = index / N;
        int col = index % N;
        if (grid[row][col] != 0) {
            return solveGrid(grid, index + 1);
        }
        for (int value = 1; value <= N; value++) {
            if (isValid(grid, row, col, value)) {
                grid[row][col] = value;
                if (solveGrid(grid, index + 1)) {
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int[][] grid, int row, int col, int value) {
        for (int j = 0; j < N; j++) {
            if (grid[row][j] == value || grid[j][col] == value) {
                return false;
            }
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
            if (valueCount == N && sum != K) {
                return false;
            }
        }
        return true;
    }

    private static String printGrid(int[][] grid) {
        return Arrays.stream(grid)
                .map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }

    public static void printDebug(Object str) {
        if (debug) {
            System.out.println("DEBUG: " + str);
        }
    }

    private static class Slot {
        String assignment;
        int start, end;
        Set<Slot> children = new HashSet<>();

        public Slot(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + "-" + end;
        }
    }

    public static void generateTestCases(int count) {
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        builder.append(count).append("\n");
        for (int i = 0; i < count; i++) {
            int N = 2 + rand.nextInt(9);
            builder.append(N).append("\n");
            int start = 0;
            for (int j = 0; j < N; j++) {
                start += rand.nextInt(5);
                int end = start + 1 + rand.nextInt(5);
                builder.append(start).append(" ").append(end).append("\n");
            }
        }
        try (FileWriter writer = new FileWriter("input.in")) {
            writer.write(builder.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}