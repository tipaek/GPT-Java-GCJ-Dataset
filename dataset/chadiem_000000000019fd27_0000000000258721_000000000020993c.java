import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<TestCase> testCaseList = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            int tc = sc.nextInt();
            for (int i = 0; i < tc; i++) {
                TestCase testCase = new TestCase();
                testCase.parse(sc);
                testCaseList.add(testCase);
            }
        }

        for (int i = 0; i < testCaseList.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + testCaseList.get(i).solve());
        }

    }

    private static class TestCase {

        int n;
        int[][] arr;

        public void parse(Scanner sc) {
            n = sc.nextInt();

            arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
        }

        public String solve() {
            long sum = 0;
            int dupesRow = 0;
            int dupesCol = 0;
            for (int d = 0; d < n; d++) {
                sum += arr[d][d];
                if (hasDupesRow(d)) {
                    dupesRow++;
                }
                if (hasDupesCol(d)) {
                    dupesCol++;
                }
            }

            return sum + " " + dupesRow + " " + dupesCol;
        }


        private boolean hasDupesRow(int row) {
            Set<Integer> ints = new HashSet<>();
            for (int col = 0; col < n; col++) {
                if (!ints.add(arr[row][col])) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasDupesCol(int col) {
            Set<Integer> ints = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (!ints.add(arr[row][col])) {
                    return true;
                }
            }
            return false;
        }
    }
}
