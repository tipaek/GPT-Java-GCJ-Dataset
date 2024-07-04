package CodeJam2020.QualificationRound.Round1A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private ArrayList<int[]> path = new ArrayList<>();
    private Boolean[][] visited;

    ArrayList<int[]> findPath(int x, int y, int targetSum) {
        visited = new Boolean[targetSum][targetSum];
        for (Boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        if (explore(x, y, targetSum)) {
            return path;
        }
        return path;
    }

    private Boolean explore(int x, int y, int remainingSum) {
        if (x < 1 || y < 1 || y > x) {
            return false;
        }
        if (visited[x - 1][y - 1]) {
            return false;
        }
        int value = binomialCoefficient(x - 1, y - 1);

        if (value > remainingSum) {
            return false;
        }
        path.add(new int[]{x, y});
        visited[x - 1][y - 1] = true;
        remainingSum -= value;

        if (remainingSum == 0) {
            return true;
        }

        int[][] directions = {
            {1, 1}, {-1, 0}, {-1, 1}, {1, 0}, {0, -1}, {0, 1}
        };

        for (int[] dir : directions) {
            if (explore(x + dir[0], y + dir[1], remainingSum)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        visited[x - 1][y - 1] = false;
        return false;
    }

    static int binomialCoefficient(int n, int k) {
        int res = 1;
        if (k > n - k) {
            k = n - k;
        }
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    static void solve(int targetSum, int caseNumber) {
        ArrayList<int[]> result = new Solution().findPath(1, 1, targetSum);
        System.out.println("Case #" + caseNumber + ":");
        for (int[] coordinates : result) {
            System.out.println(coordinates[0] + " " + coordinates[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solve(scanner.nextInt(), i);
        }
        scanner.close();
    }
}