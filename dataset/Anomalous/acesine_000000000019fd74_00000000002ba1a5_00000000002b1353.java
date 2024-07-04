import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);

    private void solve(int testCaseNumber) {
        int n = scanner.nextInt();
        List<int[]> positions = new ArrayList<>();

        if (n <= 500) {
            for (int i = 1; i <= n; i++) {
                positions.add(new int[]{i, i});
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

        System.out.printf("Case #%d:%n", testCaseNumber);
        for (int[] position : positions) {
            System.out.println(position[0] + " " + position[1]);
        }
    }

    private void run() {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            solve(t);
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}