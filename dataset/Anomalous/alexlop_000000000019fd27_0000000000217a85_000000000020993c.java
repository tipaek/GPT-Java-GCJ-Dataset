import java.util.*;
import java.io.*;

public class Solution {

    public static void latinSquare(int[][] nums, int caseNum) {
        int k = 0, r = 0, c = 0;
        Map<String, Integer> map = new HashMap<>();
        Set<String> seenRows = new HashSet<>();
        Set<String> seenCols = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int currentVal = nums[i][j];
                if (i == j) {
                    k += currentVal;
                }

                String rowKey = currentVal + " at row " + i;
                map.put(rowKey, map.getOrDefault(rowKey, 0) + 1);
                if (map.get(rowKey) == 2 && seenRows.add("duplicate in row " + i)) {
                    r++;
                }

                String colKey = currentVal + " at column " + j;
                map.put(colKey, map.getOrDefault(colKey, 0) + 1);
                if (map.get(colKey) == 2 && seenCols.add("duplicate in column " + j)) {
                    c++;
                }
            }
        }
        System.out.println("Case #" + caseNum + ": " + k + " " + r + " " + c);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] nums = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    nums[row][col] = scanner.nextInt();
                }
            }
            latinSquare(nums, i);
        }
    }
}