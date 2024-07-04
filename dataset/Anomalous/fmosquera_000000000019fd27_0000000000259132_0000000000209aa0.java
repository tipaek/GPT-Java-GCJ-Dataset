import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        for (int i = 1; i <= testCases; i++) {
            List<Integer> inputs = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int n = inputs.get(0);
            int k = inputs.get(1);

            if (n >= 2 && n <= 50) {
                List<List<Integer>> matrix = generateMatrix(n);
                boolean hasRepeatedRow = hasRepeatedElements(matrix);
                boolean hasRepeatedColumn = hasRepeatedElements(transposeMatrix(matrix));
                int trace = calculateTrace(matrix);

                if (!hasRepeatedRow && !hasRepeatedColumn && trace == k) {
                    System.out.printf("Case #%d: %s%n", i, POSSIBLE);
                    printMatrix(matrix);
                } else {
                    System.out.printf("Case #%d: %s%n", i, IMPOSSIBLE);
                }
            } else {
                System.out.printf("Case #%d: %s%n", i, IMPOSSIBLE);
            }
        }
    }

    private static List<List<Integer>> generateMatrix(int n) {
        List<List<Integer>> matrix = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            List<Integer> row = new ArrayList<>(n);
            for (int j = 1; j <= n; j++) {
                int value = ((i + j) % n == 0) ? n : (i + j) % n;
                row.add(value);
            }
            matrix.add(row);
        }
        return matrix;
    }

    private static boolean hasRepeatedElements(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            if (row.size() != row.stream().distinct().count()) {
                return true;
            }
        }
        return false;
    }

    private static List<List<Integer>> transposeMatrix(List<List<Integer>> matrix) {
        int n = matrix.size();
        List<List<Integer>> transposed = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> column = new ArrayList<>(n);
            for (List<Integer> row : matrix) {
                column.add(row.get(i));
            }
            transposed.add(column);
        }
        return transposed;
    }

    private static int calculateTrace(List<List<Integer>> matrix) {
        return IntStream.range(0, matrix.size())
                .map(i -> matrix.get(i).get(i))
                .sum();
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        matrix.forEach(row -> System.out.println(
                row.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))
        ));
    }
}