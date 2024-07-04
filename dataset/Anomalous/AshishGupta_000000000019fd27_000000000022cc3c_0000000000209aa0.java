import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private static final String POSSIBLE = "POSSIBLE";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= t; i++) {
            List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());

            int n = input.get(0);
            int k = input.get(1);
            int center = k / n;

            List<List<Integer>> matrix = generateMatrix(n, center);

            int trace = calculateTrace(matrix, n);
            if (trace == k) {
                printResult(i, POSSIBLE, matrix);
            } else {
                printResult(i, IMPOSSIBLE, null);
            }
        }
    }

    private static List<List<Integer>> generateMatrix(int n, int center) {
        List<List<Integer>> matrix = new ArrayList<>(n);

        for (int j = 0; j < n; j++) {
            List<Integer> row = new ArrayList<>(n);
            for (int m = 0; m < n; m++) {
                int p = n - j;
                int val = ((p + m) % n) + center;
                if (val > n) {
                    val -= n;
                }
                row.add(val);
            }
            matrix.add(row);
        }

        return matrix;
    }

    private static int calculateTrace(List<List<Integer>> matrix, int n) {
        return IntStream.range(0, n)
                        .map(r -> matrix.get(r).get(r))
                        .sum();
    }

    private static void printResult(int caseNumber, String result, List<List<Integer>> matrix) {
        System.out.println("Case #" + caseNumber + ": " + result);
        if (matrix != null) {
            matrix.stream()
                  .map(row -> row.stream()
                                 .map(String::valueOf)
                                 .collect(Collectors.joining(" ")))
                  .forEach(System.out::println);
        }
    }
}