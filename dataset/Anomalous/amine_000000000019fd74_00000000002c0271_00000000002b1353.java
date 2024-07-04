import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        List<Long> scenarios = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            scenarios.add(scanner.nextLong());
        }

        for (int i = 0; i < scenarios.size(); i++) {
            System.out.printf("Case #%d:%n", i + 1);
            long n = scenarios.get(i);
            int r = 1;
            int k = 1;
            int sum = 1;

            while (sum <= n) {
                System.out.printf("%d %d%n", r, k);
                if (sum == n) break;
                r++;
                sum++;
            }
        }

        scanner.close();
    }
}