import java.util.*;

public class Solution {
    public static int[][] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve(scanner.nextInt(), scanner.nextInt());
        }
    }

    public static void solve(int n, int k) {
        if (k < n || k > n * n) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        
        List<List<Integer>> possibleSolutions = new ArrayList<>();
        findCombinations(n, k, 1, 0, new ArrayList<>(), possibleSolutions);

        boolean foundSolution = false;
        for (int i = possibleSolutions.size() - 1; i >= 0; i--) {
            if (isValidSolution(possibleSolutions.get(i), n)) {
                System.out.print("POSSIBLE");
                foundSolution = true;
                break;
            }
        }

        if (!foundSolution) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (int[] row : result) {
                System.out.println();
                for (int value : row) {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
    }

    public static void findCombinations(int n, int k, int start, int sum, List<Integer> current, List<List<Integer>> possibleSolutions) {
        if (sum == k && current.size() == n) {
            possibleSolutions.add(new ArrayList<>(current));
        } else if (sum < k && current.size() < n) {
            for (int i = start; i <= n; i++) {
                current.add(i);
                findCombinations(n, k, i, sum + i, current, possibleSolutions);
                current.remove(current.size() - 1);
            }
        }
    }

    public static boolean isValidSolution(List<Integer> list, int n) {
        result = new int[n][n];
        List<Integer> content = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result[i][i] = list.get(i);
            content.add(i + 1);
        }
        return backtrack(result, content, 0, 0);
    }

    public static boolean backtrack(int[][] grid, List<Integer> content, int row, int col) {
        if (row == grid.length) {
            return true;
        }
        if (col == grid.length) {
            return backtrack(grid, content, row + 1, 0);
        }
        if (grid[row][col] != 0) {
            return backtrack(grid, content, row, col + 1);
        }

        List<Integer> available = new ArrayList<>(content);
        for (int x = 0; x < grid.length; x++) {
            if (grid[row][x] != 0) {
                available.remove(new Integer(grid[row][x]));
            }
            if (grid[x][col] != 0 && available.contains(grid[x][col])) {
                available.remove(new Integer(grid[x][col]));
            }
        }

        if (available.isEmpty()) {
            return false;
        } else {
            for (int value : available) {
                grid[row][col] = value;
                if (backtrack(grid, content, row, col + 1)) {
                    return true;
                }
            }
        }
        grid[row][col] = 0; // Reset the cell if no valid number was found
        return false;
    }
}