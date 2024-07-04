import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.valueOf(scanner.nextLine());
            System.out.println("Case #" + (i+1) + ":");
            System.out.println("1 1");
            solve(N-1);
        }
    }

    private static void solve(int n) {
        int row = 1;
        int col = 2;
        int max = max(n);
        for (int i = 0; i < max; i++) {
            row++;
            System.out.println(row + " " + col);
        }
        col--;
        int sum = max * (max+1) / 2;
        for (int i = 0; i < n-sum; i++) {
            System.out.println(row + " " + col);
            row--;
        }
    }

    private static int max(int n) {
        double num = Math.sqrt(1 + 8*n) - 1;
        num *= .5;
        return (int) num;
    }
}
