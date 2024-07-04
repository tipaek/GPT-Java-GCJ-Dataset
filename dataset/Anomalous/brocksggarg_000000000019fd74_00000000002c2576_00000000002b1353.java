import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    private static final int MAX = 500;
    private static int[][] arr = new int[MAX + 1][MAX + 1];
    private static boolean[][] vis = new boolean[MAX][MAX];
    private static Stack<String> stack = new Stack<>();
    private static int req = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        initializeArray();
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ":");
            solve(br);
        }
    }

    private static void initializeArray() {
        for (int n = 1; n <= MAX; n++) {
            for (int r = 1; r <= MAX; r++) {
                if (n == r) {
                    arr[n][r] = 1;
                    arr[n][r + 1] = -1;
                    break;
                }
                if (r == 1) {
                    arr[n][r] = 1;
                } else {
                    arr[n][r] = arr[n - 1][r - 1] + arr[n - 1][r];
                }
            }
        }
    }

    private static void solve(BufferedReader br) throws NumberFormatException, IOException {
        vis = new boolean[MAX][MAX];
        int n = Integer.parseInt(br.readLine());
        req = n;

        vis[1][1] = true;
        findPath(2, 1, 1);
        System.out.println(1 + " " + 1);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static boolean findPath(int i, int j, int sum) {
        if (isInvalid(i, j) || vis[i][j] || arr[i][j] < 0 || (sum + arr[i][j]) > req) {
            return false;
        }
        if (sum + arr[i][j] == req) {
            stack.push(i + " " + j);
            return true;
        }
        vis[i][j] = true;
        if (findPath(i + 1, j + 1, sum + arr[i][j]) ||
            findPath(i + 1, j, sum + arr[i][j]) ||
            findPath(i, j - 1, sum + arr[i][j]) ||
            findPath(i - 1, j - 1, sum + arr[i][j]) ||
            findPath(i - 1, j, sum + arr[i][j]) ||
            findPath(i, j + 1, sum + arr[i][j])) {
            stack.push(i + " " + j);
            return true;
        }
        vis[i][j] = false;
        return false;
    }

    private static boolean isInvalid(int i, int j) {
        return i > MAX || j > MAX || i < 1 || j < 1;
    }
}