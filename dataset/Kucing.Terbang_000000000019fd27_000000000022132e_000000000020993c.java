import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder out = new StringBuilder();

        int t = in.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = in.nextInt();
            int[][] hs = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    hs[j][k] = in.nextInt();
                }
            }
            out.append("Case #").append(i + 1).append(": ").append(solution(hs)).append('\n');
        }

        System.out.println(out.toString());
    }

    private static String solution(int[][] matrix) {
        int k = 0, r = 0, c = 0;
        Map<Integer, Set<Integer>> colCache = new HashMap<>();
        Map<Integer, Set<Integer>> rowCache = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            boolean cp = false;
            for (int j = 0; j < matrix[i].length; j++) {
                int val = matrix[i][j];
                Set<Integer> cache = rowCache.getOrDefault(i, new HashSet<>());

                if (cache.contains(val) && !cp) {
                    r++;
                    cp = true;
                }

                if (i == j) {
                    k += val;
                }

                cache.add(val);
                rowCache.put(i, cache);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            boolean cp = false;

            for (int j = 0; j < matrix[i].length; j++) {
                int val = matrix[j][i];
                Set<Integer> cache = colCache.getOrDefault(i, new HashSet<>());

                if (cache.contains(val) && !cp) {
                    c++;
                    cp = true;
                }

                cache.add(val);
                colCache.put(i, cache);
            }
        }

        return String.format("%d %d %d", k, r, c);
    }
}
