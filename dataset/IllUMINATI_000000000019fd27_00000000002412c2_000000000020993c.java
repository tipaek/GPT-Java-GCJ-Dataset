

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

 class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(in.nextLine());
            int[][] input = new int[n][n];
            for (int j = 0; j < n; j++) {
                String[] parts = in.nextLine().split(" ");
                for (int k = 0; k < n; k++) {
                    input[j][k] = Integer.parseInt(parts[k]);
                }
            }
            String s = vestigium(input);
            System.out.printf("Case #%d: %s\n", i, s);
        }

    }

    private static String vestigium(int[][] input) {
        int n = input.length;
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += input[i][i];
        }
        int row = 0;
        int col = 0;

        Set<Integer> rowSet = new HashSet<Integer>();
        Set<Integer> colSet = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSet.add(input[i][j]);
                colSet.add(input[j][i]);
            }
            if (colSet.size() != n) {
                col++;
            }
            if (rowSet.size() != n) {
                row++;
            }
            rowSet.clear();
            colSet.clear();
        }
        return trace + " " + row + " " + col;
    }
}


