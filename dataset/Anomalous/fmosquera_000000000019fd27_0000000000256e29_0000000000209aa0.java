import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private static final String POSSIBLE = "POSSIBLE";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            List<Integer> inputs = parseInput(scanner.nextLine());
            int n = inputs.get(0);
            int k = inputs.get(1);

            if (isValidRange(n)) {
                List<List<Integer>> matrix = generateMatrix(n, k);
                if (matrix != null && isValidMatrix(matrix, n, k)) {
                    printResult(caseNumber, POSSIBLE, matrix);
                } else {
                    printResult(caseNumber, IMPOSSIBLE, null);
                }
            } else {
                printResult(caseNumber, IMPOSSIBLE, null);
            }
        }
    }

    private static List<Integer> parseInput(String input) {
        return List.of(input.split(" "))
                   .stream()
                   .map(Integer::parseInt)
                   .collect(Collectors.toList());
    }

    private static boolean isValidRange(int n) {
        return n >= 2 && n <= 50;
    }

    private static List<List<Integer>> generateMatrix(int n, int k) {
        int center = k / n;
        List<List<Integer>> matrix = new ArrayList<>(n);

        for (int j = 0; j < n; j++) {
            List<Integer> row = new ArrayList<>(n);
            for (int m = 0; m < n; m++) {
                int value = ((n - j + m) % n) + center;
                if (value > n) value -= n;
                row.add(value);
            }
            if (row.stream().distinct().count() != n) return null;
            matrix.add(row);
        }
        return matrix;
    }

    private static boolean isValidMatrix(List<List<Integer>> matrix, int n, int k) {
        for (int colIndex = 0; colIndex < n; colIndex++) {
            List<Integer> column = matrix.stream()
                                         .map(row -> row.get(colIndex))
                                         .collect(Collectors.toList());
            if (column.stream().distinct().count() != n) return false;
        }
        int trace = IntStream.range(0, n)
                             .map(i -> matrix.get(i).get(i))
                             .sum();
        return trace == k;
    }

    private static void printResult(int caseNumber, String result, List<List<Integer>> matrix) {
        System.out.println("Case #" + caseNumber + ": " + result);
        if (matrix != null) {
            matrix.forEach(row -> 
                System.out.println(row.stream()
                                      .map(String::valueOf)
                                      .collect(Collectors.joining(" ")))
            );
        }
    }
}