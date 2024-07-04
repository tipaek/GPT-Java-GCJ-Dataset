import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            solve(new int[]{x, y}, i);
        }
    }

    private static void solve(int[] destination, int caseNumber) {
        List<Character> result = new ArrayList<>();
        List<Character> path = new ArrayList<>();
        boolean[][] visited = new boolean[200][200]; // Adjusted to a reasonable size

        dfs(1, destination, new int[]{0, 0}, result, path, visited);

        System.out.print("Case #" + caseNumber + ": ");
        if (result.isEmpty()) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void dfs(int n, int[] destination, int[] location, List<Character> result, List<Character> path, boolean[][] visited) {
        int length = (int) Math.pow(2, n - 1);

        if (Math.abs(location[0] - destination[0]) < length && Math.abs(location[1] - destination[1]) < length) {
            return;
        }

        if (location[0] == destination[0] && location[1] == destination[1]) {
            result.addAll(new ArrayList<>(path));
            return;
        }

        int[][] steps = {{length, 0}, {-length, 0}, {0, length}, {0, -length}};
        char[] directions = {'E', 'W', 'N', 'S'};

        for (int i = 0; i < steps.length; i++) {
            int[] step = steps[i];
            int x = location[0] + step[0];
            int y = location[1] + step[1];

            if (x + 100 >= 200 || y + 100 >= 200 || x + 100 < 0 || y + 100 < 0 || visited[x + 100][y + 100]) {
                continue;
            }

            path.add(directions[i]);
            visited[x + 100][y + 100] = true;

            dfs(n + 1, destination, new int[]{x, y}, result, path, visited);

            if (!result.isEmpty()) {
                return;
            }

            path.remove(path.size() - 1);
            visited[x + 100][y + 100] = false;
        }
    }
}