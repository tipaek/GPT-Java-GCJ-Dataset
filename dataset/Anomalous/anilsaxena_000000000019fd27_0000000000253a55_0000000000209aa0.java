import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;
    private static int N, K;
    private static Slot[] slots;

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Execution Time: " + (System.currentTimeMillis() - startTime));
        } else {
            solveProblem(System.in);
        }
    }

    private static void solveProblem(InputStream inputStream) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            N = scanner.nextInt();
            K = scanner.nextInt();
            String result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String solveTestCase() {
        int[][] grid = new int[N][N];
        int floor = K / N;
        int sum = floor * N;

        for (int i = 0; i < N; i++) {
            grid[i][i] = floor;
        }

        int index = 0;
        while (sum < K) {
            if (grid[index][index] == N) {
                index++;
            }
            grid[index][index]++;
            sum++;
        }

        boolean possible = solveGrid(grid, 1);
        StringBuilder result = new StringBuilder();
        if (possible) {
            result.append("POSSIBLE\n");
            result.append(printGrid(grid));
        } else {
            result.append("IMPOSSIBLE");
        }

        return result.toString();
    }

    private static boolean solveGrid(int[][] grid, int index) {
        if (index == N * N) {
            return true;
        }

        int row = index / N;
        int col = index % N;

        if (grid[row][col] != 0) {
            return solveGrid(grid, index + 1);
        }

        for (int value = 1; value <= N; value++) {
            boolean valid = true;

            for (int j = 0; j < N; j++) {
                if (grid[row][j] == value || grid[j][col] == value) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                grid[row][col] = value;
                if (solveGrid(grid, index + 1)) {
                    return true;
                }
                grid[row][col] = 0; // Backtrack
            }
        }

        return false;
    }

    private static String printGrid(int[][] grid) {
        return Arrays.stream(grid)
                     .map(row -> Arrays.stream(row)
                                       .mapToObj(String::valueOf)
                                       .collect(Collectors.joining(" ")))
                     .collect(Collectors.joining("\n"));
    }

    private static class Slot {
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

    public static void printDebug(Object message) {
        if (debug) {
            System.out.println("DEBUG: " + message);
        }
    }

    public static void generateTestCases(int count) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        builder.append(count).append("\n");

        for (int i = 0; i < count; i++) {
            int N = 2 + random.nextInt(9);
            builder.append(N).append("\n");
            int start = 0;
            for (int j = 0; j < N; j++) {
                start += random.nextInt(5);
                int end = start + 1 + random.nextInt(5);
                builder.append(start).append(" ").append(end).append("\n");
            }
        }

        try (FileWriter writer = new FileWriter("input.in")) {
            writer.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}