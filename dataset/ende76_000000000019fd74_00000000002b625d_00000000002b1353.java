import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static List<int[]> solve(int n) {
        List<int[]> result = new LinkedList<>();
        if (n <= 500) {
            for (int i = 0; i < n; i += 1) {
                result.add(new int[] {i + 1, 1});
            }
            return result;
        }

        if (n <= 1000) {
            int sum = 1;
            result.add(new int[] {1, 1});
            int i = 1;
            for (; i < 499; i += 1) {
                if (sum + i > n) break;
                result.add(new int[] { i + 1, 2});
                sum += i;
            }

            while (sum < n) {
                result.add(new int[] {i, 1});
                sum += 1;
                i += 1;
            }
            return result;
        }

        return new LinkedList<>();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for (int t = 1; t <= T; t += 1) {
            int N = s.nextInt();

            List<int[]> result = solve(N);

            System.out.printf("Case #%d:\n", t);
            for (int[] p : result) {
                System.out.printf("%d %d\n", p[0], p[1]);
            }
        }
    }
}
