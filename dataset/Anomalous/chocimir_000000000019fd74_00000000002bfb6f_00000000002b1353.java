import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void solve(Scanner scanner) {
        int n = scanner.nextInt();
        if (n < 34) {
            for (int i = 1; i <= n; i++) {
                System.out.println(i + " 1");
            }
            return;
        }

        int remaining = n - 32;
        int sum = 0;
        int row = 0;
        boolean isLeft = true;
        int currentPower = 1;

        while (remaining != 0) {
            row++;
            if (remaining % 2 == 0) {
                sum++;
                int col = isLeft ? 1 : row;
                System.out.println(row + " " + col);
            } else {
                sum += currentPower;
                if (isLeft) {
                    for (int col = 1; col <= row; col++) {
                        System.out.println(row + " " + col);
                    }
                } else {
                    for (int col = row; col > 0; col--) {
                        System.out.println(row + " " + col);
                    }
                }
                isLeft = !isLeft;
            }
            currentPower *= 2;
            remaining /= 2;
        }

        while (sum < n) {
            row++;
            int col = isLeft ? 1 : row;
            System.out.println(row + " " + col);
            sum++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        Solution solution = new Solution();
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ":");
            solution.solve(scanner);
        }
    }
}