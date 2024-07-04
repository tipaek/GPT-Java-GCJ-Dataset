
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(reader.readLine());
            List<List<Integer>> matrix = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                matrix.add(Arrays.stream(reader.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).boxed().collect(Collectors.toList()));
            }
            int trace = 0, rows = 0, cols = 0;
            Set<Integer> rowSet = new HashSet<>(), colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        trace += matrix.get(i).get(i);
                    colSet.add(matrix.get(j).get(i));
                }
                if (colSet.size() != n) ++cols;
                colSet.clear();
                rowSet.addAll(matrix.get(i));
                if (rowSet.size() != n) ++rows;
                rowSet.clear();
            }

            System.out.printf("Case #%d: %d %d %d\n", t, trace, rows, cols);

        }


    }

}