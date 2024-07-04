import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            long left = scanner.nextInt();
            long right = scanner.nextInt();

            int customerCount = 0;
            while (customerCount + 1 <= left || customerCount + 1 <= right) {
                customerCount++;
                if (right > left) {
                    right -= customerCount;
                } else {
                    left -= customerCount;
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            System.out.print(customerCount +  " " + left + " " + right);
            if (i != n - 1)
                System.out.println();
        }
    }
}
