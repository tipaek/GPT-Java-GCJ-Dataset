import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ct = 1;
        while (ct <= t) {
            int n = sc.nextInt();
            int[][] ar = new int[n][n];
            int rowCount = 0, colCount = 0, sum = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> nums = new HashSet();
                for (int j = 0; j < n; j++) {
                    ar[i][j] = sc.nextInt();
                    nums.add(ar[i][j]);
                }
                if (nums.size() < n) rowCount++;
            }
            for (int j = 0; j < n; j++) {
                Set<Integer> nums = new HashSet();
                for (int i = 0; i < n; i++) {
                    nums.add(ar[i][j]);
                    if (i == j) sum += ar[i][j];
                }
                if (nums.size() < n) colCount++;
            }
            System.out.println("Case #" + ct + ": " + sum + " " + rowCount + " " + colCount);
            ct++;
        }
    }
}