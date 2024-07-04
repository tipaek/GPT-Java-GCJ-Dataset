import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test = 1; test <= t; test++) {
            int n = sc.nextInt();
            StringBuilder ans = new StringBuilder("1 1\n");

            if (n == 1) {
                System.out.println("Case #" + test + ": \n" + ans);
                continue;
            }

            ans.append("2 1\n");
            int sum = 2;
            int row = 3;

            if (sum < n) {
                ans.append("3 2\n");
                sum += 2;

                while (sum < n) {
                    ans.append(row).append(" 1\n");
                    row++;
                    sum++;
                }
            }

            System.out.println("Case #" + test + ": \n" + ans);
        }
    }
}