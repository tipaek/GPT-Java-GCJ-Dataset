import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCase = Integer.parseInt(input.nextLine());
        for (int i = 1; i <= testCase; i++) {
            solve(input, i);
        }
    }

    private static void solve(Scanner scanner, int c) {
        int n = Integer.parseInt(scanner.nextLine());
        int[][] m = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] splited = s.split("\\s+");
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.parseInt(splited[j]);
            }
        }
        long trace = getTrace(m, n);
        int row = check(m, n, true);
        int col = check(m, n, false);
        System.out.println("Case #" + c +": " + trace + " " + row + " " + col);
    }
    
    private static long getTrace(int[][] m, int n) {
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += m[i][i];
        }
        return res;
    }
}
