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
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            List<Integer> inputs = parseInput(scanner.nextLine());
            int n = inputs.get(0);
            int k = inputs.get(1);

            if (n >= 2 && n <= 50) {
                List<List<Integer>> matrix = generateMatrix(n, k);
                if (matrix != null && isValidMatrix(matrix, n, k)) {
                    printResult(caseNum, POSSIBLE, matrix);
                } else {
                    printResult(caseNum, IMPOSSIBLE, null);
                }
            } else {
                printResult(caseNum, IMPOSSIBLE, null);
            }
        }
    }

    private static List<Integer> parseInput(String input) {
        return Arrays.stream(input.split(" "))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    private static List<List<Integer>> generateMatrix(int n, int k) {
        int center = k / n;
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
            if (row.stream().distinct().count() != n) {
                return null;
            }
            matrix.add(row);
        }
        return matrix;
    }

    private static boolean isValidMatrix(List<List<Integer>> matrix, int n, int k) {
        for (int colIdx = 0; colIdx < n; colIdx++) {
            List<Integer> col = new ArrayList<>();
            for (List<Integer> row : matrix) {
                col.add(row.get(colIdx));
            }
            if (col.stream().distinct().count() != n) {
                return false;
            }
        }
        int trace = IntStream.range(0, n)
                             .map(idx -> matrix.get(idx).get(idx))
                             .sum();
        return trace == k;
    }

    private static void printResult(int caseNum, String result, List<List<Integer>> matrix) {
        System.out.println("Case #" + caseNum + ": " + result);
        if (matrix != null) {
            matrix.forEach(row -> System.out.println(row.stream()
                                                        .map(String::valueOf)
                                                        .collect(Collectors.joining(" "))));
        }
    }
}