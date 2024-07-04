import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private final Scanner in = new Scanner(System.in);

    private void solveCaseWithLimit(int t, int n) {
        List<int[]> positions = new ArrayList<>();
        if (n <= 500) {
            for (int i = 0; i < n; i++) {
                positions.add(new int[]{i + 1, i + 1});
            }
        } else {
            positions.add(new int[]{1, 1});
            positions.add(new int[]{2, 2});
            positions.add(new int[]{3, 2});
            n -= 4;
            int i = 3;
            while (n > 0) {
                positions.add(new int[]{i, i});
                i++;
                n--;
            }
        }
        printResult(t, positions);
    }

    private void solveCaseWithoutLimit(int t, int n) {
        List<int[]> positions = new ArrayList<>();
        positions.add(new int[]{1, 1});
        n--;
        int i = 1;
        while (i * (i + 1) / 2 <= n) {
            i++;
        }
        i--;
        int k;
        for (k = 1; k <= i; k++) {
            positions.add(new int[]{k + 1, 2});
            n -= k;
        }
        while (n > 0) {
            positions.add(new int[]{k + 1, 1});
            k++;
            n--;
        }
        printResult(t, positions);
    }

    private void printResult(int t, List<int[]> positions) {
        System.out.println(String.format("Case #%d:", t));
        for (int[] pos : positions) {
            System.out.println(pos[0] + " " + pos[1]);
        }
    }

    private void solve(int t, int n) {
        if (n <= 501) {
            solveCaseWithLimit(t, n);
        } else {
            solveCaseWithoutLimit(t, n);
        }
    }

    private void run() {
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            solve(t, n);
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}