import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Indicium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int n = input.get(0);
            int k = input.get(1);
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

            int trace = IntStream.range(0, n).map(r -> matrix.get(r).get(r)).sum();

            if (trace == k) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                matrix.forEach(row -> System.out.println(row.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))));
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}