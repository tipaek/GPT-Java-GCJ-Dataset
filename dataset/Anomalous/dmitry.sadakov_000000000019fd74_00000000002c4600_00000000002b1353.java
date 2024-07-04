import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final int LIMIT = 5;
    private static final int PASCAL_SIZE = 100;
    private long[][] pascal = new long[PASCAL_SIZE][PASCAL_SIZE];

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
            System.out.println("Case #" + caseNumber + ":");
            for (int i = result.size() - 1; i >= 0; i--) {
                System.out.println(result.get(i));
            }
        }
    }

    private void generatePascalTriangle() {
        pascal[0][0] = 1;
        for (int i = 1; i < PASCAL_SIZE; i++) {
            pascal[i][0] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
    }

    private List<String> solve(int targetSum) {
        List<String> path = new ArrayList<>();
        findPath(0, 0, 0, targetSum, path, false, false);
        return path;
    }

    private boolean findPath(int row, int col, long currentSum, long targetSum, List<String> path, boolean movedLeft, boolean movedUp) {
        currentSum += pascal[row][col];
        if (currentSum == targetSum) {
            path.add((row + 1) + " " + (col + 1));
            return true;
        }
        if (currentSum > targetSum) {
            return false;
        }

        if (!movedUp && row < LIMIT && pascal[row + 1][col] != 0) {
            if (findPath(row + 1, col, currentSum, targetSum, path, false, false)) {
                path.add((row + 1) + " " + (col + 1));
                return true;
            }
        }

        if (col < LIMIT && pascal[row][col + 1] != 0) {
            if (findPath(row, col + 1, currentSum, targetSum, path, true, false)) {
                path.add((row + 1) + " " + (col + 1));
                return true;
            }
        }

        if ((movedUp || movedLeft) && row > 0 && pascal[row - 1][col] != 0) {
            if (findPath(row - 1, col, currentSum, targetSum, path, false, true)) {
                path.add((row + 1) + " " + (col + 1));
                return true;
            }
        }

        return false;
    }
}