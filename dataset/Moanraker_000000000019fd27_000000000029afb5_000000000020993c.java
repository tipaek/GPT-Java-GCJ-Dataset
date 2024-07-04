import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            oneRun(i);
        }
    }

    private static void oneRun(int num) {
        int N = sc.nextInt();
        int[][] M = new int[N][N];
        int rCount = 0, sum = 0;

        for (int i = 0; i < N; i++) {
            HashSet<Integer> rowNums = new HashSet<>(N);
            boolean hasDuplicate = false;
            for (int j = 0; j < N; j++) {
                M[i][j] = sc.nextInt();
                if (!hasDuplicate) {
                    if (rowNums.contains(M[i][j])) {
                        hasDuplicate = true;
                        rCount++;
                    } else {
                        rowNums.add(M[i][j]);
                    }
                }
            }
        }

        int cCount = 0;
        for (int j = 0; j < N; j++) {
            HashSet<Integer> colNums = new HashSet<>(N);
            boolean hasDuplicate = false;
            for (int i = 0; i < N; i++) {
                if (i == j) sum += M[i][j];
                if (!hasDuplicate) {
                    if (colNums.contains(M[i][j])) {
                        hasDuplicate = true;
                        cCount++;
                    } else {
                        colNums.add(M[i][j]);
                    }
                }
            }
        }

        System.out.println(String.format("Case #%s: %s %s %s", num, sum, rCount, cCount));
    }
}