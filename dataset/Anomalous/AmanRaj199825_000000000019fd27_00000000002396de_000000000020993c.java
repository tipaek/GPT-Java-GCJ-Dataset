import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            int caseNumber = 1;

            while (T-- > 0) {
                int N = Integer.parseInt(br.readLine());
                int[][] grid = new int[N][N];

                for (int i = 0; i < N; i++) {
                    String[] strArr = br.readLine().trim().split("\\s+");
                    for (int j = 0; j < N; j++) {
                        grid[i][j] = Integer.parseInt(strArr[j]);
                    }
                }

                System.out.println("Case #" + caseNumber + ": " + calculateSum(grid) + " " + countDuplicateRows(grid) + " " + countDuplicateColumns(grid));
                caseNumber++;
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
        int duplicateCount = 0;
        for (int[] row : grid) {
            if (hasDuplicate(row)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countDuplicateColumns(int[][] grid) {
        int duplicateCount = 0;
        int n = grid.length;

        for (int col = 0; col < n; col++) {
            Set<Integer> set = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (!set.add(grid[row][col])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }

    private static int calculateSum(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            sum += grid[i][i];
        }
        return sum;
    }
}