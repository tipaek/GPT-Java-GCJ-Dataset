
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    final static int[][] direction = {
            new int[]{-1, -1},
            new int[]{-1, 0},
            new int[]{0, -1},
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{1, 1}
    };

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final long[][] data = new long[501][501];
        data[1][1] = 1;
        final int count = in.nextInt();
        for (int i = 1; i <= count; i++) {
            long sum = in.nextLong();
            System.out.println("Case #" + i + ":");
            if (sum <= 500) {
                for (int j = 1; j <= sum; j++) {
                    System.out.println(j + " " + 1);
                }
            } else if (sum <= 1000) {
                long r = sum / 2;
                System.out.println(1 + " " + 1);
                if (sum % 2 != 0) {
                    System.out.println(2 + " " + 2);
                }
                for (int j = 2; j <= r; j++) {
                    System.out.println(j + " " + 1);
                }
                System.out.println((r + 1) + " " + 2);
            } else {
                // fail
                System.out.println("Case #" + i + ":");
                for (int j = 0; j < 500; j++) {
                    // fake
                    System.out.println(1 + " " + 1);
                }
            }
        }
    }
//    private static void solve(int i, long sum, long[][] data, int[] now, boolean[][] visited) {
//        final List<int[]> queue = new ArrayList<>();
//        queue.add(new int[]{1, 1});
//        visited[1][1] = true;
//        while (queue.isEmpty()) {
//            int[] first = queue.remove(0);
//            int r = first[0];
//            int k = first[1];
//            for (int[] d : direction) {
//                int nr = r + d[0];
//                int nk = k + d[1];
//                if (nk < 1 || nk > nr || nr < 1) {
//                    continue;
//                }
//                if (visited[nr][nk]) {
//                    continue;
//                }
//
//            }
//        }
//
//    }

    private static long calculate(long[][] data, int r, int k) {
        if (data[r][k] != 0) {
            return data[r][k];
        }
        if (k == 1) {
            data[r][k] = 1;
            return 1;
        }
        if (r == k) {
            data[r][k] = 1;
            return 1;
        }
        long l = calculate(data, r - 1, k - 1) + calculate(data, r - 1, k);
        data[r][k] = l;
        return l;
    }
}
