import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Indicium {

    public static void main(String[] args) {
        final String POSSIBLE = "POSSIBLE";
        final String IMPOSSIBLE = "IMPOSSIBLE";

        InputStream inputStream = Indicium.class.getClassLoader().getResourceAsStream("Indicium_input_file.txt");
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            int center = k / n;
            List<List<Integer>> matrix = generateMatrix(n, center);

            int trace = calculateTrace(matrix, n);
            if (trace == k) {
                printResult(i, POSSIBLE, matrix);
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
                int val = ((n - j + m) % n) + center;
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
        return IntStream.range(0, n).map(r -> matrix.get(r).get(r)).sum();
    }

    private static void printResult(int caseNumber, String result, List<List<Integer>> matrix) {
        System.out.println("Case #" + caseNumber + ": " + result);
        matrix.forEach(row -> System.out.println(
                row.stream().map(Object::toString).collect(Collectors.joining(" "))));
    }
}