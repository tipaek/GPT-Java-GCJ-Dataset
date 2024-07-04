import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int trace = 0, repeatedRows = 0, repeatedCols = 0;

            List<List<Integer>> matrix = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                matrix.add(Arrays.stream(reader.readLine().split(" "))
                                 .map(Integer::parseInt)
                                 .collect(Collectors.toList()));
            }

            for (int i = 0; i < n; i++) {
                trace += matrix.get(i).get(i);
            }

            for (int i = 0; i < n; i++) {
                if (hasRepeatedElements(matrix.get(i))) {
                    repeatedRows++;
                }
            }

            for (int i = 0; i < n; i++) {
                if (hasRepeatedElements(getColumn(matrix, i))) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static boolean hasRepeatedElements(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() < list.size();
    }

    private static List<Integer> getColumn(List<List<Integer>> matrix, int colIndex) {
        return matrix.stream()
                     .map(row -> row.get(colIndex))
                     .collect(Collectors.toList());
    }
}