import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final int MAX_SIZE = 500;
    private long[][] pascal = new long[MAX_SIZE][MAX_SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        Solution solution = new Solution();
        solution.generatePascalTriangle();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int targetSum = scanner.nextInt();
            scanner.nextLine();
            List<String> result = solution.solve(targetSum);
            System.out.println("Case #" + caseNumber + ": ");
            for (int j = result.size() - 1; j >= 0; j--) {
                System.out.println(result.get(j));
            }
        }
    }

    private void generatePascalTriangle() {
        pascal[0][0] = 1;
        for (int i = 1; i < 100; i++) {
            pascal[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
    }

    private List<String> solve(int targetSum) {
        List<String> path = new ArrayList<>();
        findPath(0, 0, 0, targetSum, path);
        return path;
    }

    private boolean findPath(int row, int col, long currentSum, long targetSum, List<String> path) {
        currentSum += pascal[row][col];
        if (currentSum == targetSum) {
            path.add((row + 1) + " " + (col + 1));
            return true;
        }
        if (currentSum > targetSum) {
            return false;
        }

        int limit = MAX_SIZE - 1;
        // Move down
        if (row < limit && pascal[row + 1][col] != 0) {
            if (findPath(row + 1, col, currentSum, targetSum, path)) {
                path.add((row + 1) + " " + (col + 1));
                return true;
            }
        }
        // Move right
        if (col < limit && pascal[row][col + 1] != 0) {
            if (findPath(row, col + 1, currentSum, targetSum, path)) {
                path.add((row + 1) + " " + (col + 1));
                return true;
            }
        }
        return false;
    }
}