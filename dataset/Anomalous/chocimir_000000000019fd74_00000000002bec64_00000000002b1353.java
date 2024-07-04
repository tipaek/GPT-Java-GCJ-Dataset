import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void solve(Scanner in) {
        int n = in.nextInt();
        if (n < 34) {
            for (int i = 1; i <= n; i++) {
                System.out.println(i + " 1");
            }
            return;
        }

        int remaining = n - 32;
        int sum = 0;
        int row = 0, col = 0;
        int powerOfTwo = 1;

        while (remaining != 0) {
            row++;
            if (remaining % 2 == 1) {
                sum += powerOfTwo;
                if (col > 1) {
                    col = row + 1;
                    while (--col > 0) {
                        System.out.println(row + " " + col);
                    }
                    col = 1;
                } else {
                    col = 0;
                    while (col++ < row) {
                        System.out.println(row + " " + col);
                    }
                    col = row;
                }
            } else {
                col = col == 1 ? 1 : row;
                System.out.println(row + " " + col);
                sum += 1;
            }
            powerOfTwo *= 2;
            remaining /= 2;
        }

        row++;
        while (sum < n) {
            System.out.println(row + " " + col);
            row++;
            sum++;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        Solution sol = new Solution();
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ":");
            sol.solve(in);
        }
    }
}