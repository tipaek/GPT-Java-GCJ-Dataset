import java.io.BufferedReader;
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
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            List<Integer> inputs = Arrays.stream(scanner.nextLine().split(" "))
                                         .map(Integer::parseInt)
                                         .collect(Collectors.toList());

            int n = inputs.get(0);
            int k = inputs.get(1); // trace

            if (n >= 2 && n <= 50) {
                int center = k / n;
                List<List<Integer>> matrix = new ArrayList<>(n);

                for (int row = 0; row < n; row++) {
                    List<Integer> currentRow = new ArrayList<>(n);
                    for (int col = 0; col < n; col++) {
                        int offset = n - row;
                        int value = ((offset + col) % n) + center;
                        if (value > n) {
                            value -= n;
                        }
                        currentRow.add(value);
                    }
                    matrix.add(currentRow);
                }

                int trace = IntStream.range(0, n).map(i -> matrix.get(i).get(i)).sum();
                if (trace == k) {
                    System.out.println("Case #" + testCase + ": " + POSSIBLE);
                    matrix.forEach(row -> System.out.println(row.stream()
                                                                .map(String::valueOf)
                                                                .collect(Collectors.joining(" "))));
                } else {
                    System.out.println("Case #" + testCase + ": " + IMPOSSIBLE);
                }
            } else {
                System.out.println("Case #" + testCase + ": " + IMPOSSIBLE);
            }
        }
    }
}