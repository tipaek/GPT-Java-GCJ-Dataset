import java.util.Scanner;

import java.util.*;
import java.io.*;
public class Solution {
    static void solution(int N, int t ) {
        List<List<Integer>> pascal = generatePascal(500);
        List<int[]> result = new ArrayList<>();
        List<int[]> path = new ArrayList<>();
        path.add(new int[]{0,0});
        helper(N-1, result, path, new boolean[N][N], pascal, new int[]{0,0});
        System.out.println("Case #" + t + ": ");
        for (int[] a : result) {
            System.out.println( (a[0] +1) + " " + (a[1]+1));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            solution(n, i);
        }
    }

    private static void helper(int N, List<int[]> result, List<int[]> path, boolean[][] set, List<List<Integer>> pascal, int[] index) {
        if (path.size() > 500) {
            return;
        }

        if (N < 0) {
            return;
        }
        if (N == 0) {
            result.addAll(new ArrayList<>(path));
            return;
        }

//        int[][] steps = {{1,0}, {-1,0}};
        int[][] steps = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {-1,-1}};
        for (int[] step : steps) {

            int x = index[0] + step[0];
            int y = index[1] + step[1];
            if (x < 0 || y < 0 || x >= pascal.size() || x < y) {
                continue;
            }
            int[] newIndex = {x,y};
            if (set[x][y] == true) {
                continue;
            }
            path.add(newIndex);
            set[x][y] = true;
            helper(N - pascal.get(x).get(y), result, path, set, pascal, newIndex);
            if (!result.isEmpty()) {
                return;
            }
            path.remove(path.size() - 1);
            set[x][y] = false;
        }
    }

    private static List<List<Integer>> generatePascal(int numRows) {
        if(numRows == 0) {
            return new ArrayList<>();
        }
        if(numRows == 1) {
            List<List<Integer>> results = new ArrayList<>();
            results.add(Arrays.asList(1));
            return results;
        }
        List<List<Integer>> results = generatePascal(numRows-1);
        List<Integer> lastRow = results.get(numRows - 2);
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);
        for(int i = 0; i < numRows - 2; i ++) {
            currentRow.add(lastRow.get(i) + lastRow.get(i+1));
        }
        currentRow.add(1);
        results.add(currentRow);
        return results;
    }
}




















