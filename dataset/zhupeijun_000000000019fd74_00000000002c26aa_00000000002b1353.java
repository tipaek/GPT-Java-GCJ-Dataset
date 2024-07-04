import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private Scanner sc = new Scanner(System.in);

    private void solve() {
        int N = sc.nextInt();
        List<int[]> path = new ArrayList<>();
        path.add(new int[] {1, 1});
        int cur = 1;
        int row = 2;
        int col = 2;
        int sum = 1;
        while (sum + cur <= N) {
            path.add(new int[] {row, col});
            sum += cur;
            ++row;
            ++cur;
        }

        col = 1;
        while (sum + 1 <= N) {
            path.add(new int[] {row, col});
            ++sum;
            --row;
        }

        for (int[] p : path) {
            System.out.println(String.format("%d %d", p[0], p[1]));
        }
    }

    private void run() {
        int T = sc.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.println(String.format("Case #%d:", i));
            solve();
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
