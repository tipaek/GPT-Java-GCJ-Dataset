import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int x = 1; x <= T; x++) {
                int N = Integer.parseInt(br.readLine());
                int[][] grid = new int[N][N];

                for (int i = 0; i < N; i++) {
                    String[] strarr = br.readLine().trim().split("\\s+");
                    for (int j = 0; j < strarr.length; j++) {
                        grid[i][j] = Integer.parseInt(strarr[j]);
                    }
                }

                System.out.println("Case #" + x + ": " + calculateSum(grid) + " " + countDuplicateRows(grid) + " " + countDuplicateColumns(grid));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean hasDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static int countDuplicateRows(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            if (hasDuplicate(row)) {
                count++;
            }
        }
        return count;
    }

    private static int countDuplicateColumns(int[][] grid) {
        int count = 0;
        int n = grid.length;
        for (int col = 0; col < n; col++) {
            Set<Integer> set = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (!set.add(grid[row][col])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int calculateSum(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            sum += grid[i][i];
        }
        return sum;
    }
}