import java.util.*;

public class Solution {
    public static String solve(Scanner scanner) {
        int n = scanner.nextInt();

        int[][] mat = new int[n][n];

        int k = 0;
        int r = 0;
        int c = 0;

        Set<Integer> cols = new HashSet<>();
        Set<Integer> rows = new HashSet<>();
        boolean rowDone = false;
        boolean colDone = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = scanner.nextInt();
                mat[i][j] = num;
                if (i == j) {
                    k += num;
                }
                if (!rowDone && rows.contains(num)) {
                    r++;
                    rowDone = true;
                } else {
                    rows.add(num);
                }
            }
            rowDone = false;
            rows = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = mat[j][i];
                if (!colDone && cols.contains(num)) {
                    c++;
                    colDone = true;
                } else {
                    cols.add(num);
                }
            }
            colDone = false;
            cols = new HashSet<>();
        }

        return String.valueOf(k) + " " + String.valueOf(r) + " " + String.valueOf(c);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            System.out.println(String.format("Case #%d: %s", ks, solve(input)));
        }
    }
}