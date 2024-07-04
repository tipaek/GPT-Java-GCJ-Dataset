import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final int MAX_SIZE = 500;
    private long[][] pascal = new long[MAX_SIZE][MAX_SIZE];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        Solution solution = new Solution();
        solution.generatePascalTriangle();
        for (int i = 1; i <= t; i++) {
            int a = in.nextInt();
            in.nextLine();
            List<String> answer = solution.solve(a);
            System.out.println("Case #" + i + ":");
            for (int j = answer.size() - 1; j >= 0; j--) {
                System.out.println(answer.get(j));
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

    private List<String> solve(int n) {
        List<String> steps = new ArrayList<>();
        walk(0, 0, 0, n, steps, false, false);
        return steps;
    }

    private boolean walk(int i, int j, long sum, long target, List<String> steps, boolean steppedLeft, boolean steppedUp) {
        sum += pascal[i][j];
        if (sum == target) {
            steps.add((i + 1) + " " + (j + 1));
            return true;
        }
        if (sum > target) {
            return false;
        }

        int limit = MAX_SIZE;

        // Try moving down
        if (!steppedUp && i + 1 < limit && pascal[i + 1][j] != 0) {
            if (walk(i + 1, j, sum, target, steps, false, false)) {
                steps.add((i + 1) + " " + (j + 1));
                return true;
            }
        }

        // Try moving right
        if (j + 1 < limit && pascal[i][j + 1] != 0) {
            if (walk(i, j + 1, sum, target, steps, true, false)) {
                steps.add((i + 1) + " " + (j + 1));
                return true;
            }
        }

        // Try moving up
        if ((steppedUp || steppedLeft) && i - 1 >= 0 && pascal[i - 1][j] != 0) {
            if (walk(i - 1, j, sum, target, steps, false, true)) {
                steps.add((i + 1) + " " + (j + 1));
                return true;
            }
        }

        return false;
    }
}