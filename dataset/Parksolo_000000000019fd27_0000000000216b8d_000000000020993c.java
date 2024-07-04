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
        int trace = 0, rowDupCnt = 0, colDupCnt = 0;

        int x = 0, y = 0;
        while (x < n && y < n) {
            trace += matrix[y][x];
            x++;
            y++;
        }

        for (final int[] row : matrix) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                map.put(row[j], map.getOrDefault(row[j], 0) + 1);
            }
            for (final Entry<Integer, Integer> entry : map.entrySet()) {
                colDupCnt = Math.max(colDupCnt, entry.getValue());
            }
        }

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (final int[] ints : matrix) {
                map.put(ints[i], map.getOrDefault(ints[i], 0) + 1);
            }
            for (final Entry<Integer, Integer> entry : map.entrySet()) {
                rowDupCnt = Math.max(rowDupCnt, entry.getValue());
            }
        }

        colDupCnt = colDupCnt == 1 ? 0 : colDupCnt;
        rowDupCnt = rowDupCnt == 1 ? 0 : rowDupCnt;
        return String.format("%s %s %s", trace, colDupCnt, rowDupCnt);
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCnt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= caseCnt; t++) {
            int size = Integer.parseInt(br.readLine());
            int[][] matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                String line = br.readLine();
                matrix[i] = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            String output = String.format("Case #%s: %s", t, run(matrix));
            System.out.println(output);
        }
    }
}
