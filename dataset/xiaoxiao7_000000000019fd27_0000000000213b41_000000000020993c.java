import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 1; i <= T; ++i) {
            int N = input.nextInt();
            int[][] nums = new int[N][N];
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < N; ++k) {
                    nums[j][k] = input.nextInt();
                }
            }
            Pair res = solve(nums);
            System.out.println("Case #" + i + ": " + res.x + " " + res.y + " " + res.z);
        }
    }

    public static Pair solve(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return new Pair(0, 0, 0);
        }
        int n = nums.length;
        int trace = 0;
        int rowCnt = 0;
        int colCnt = 0;
        for (int i = 0; i < n; ++i) {
            trace += nums[i][i];
        }
        for (int i = 0; i < n; ++i) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                if (!rowSet.add(nums[i][j])) {
                    ++rowCnt;
                    break;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                if (!colSet.add(nums[j][i])) {
                    ++colCnt;
                    break;
                }
            }
        }
        return new Pair(trace, rowCnt, colCnt);
    }

    public static class Pair {
        int x;
        int y;
        int z;
        public Pair(int a, int b, int c) {
            x = a;
            y = b;
            z = c;
        }
    }
}
