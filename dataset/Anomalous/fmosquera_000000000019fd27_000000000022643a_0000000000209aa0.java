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

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            List<Integer> inputs = parseInput(scanner.nextLine());
            int n = inputs.get(0);
            int k = inputs.get(1);
            int center = k / n;

            List<List<Integer>> matrix = generateMatrix(n, center);

            int trace = calculateTrace(matrix, n);
            if (trace == k) {
                System.out.println("Case #" + caseNumber + ": " + POSSIBLE);
                printMatrix(matrix);
            } else {
                System.out.println("Case #" + caseNumber + ": " + IMPOSSIBLE);
            }
        }
    }

    private static List<Integer> parseInput(String input) {
        return Arrays.stream(input.split(" "))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    private static List<List<Integer>> generateMatrix(int n, int center) {
        List<List<Integer>> matrix = new ArrayList<>(n);
        for (int rowIdx = 0; rowIdx < n; rowIdx++) {
            List<Integer> row = new ArrayList<>(n);
            for (int colIdx = 0; colIdx < n; colIdx++) {
                int value = ((n - rowIdx + colIdx) % n) + center;
                if (value > n) {
                    value -= n;
                }
                row.add(value);
            }
            matrix.add(row);
        }
        return matrix;
    }

    private static int calculateTrace(List<List<Integer>> matrix, int n) {
        return IntStream.range(0, n)
                        .map(idx -> matrix.get(idx).get(idx))
                        .sum();
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        matrix.stream()
              .map(row -> row.stream()
                             .map(Object::toString)
                             .collect(Collectors.joining(" ")))
              .forEach(System.out::println);
    }
}