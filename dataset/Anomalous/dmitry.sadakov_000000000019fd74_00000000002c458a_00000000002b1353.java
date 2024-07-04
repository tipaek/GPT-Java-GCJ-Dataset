import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final int MAX_SIZE = 500;
    private long[][] pascal = new long[MAX_SIZE][MAX_SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        Solution solution = new Solution();
        solution.generatePascalTriangle();

        for (int i = 1; i <= testCases; i++) {
            int targetSum = scanner.nextInt();
            scanner.nextLine();

            List<String> result = solution.solve(targetSum);
            System.out.println("Case #" + i + ": ");
            for (int j = result.size() - 1; j >= 0; j--) {
                System.out.println(result.get(j));
            }
        }
    }

    private void generatePascalTriangle() {
        pascal[0][0] = 1;
        for (int i = 1; i < MAX_SIZE; i++) {
            pascal[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
    }

    private List<String> solve(int targetSum) {
        List<String> steps = new ArrayList<>();
        walk(0, 0, 0, targetSum, steps, false, false);
        return steps;
    }

    private boolean walk(int i, int j, long currentSum, long targetSum, List<String> steps, boolean cameFromLeft, boolean cameFromUp) {
        currentSum += pascal[i][j];
        if (currentSum == targetSum) {
            steps.add((i + 1) + " " + (j + 1));
            return true;
        }
        if (currentSum > targetSum) {
            return false;
        }

        if (!cameFromUp && i + 1 < MAX_SIZE && pascal[i + 1][j] != 0) {
            if (walk(i + 1, j, currentSum, targetSum, steps, false, false)) {
                steps.add((i + 1) + " " + (j + 1));
                return true;
            }
        }

        if (j + 1 < MAX_SIZE && pascal[i][j + 1] != 0) {
            if (walk(i, j + 1, currentSum, targetSum, steps, true, false)) {
                steps.add((i + 1) + " " + (j + 1));
                return true;
            }
        }

        if ((cameFromUp || cameFromLeft) && i - 1 >= 0 && pascal[i - 1][j] != 0) {
            if (walk(i - 1, j, currentSum, targetSum, steps, false, true)) {
                steps.add((i + 1) + " " + (j + 1));
                return true;
            }
        }

        return false;
    }
}