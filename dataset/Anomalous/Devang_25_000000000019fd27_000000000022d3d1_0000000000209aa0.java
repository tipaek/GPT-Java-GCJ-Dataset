import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        final String POSSIBLE = "POSSIBLE";
        final String IMPOSSIBLE = "IMPOSSIBLE";
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int baseValue = k / n;

            List<List<Integer>> matrix = new ArrayList<>(n);

            for (int row = 0; row < n; row++) {
                List<Integer> currentRow = new ArrayList<>(n);
                for (int col = 0; col < n; col++) {
                    int value = ((n - row + col) % n) + baseValue;
                    if (value > n) {
                        value -= n;
                    }
                    currentRow.add(value);
                }
                matrix.add(currentRow);
            }

            int trace = IntStream.range(0, n).map(index -> matrix.get(index).get(index)).sum();
            if (trace == k) {
                System.out.println("Case #" + caseNum + ": " + POSSIBLE);
                matrix.stream()
                      .map(row -> row.stream()
                                     .map(String::valueOf)
                                     .collect(Collectors.joining(" ")))
                      .forEach(System.out::println);
            } else {
                System.out.println("Case #" + caseNum + ": " + IMPOSSIBLE);
            }
        }
    }
}