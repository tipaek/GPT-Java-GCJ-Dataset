

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> toprint = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i=0;i<cases;i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int r=0;r<n;r++) {
                for (int c=0;c<n;c++) {
                    matrix[r][c] = sc.nextInt();
                }
            }
            int trace = 0;
            for (int t=0;t<n;t++) {
                trace += matrix[t][t];
            }
            int rrow = 0;
            for (int r=0;r<n;r++) {
                Set<Integer> rowseen = new HashSet<>();
                for (int c=0;c<n;c++) {
                    if (!(rowseen.add(matrix[r][c]))) {
                        rrow++;
                        break;
                    }
                }
            }
            int rcol = 0;
            for (int r=0;r<n;r++) {
                Set<Integer> colseen = new HashSet<>();
                for (int c=0;c<n;c++) {
                    if (!(colseen.add(matrix[c][r]))) {
                        rcol++;
                        break;
                    }
                }
            }
            toprint.add("Case #" + i + ": " + trace + " " + rrow + " " + rcol);
        }
        for (String s: toprint) {
            System.out.println(s);
        }
    }
}
