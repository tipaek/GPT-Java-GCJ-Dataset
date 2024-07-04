
import java.util.*;

public class Solution {
    static Set<Integer> containedR = new TreeSet<>();
    static Set<Integer> containedC = new TreeSet<>();

    public static void main(String[] args) {
        List<TestCase> testCases = readInput();
        int i = 1;
        for (TestCase testCase : testCases) {
            int[] ints = solveTestCase(testCase);
            System.out.println("Case #" + i++ + ": " + ints[0] + " " + ints[1] + " " + ints[2]);
        }
    }

    static List<TestCase> readInput() {
        List<TestCase> results = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        TestCase testCase = null;
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            testCase = new TestCase(n, new int[n][n]);
            for (int j = 0; j < n; j++) {
                String[] parts = scanner.nextLine().split(" ");
                for (int k = 0; k < n; k++) {
                    testCase.matrix[j][k] = Integer.parseInt(parts[k]);
                }
            }
            results.add(testCase);
        }
        return results;
    }

    static int[] solveTestCase(TestCase testCase) {
        int trace = 0;
        for (int i = 0; i < testCase.n; i++) {
            trace += testCase.matrix[i][i];
        }

        int r = 0, c = 0;
        for (int i = 0; i < testCase.n; i++) {
            containedR.clear();
            containedC.clear();
            for (int j = 0; j < testCase.n; j++) {
                containedR.add(testCase.matrix[i][j]);
                containedC.add(testCase.matrix[j][i]);
            }
            if (containedR.size() != testCase.n) {
                ++r;
            }
            if (containedC.size() != testCase.n) {
                ++c;
            }
        }
        return new int[]{trace, r, c};
    }

    static class TestCase {
        int n;
        int[][] matrix;

        public TestCase(int n, int[][] matrix) {
            this.n = n;
            this.matrix = matrix;
        }
    }
}
