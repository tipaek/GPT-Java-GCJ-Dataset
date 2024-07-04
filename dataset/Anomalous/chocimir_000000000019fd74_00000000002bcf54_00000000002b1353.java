import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void solve(Scanner in) {
        int n = in.nextInt();
        if (n < 34) {
            for (int i = 1; i <= n; ++i) {
                System.out.println(i + " 1");
            }
            return;
        }
        
        int w = n - 32;
        int sum = 0;
        int row = 0, col = 0;
        int currentPower = 1;
        
        while (w != 0) {
            row++;
            if (w % 2 == 1) {
                sum += currentPower;
                if (col > 1) {
                    col = row;
                    for (int j = 0; j < col; j++) {
                        System.out.println(row + " " + j);
                    }
                    col = 1;
                } else {
                    col = 0;
                    for (int j = 1; j <= row; j++) {
                        System.out.println(row + " " + j);
                    }
                    col = row;
                }
            } else {
                sum += 1;
            }
            currentPower *= 2;
            w /= 2;
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
        
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": ");
            sol.solve(in);
        }
    }
}