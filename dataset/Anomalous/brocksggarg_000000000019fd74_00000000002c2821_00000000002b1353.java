import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    private static final int MAX_SIZE = 501;
    private static int[][] arr = new int[MAX_SIZE][MAX_SIZE];
    private static boolean[][] vis = new boolean[MAX_SIZE][MAX_SIZE];
    private static int req = 0;
    private static Stack<String> stack = new Stack<>();

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
        for (int n = 1; n < MAX_SIZE - 1; n++) {
            for (int r = 1; r < MAX_SIZE - 1; r++) {
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
        vis = new boolean[MAX_SIZE][MAX_SIZE];
        int n = Integer.parseInt(br.readLine());
        req = n;

        vis[1][1] = true;
        calculate(2, 1, 1);
        System.out.println("1 1");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static boolean calculate(int i, int j, int sum) {
        if (isInvalid(i, j) || vis[i][j] || arr[i][j] < 0 || (sum + arr[i][i]) > req) {
            return false;
        }
        if (sum + arr[i][j] == req) {
            stack.push(i + " " + j);
            return true;
        }
        vis[i][j] = true;
        if (calculate(i + 1, j + 1, sum + arr[i][j]) ||
            calculate(i + 1, j, sum + arr[i][j]) ||
            calculate(i, j - 1, sum + arr[i][j]) ||
            calculate(i - 1, j - 1, sum + arr[i][j]) ||
            calculate(i - 1, j, sum + arr[i][j]) ||
            calculate(i, j + 1, sum + arr[i][j])) {
            stack.push(i + " " + j);
            return true;
        }
        vis[i][j] = false;
        return false;
    }

    private static boolean isInvalid(int i, int j) {
        return i >= MAX_SIZE || j >= MAX_SIZE || i < 1 || j < 1;
    }
}