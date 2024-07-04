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
        for (int i = 1; i <= testCases; i++) {
            List<Integer> inputs = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int n = inputs.get(0);
            int k = inputs.get(1);
            int center = k / n;

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

            int trace = IntStream.range(0, n).map(r -> matrix.get(r).get(r)).sum();
            if (trace == k) {
                System.out.println("Case #" + i + ": " + POSSIBLE);
                matrix.forEach(row -> System.out.println(row.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))));
            } else {
                System.out.println("Case #" + i + ": " + IMPOSSIBLE);
            }
        }
    }
}