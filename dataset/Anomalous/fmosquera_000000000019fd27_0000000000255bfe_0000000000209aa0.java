import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        final String POSSIBLE = "POSSIBLE";
        final String IMPOSSIBLE = "IMPOSSIBLE";
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int t = 1; t <= testCases; t++) {
            List<Integer> inputNumbers = Arrays.stream(scanner.nextLine().split(" "))
                                               .map(Integer::parseInt)
                                               .collect(Collectors.toList());

            int n = inputNumbers.get(0);
            int k = inputNumbers.get(1);

            if (n < 2 || n > 50) {
                System.out.println("Case #" + t + ": " + IMPOSSIBLE);
                continue;
            }

            int center = k / n;
            List<List<Integer>> matrix = new ArrayList<>(n);
            boolean hasRepeatingRow = false;

            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>(n);
                for (int j = 0; j < n; j++) {
                    int value = ((n - i + j) % n) + center;
                    if (value > n) {
                        value -= n;
                    }
                    row.add(value);
                }
                if (row.size() != row.stream().distinct().count()) {
                    hasRepeatingRow = true;
                    break;
                }
                matrix.add(row);
            }

            if (hasRepeatingRow) {
                System.out.println("Case #" + t + ": " + IMPOSSIBLE);
                continue;
            }

            boolean hasRepeatingColumn = false;
            for (int col = 0; col < n; col++) {
                List<Integer> columnValues = new ArrayList<>();
                for (List<Integer> row : matrix) {
                    columnValues.add(row.get(col));
                }
                if (columnValues.size() != columnValues.stream().distinct().count()) {
                    hasRepeatingColumn = true;
                    break;
                }
            }

            int trace = IntStream.range(0, n).map(idx -> matrix.get(idx).get(idx)).sum();

            if (!hasRepeatingRow && !hasRepeatingColumn && trace == k) {
                System.out.println("Case #" + t + ": " + POSSIBLE);
                for (List<Integer> row : matrix) {
                    System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
                }
            } else {
                System.out.println("Case #" + t + ": " + IMPOSSIBLE);
            }
        }
    }
}