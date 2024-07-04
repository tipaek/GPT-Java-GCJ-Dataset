import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    static Scanner in;
    static int n, k;
    static String y = "*";
    static int[][] triangle = new int[500][500];
    static boolean[][] taken = new boolean[500][500];
    static List<PascalEntry> solution = new ArrayList<>();

    public static void main(String[] args) {
        prepareTriangle();
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            solution = new ArrayList<>();
            solution.add(new PascalEntry(1, 1));
            n = in.nextInt();
            solve(in, n);
            //TODO Print Solution
            System.out.println("Case #" + (i + 1) + ":");
            printSolution();
        }
    }

    private static void prepareTriangle() {
        for (int i = 0; i < 500; i++)
            triangle[i][0] = 1;

        for (int i = 1; i < 500; i++) {
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
    }

    private static void printSolution() {
//        int sol = 0;
        for (int i = 0; i < solution.size(); i++) {
            System.out.println(solution.get(i).toString());
//            sol += solution.get(i).value;
        }
//        System.out.println("Sum: " + sol);
    }

    private static void solve(Scanner in, int n) {
        if (n <= 500) {
            //trivial
            for (int i = 2; i <= n; i++)
                solution.add(new PascalEntry(i, 1));
        }
        Set<PascalEntry> used = new HashSet<>();
        used.addAll(solution);
        solution.addAll(dfs(1, 1, n - 1, used));
    }

    private static List<PascalEntry> dfs(int row, int col, int remainingSum, Set<PascalEntry> takenEntries) {
        List<PascalEntry> ret = new ArrayList<>();
        if (remainingSum == 0)
            return ret;

        PascalEntry checkBL = new PascalEntry(row + 1, col - 1);
        PascalEntry checkBR = new PascalEntry(row + 1, col + 1);
        PascalEntry checkSL = new PascalEntry(row, col - 1);
        PascalEntry checkSR = new PascalEntry(row, col + 1);
        PascalEntry checkTL = new PascalEntry(row - 1, col - 1);
        PascalEntry checkTR = new PascalEntry(row - 1, col + 1);

        List<PascalEntry> sorting = new ArrayList<>();
        sorting.add(checkBL);
        sorting.add(checkBR);
        sorting.add(checkSL);
        sorting.add(checkSR);
        sorting.add(checkTL);
        sorting.add(checkTR);

        sorting = sorting.stream().filter(val -> !takenEntries.contains(val))
                .filter(val -> val.value <= remainingSum)
                .sorted((x, y) -> Integer.compare(y.value, x.value))
                .collect(Collectors.toList());
        for (PascalEntry toUse : sorting) {
            takenEntries.add(toUse);
            List<PascalEntry> dfsResult = dfs(toUse.row, toUse.col, remainingSum - toUse.value, takenEntries);
            int sum = dfsResult.stream().mapToInt(i -> i.value).sum();
            sum += toUse.value;
            if (sum == remainingSum) {
                ret.add(toUse);
                ret.addAll(dfsResult);
                return ret;
            }
        }
        return ret;
    }

    public static class PascalEntry {
        int row, col, value;

        public PascalEntry(int row, int col) {
            this.row = Math.min(Math.max(1, row), 500);
            this.col = Math.min(Math.max(1, col), this.row);
            this.value = triangle[this.row - 1][this.col - 1];
        }

        public PascalEntry(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PascalEntry)) return false;
            PascalEntry that = (PascalEntry) o;
            return row == that.row &&
                    col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return row + " " + col;
        }
    }
}
