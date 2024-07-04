import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Solution {

    private static String run(final int[][] matrix) {
        int n = matrix.length;
        int trace = 0, colDupCnt = 0, rowDupCnt = 0;

        int x = 0, y = 0;
        while (x < n && y < n) {
            trace += matrix[y++][x++];
        }

        for (final int[] row : matrix) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                map.put(row[j], map.getOrDefault(row[j], 0) + 1);
            }
            for (final Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    rowDupCnt++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (final int[] ints : matrix) {
                map.put(ints[i], map.getOrDefault(ints[i], 0) + 1);
            }
            for (final Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    colDupCnt++;
                    break;
                }
            }
        }
        return String.format("%s %s %s", trace, rowDupCnt, colDupCnt);
    }
}
