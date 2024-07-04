import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private final int id;
    private final int size;
    private final int[][] data;

    private int rows;
    private int columns;
    private int sum;

    public Solution(int id, int size, int[][] data) {
        this.id = id;
        this.size = size;
        this.data = data;
        this.rows = 0;
        this.columns = 0;
        this.sum = 0;
    }

    private void solve() {
        for (int i = 0; i < size; i++) {
            Solver rowSolver = new Solver(size);
            Solver columnSolver = new Solver(size);
            for (int j = 0; j < size; j++) {
                rowSolver.visit(data[i][j]);
                columnSolver.visit(data[j][i]);
                if (i == j) {
                    sum += data[i][j];
                }
            }
            if (!rowSolver.allTrue()) {
                rows ++;
            }
            if (!columnSolver.allTrue()) {
                columns ++;
            }
        }
    }

    @Override
    public String toString() {
        return "Case #" + id + ": " + sum + " " + rows + " " + columns;
    }

    private static class Solver {
        private final boolean[] map;

        private void visit(int position) {
            map[position - 1] = true;
        }

        private Solver(int size) {
            this.map = new boolean[size];
        }

        private boolean allTrue() {
            boolean allTrue = true;
            for (boolean b : map) {
                allTrue &= b;
            }
            return allTrue;
        }
    }

    static void processInput(InputStream inputStream) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        int tests = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            int size = Integer.parseInt(in.nextLine());
            int[][] data = new int[size][size];
            for (int n = 1; n <= size; n++) {
                String[] testData = in.nextLine().split(" ");
                data[n - 1] = Arrays.stream(testData)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            }

            Solution solution = new Solution(testNumber, size, data);
            solution.solve();

            System.out.println(solution);
        }
    }

    public static void main(String[] args) {
        Solution.processInput(System.in);
    }
}