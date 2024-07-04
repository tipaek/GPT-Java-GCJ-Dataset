import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        final String POSSIBLE = "POSSIBLE";
        final String IMPOSSIBLE = "IMPOSSIBLE";
        InputStream inputStream = Solution.class.getClassLoader().getResourceAsStream("Indicium_input_file.txt");
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());

            int n = input.get(0);
            int k = input.get(1);
            int center = k / n;

            List<List<Integer>> matrix = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>(n);
                for (int j = 0; j < n; j++) {
                    int p = n - i;
                    int value = ((p + j) % n) + center;
                    if (value > n) {
                        value -= n;
                    }
                    row.add(value);
                }
                matrix.add(row);
            }

            int trace = IntStream.range(0, n).map(r -> matrix.get(r).get(r)).sum();
            if (trace == k) {
                System.out.println("Case #" + caseNumber + ": " + POSSIBLE);
                matrix.forEach(row -> System.out.println(row.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))));
            } else {
                System.out.println("Case #" + caseNumber + ": " + IMPOSSIBLE);
            }
        }
    }
}