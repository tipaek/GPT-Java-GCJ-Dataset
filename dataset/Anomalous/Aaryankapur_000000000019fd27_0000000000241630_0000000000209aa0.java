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

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] inputs = scanner.nextLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            List<List<Integer>> matrix = generateMatrix(n, k);
            int trace = calculateTrace(matrix);

            if (trace == k) {
                System.out.println("Case #" + caseNumber + ": " + POSSIBLE);
                printMatrix(matrix);
            } else {
                System.out.println("Case #" + caseNumber + ": " + IMPOSSIBLE);
            }
        }
    }

    private static List<List<Integer>> generateMatrix(int n, int k) {
        int center = k / n;
        List<List<Integer>> matrix = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                int val = ((n - i + j) % n) + center;
                if (val > n) {
                    val -= n;
                }
                row.add(val);
            }
            matrix.add(row);
        }

        return matrix;
    }

    private static int calculateTrace(List<List<Integer>> matrix) {
        return IntStream.range(0, matrix.size())
                .map(i -> matrix.get(i).get(i))
                .sum();
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        matrix.stream()
                .map(row -> row.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")))
                .forEach(System.out::println);
    }
}