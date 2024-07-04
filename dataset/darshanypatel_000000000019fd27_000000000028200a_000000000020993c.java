import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(reader.readLine());
            List<List<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                matrix.add(Arrays.stream(reader.readLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
            }

            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += matrix.get(i).get(i);
            }

            int rows = 0;
            int cols = 0;
            for (int i = 0; i < N; i++) {
                if (new HashSet<>(matrix.get(i)).size() != N) {
                    rows++;
                }
            }

            for (int i = 0; i < N; i++) {
                Set<Integer> s = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    s.add(matrix.get(j).get(i));
                }
                if (s.size() != N) {
                    cols++;
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", t, trace, rows, cols));
        }
    }
}
