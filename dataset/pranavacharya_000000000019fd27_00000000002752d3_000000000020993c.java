import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public void findVestigium(int caseno, int[][] arr) {
        int trace = 0;
        int row = 0;
        int col = 0;
        HashSet<Integer> rowset = new HashSet<>();
        HashSet<Integer> colset = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            boolean rowvalid = true;
            boolean colvalid = true;
            for (int j = 0; j < arr.length; j++) {
                if (rowset.contains(arr[i][j])) {
                    rowvalid = false;
                } else {
                    rowset.add(arr[i][j]);
                }
                if (colset.contains(arr[j][i])) {
                    colvalid = false;
                } else {
                    colset.add(arr[j][i]);
                }
                if (i == j) {
                    trace += arr[i][j];
                }
            }
            if (!rowvalid) {
                row++;
            }
            if (!colvalid) {
                col++;
            }
            rowset.clear();
            colset.clear();
        }
        System.out.format("Case #%d: %d %d %d", caseno, trace, row, col);
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Solution v = new Solution();
        int testcases = sc.nextInt();
        for (int t = 1; t <= testcases; t++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            v.findVestigium(t, arr);
        }
    }
}