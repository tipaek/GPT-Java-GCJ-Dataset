import java.io.*;
import java.util.*;

public class Solution {
    static final int MAX = 501;
    static int[][] dp = new int[MAX][MAX];
    static int[] row = {-1, -1, 0, 0, 1, 1};
    static int[] col = {-1, 0, -1, 1, 0, 1};
    static boolean[][] visited;
    static List<Pair> ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int caseNumber = 1;
        
        initializeDP();

        while (T-- > 0) {
            int N = sc.nextInt();
            visited = new boolean[MAX][MAX];
            ans = new ArrayList<>();

            System.out.println("Case #" + caseNumber + ":");
            if (N == 1) {
                System.out.println(1 + " " + 1);
            } else {
                List<Pair> path = new ArrayList<>();
                path.add(new Pair(1, 1));
                DFS(N - 1, path, 1, 1);
                for (Pair p : ans) {
                    System.out.println(p.x + " " + p.y);
                }
            }
            caseNumber++;
        }
    }

    private static void initializeDP() {
        dp[1][1] = 1;
        for (int i = 2; i < MAX; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
    }

    private static void DFS(int remainingSum, List<Pair> path, int x, int y) {
        visited[x][y] = true;

        if (remainingSum == 0 && ans.isEmpty()) {
            ans.addAll(path);
            return;
        }

        for (int i = 0; i < 6; i++) {
            int newX = x + row[i];
            int newY = y + col[i];
            if (isValid(newX, newY, remainingSum)) {
                path.add(new Pair(newX, newY));
                DFS(remainingSum - dp[newX][newY], path, newX, newY);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isValid(int x, int y, int remainingSum) {
        return x >= 1 && x < MAX && y >= 1 && y < MAX && !visited[x][y] && remainingSum - dp[x][y] >= 0 && dp[x][y] != 0 && ans.isEmpty();
    }
}

class Pair {
    int x, y;

    Pair(int a, int b) {
        x = a;
        y = b;
    }
}