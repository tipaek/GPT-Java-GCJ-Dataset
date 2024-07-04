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
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int n = input.get(0);
            int k = input.get(1);
            int baseValue = k / n;

            List<List<Integer>> matrix = new ArrayList<>(n);

            for (int row = 0; row < n; row++) {
                List<Integer> currentRow = new ArrayList<>(n);
                for (int col = 0; col < n; col++) {
                    int shiftedValue = ((n - row + col) % n) + baseValue;
                    if (shiftedValue > n) {
                        shiftedValue -= n;
                    }
                    currentRow.add(shiftedValue);
                }
                matrix.add(currentRow);
            }

            int trace = IntStream.range(0, n).map(index -> matrix.get(index).get(index)).sum();
            if (trace == k) {
                System.out.println("Case #" + caseNum + ": " + POSSIBLE);
                matrix.forEach(row -> System.out.println(row.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))));
            } else {
                System.out.println("Case #" + caseNum + ": " + IMPOSSIBLE);
            }
        }
    }
}