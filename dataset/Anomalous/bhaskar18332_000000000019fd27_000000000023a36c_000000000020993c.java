import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scan.nextInt();
            int[][] nums = new int[n][n];
            int trace = 0;
            int r = 0;
            int c = 0;

            // Reading matrix and calculating trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = scan.nextInt();
                    if (i == j) {
                        trace += nums[i][j];
                    }
                }
            }

            // Checking for duplicate values in rows
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(nums[i][j])) {
                        r++;
                        break;
                    }
                }
            }

            // Checking for duplicate values in columns
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(nums[i][j])) {
                        c++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + r + " " + c);
        }
    }
}