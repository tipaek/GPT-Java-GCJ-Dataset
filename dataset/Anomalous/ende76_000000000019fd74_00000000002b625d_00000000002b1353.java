import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static List<int[]> solve(int n) {
        List<int[]> result = new ArrayList<>();
        
        if (n <= 500) {
            for (int i = 1; i <= n; i++) {
                result.add(new int[] {i, 1});
            }
        } else if (n <= 1000) {
            int sum = 1;
            result.add(new int[] {1, 1});
            int i;
            for (i = 1; i < 499 && sum + i < n; i++) {
                result.add(new int[] {i + 1, 2});
                sum += i;
            }
            while (sum < n) {
                result.add(new int[] {i, 1});
                sum++;
                i++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            List<int[]> result = solve(N);

            System.out.printf("Case #%d:\n", t);
            for (int[] coordinates : result) {
                System.out.printf("%d %d\n", coordinates[0], coordinates[1]);
            }
        }
    }
}