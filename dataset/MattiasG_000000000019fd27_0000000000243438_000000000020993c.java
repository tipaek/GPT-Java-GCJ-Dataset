import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int tests = Integer.parseInt(in.readLine());
            for (int test = 0; test < tests; test++) {
                int rows = 0;
                int cols = 0;
                int diagonal = 0;
                int n = Integer.parseInt(in.readLine());
                List<Set<Integer>> col = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    col.add(new HashSet<>());
                }
                boolean[] colHits = new boolean[n];

                for (int i = 0; i < n; i++) {
                    boolean duplicate = false;
                    String[] line = in.readLine().split(" ");
                    Set<Integer> row = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        int x = Integer.parseInt(line[j]);
                        if (!col.get(j).add(x)) {
                            colHits[j] = true;
                        }
                        if (!row.add(x))
                            duplicate = true;
                        if (i == j)
                            diagonal += x;
                    }
                    if (duplicate)
                        rows++;
                }
                for (int i = 0; i < n; i++) {
                    if (colHits[i])
                        cols++;
                }

                System.out.printf("Case #%d: %d %d %d\n", test+1, diagonal, rows, cols);
            }
        }
    }
}