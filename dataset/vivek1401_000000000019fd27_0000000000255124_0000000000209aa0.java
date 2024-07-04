import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        ans = new StringBuilder();

        int t = scn.nextInt();
        for (int case_num = 1; case_num <= t; case_num++) {
            done = false;
            ans.append("Case #").append(case_num).append(": ");

            int n = scn.nextInt();
            k = scn.nextInt();

            int[][] array = new int[n][n];
            for_rows = new HashSet[n];
            for_cols = new HashSet[n];
            for (int i = 0; i < n; i++) {
                for_rows[i] = new HashSet<>();
                for_cols[i] = new HashSet<>();
            }
            fun(array, 0, 0);

            if (!done) {
                ans.append("IMPOSSIBLE");
            }

            ans.append("\n");

        }

        System.out.println(ans);

    }

    static StringBuilder ans;

    static int k;

    static HashSet<Integer>[] for_rows;
    static HashSet<Integer>[] for_cols;

    private static void fun(int[][] array, int r, int c) {

        if (c == array.length) {
            fun(array, r + 1, 0);
            return;
        }
        if (r == array.length) {
            check(array);
            return;
        }

        for (int i = 1; i <= array.length; i++) {
            if (!(for_rows[r].contains(i) || for_cols[c].contains(i))) {
                array[r][c] = i;
                for_rows[r].add(i);
                for_cols[c].add(i);
                fun(array, r, c + 1);
                for_rows[r].remove(i);
                for_cols[c].remove(i);
                if (done) {
                    return;
                }
            }
        }

    }

    static boolean done = false;

    private static void check(int[][] array) {

        if (rowsOK(array) && colsOK(array) && diagOK(array)) {


            print(array);
            done = true;
        }

    }

    private static void print(int[][] array) {

        ans.append("POSSIBLE\n");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                ans.append(array[i][j]).append(" ");
            }
            if (i < array.length - 1) {
                ans.append("\n");
            }
        }

    }

    private static boolean rowsOK(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < array.length; j++) {
                if (set.contains(array[i][j])) {
                    return false;
                } else {
                    set.add(array[i][j]);
                }
            }
        }
        return true;
    }

    private static boolean colsOK(int[][] array) {
        for (int j = 0; j < array.length; j++) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < array.length; i++) {
                if (set.contains(array[i][j])) {
                    return false;
                } else {
                    set.add(array[i][j]);
                }
            }
        }
        return true;
    }

    private static boolean diagOK(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }

        return sum == k;
    }

}