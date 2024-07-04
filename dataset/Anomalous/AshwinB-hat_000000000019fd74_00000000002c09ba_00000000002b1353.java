import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            new Util().solve(scanner.nextInt(), i);
        }
    }
}

class Util {
    private ArrayList<int[]> path = new ArrayList<>();
    private Boolean[][] visited;

    ArrayList<int[]> findPath(int startX, int startY, int targetSum) {
        visited = new Boolean[targetSum][targetSum];
        for (Boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        if (searchPath(startX, startY, targetSum)) {
            return path;
        }
        return path;
    }

    private boolean searchPath(int x, int y, int remainingSum) {
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

        if (x == 1 && searchPath(x + 1, y, remainingSum)) {
            return true;
        }
        if (searchPath(x + 1, y + 1, remainingSum) ||
            searchPath(x - 1, y, remainingSum) ||
            searchPath(x - 1, y + 1, remainingSum) ||
            searchPath(x + 1, y, remainingSum) ||
            searchPath(x, y - 1, remainingSum) ||
            searchPath(x, y + 1, remainingSum)) {
            return true;
        }

        path.remove(path.size() - 1);
        visited[x - 1][y - 1] = false;
        return false;
    }

    private int binomialCoefficient(int n, int k) {
        int result = 1;
        if (k > n - k) {
            k = n - k;
        }
        for (int i = 0; i < k; ++i) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    void solve(int targetSum, int testCaseNumber) {
        ArrayList<int[]> result = findPath(1, 1, targetSum);
        System.out.println("Case #" + testCaseNumber + ": ");
        for (int[] coordinates : result) {
            System.out.println(coordinates[0] + " " + coordinates[1]);
        }
    }
}