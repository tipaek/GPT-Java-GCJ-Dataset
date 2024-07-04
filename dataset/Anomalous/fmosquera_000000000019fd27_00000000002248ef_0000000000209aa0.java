import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        final String POSSIBLE = "POSSIBLE";
        final String IMPOSSIBLE = "IMPOSSIBLE";
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());

            int n = input.get(0);
            int k = input.get(1); // trace

            if (k % n == 0) {
                List<List<Integer>> matrix = generateMatrix(n);
                System.out.println("Case #" + caseNum + ": " + POSSIBLE);
                printMatrix(matrix);
            } else {
                System.out.println("Case #" + caseNum + ": " + IMPOSSIBLE);
            }
        }
    }

    private static List<List<Integer>> generateMatrix(int n) {
        List<List<Integer>> matrix = new ArrayList<>(n);
        for (int rowIdx = 0; rowIdx < n; rowIdx++) {
            List<Integer> row = new ArrayList<>(n);
            for (int colIdx = 0; colIdx < n; colIdx++) {
                int value = (n - rowIdx + colIdx) % n + 1;
                row.add(value);
            }
            matrix.add(row);
        }
        return matrix;
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        matrix.forEach(row -> {
            String rowString = row.stream()
                                  .map(String::valueOf)
                                  .collect(Collectors.joining(" "));
            System.out.println(rowString);
        });
    }
}