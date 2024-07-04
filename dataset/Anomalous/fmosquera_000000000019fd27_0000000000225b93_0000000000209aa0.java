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
        for (int i = 1; i <= testCases; i++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            if (k % n == 0) {
                List<List<Integer>> matrix = generateMatrix(n, k / n);
                System.out.println("Case #" + i + ": " + POSSIBLE);
                printMatrix(matrix);
            } else {
                System.out.println("Case #" + i + ": " + IMPOSSIBLE);
            }
        }
    }

    private static List<List<Integer>> generateMatrix(int n, int center) {
        List<List<Integer>> matrix = new ArrayList<>(n);
        for (int j = 0; j < n; j++) {
            List<Integer> row = new ArrayList<>(n);
            for (int m = 0; m < n; m++) {
                int val = ((m - j + center) % n + n) % n + 1;
                row.add(val);
            }
            matrix.add(row);
        }
        return matrix;
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        matrix.stream()
              .map(row -> row.stream()
                             .map(Object::toString)
                             .collect(Collectors.joining(" ")))
              .forEach(System.out::println);
    }
}