import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            solve(n, i);
        }
    }

    private static void solve(int N, int testCase) {
        List<List<Integer>> pascalTriangle = generatePascalTriangle(500);
        List<int[]> result = new ArrayList<>();
        List<int[]> path = new ArrayList<>();
        path.add(new int[]{0, 0});
        findPath(N - 1, result, path, new boolean[N][N], pascalTriangle, new int[]{0, 0});
        System.out.println("Case #" + testCase + ":");
        for (int[] coordinates : result) {
            System.out.println((coordinates[0] + 1) + " " + (coordinates[1] + 1));
        }
    }

    private static void findPath(int N, List<int[]> result, List<int[]> path, boolean[][] visited, List<List<Integer>> pascalTriangle, int[] currentPosition) {
        if (path.size() > 500 || N < 0) {
            return;
        }
        if (N == 0) {
            result.addAll(new ArrayList<>(path));
            return;
        }

        int[][] movements = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}};
        for (int[] move : movements) {
            int x = currentPosition[0] + move[0];
            int y = currentPosition[1] + move[1];
            if (x < 0 || y < 0 || x >= pascalTriangle.size() || x < y || visited[x][y]) {
                continue;
            }
            int[] newPosition = {x, y};
            path.add(newPosition);
            visited[x][y] = true;
            findPath(N - pascalTriangle.get(x).get(y), result, path, visited, pascalTriangle, newPosition);
            if (!result.isEmpty()) {
                return;
            }
            path.remove(path.size() - 1);
            visited[x][y] = false;
        }
    }

    private static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        if (numRows == 0) {
            return pascalTriangle;
        }
        pascalTriangle.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = pascalTriangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            currentRow.add(1);
            pascalTriangle.add(currentRow);
        }
        return pascalTriangle;
    }
}