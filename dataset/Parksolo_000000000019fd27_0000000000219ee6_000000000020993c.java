import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Solution {

    private static String run(final int[][] matrix) {
        int n = matrix.length;
        int trace = 0, colDupCnt = 0, rowDupCnt = 0;

        int x = 0, y = 0;
        while (x < n && y < n) {
            trace += matrix[y++][x++];
        }

        for (final int[] rows : matrix) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!set.add(rows[j])) {
                    rowDupCnt++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (final int[] cols : matrix) {
                if (!set.add(cols[i])) {
                    colDupCnt++;
                    break;
                }
            }
        }
        return String.format("%s %s %s", trace, rowDupCnt, colDupCnt);
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