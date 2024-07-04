import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution1 {

    public int countDuplicateRowCount(int[][] mat, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < n; j++) {
                if (!set.add(mat[i][j])) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) count++;
        }
        return count;
    }

    public int countDuplicateColCount(int[][] mat, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < n; j++) {
                if (!set.add(mat[j][i])) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) count++;
        }
        return count;
    }

    public int sumOfDiagonal(int[][] mat, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution1 sol1 = new Solution1();
            int countDuplicateRow = sol1.countDuplicateRowCount(mat, n);
            int countDuplicateCol = sol1.countDuplicateColCount(mat, n);
            int sumOfDiagonal = sol1.sumOfDiagonal(mat, n);
            System.out.printf("Case #%d: %d %d %d%n", testCase, sumOfDiagonal, countDuplicateRow, countDuplicateCol);
        }
        sc.close();
    }
}