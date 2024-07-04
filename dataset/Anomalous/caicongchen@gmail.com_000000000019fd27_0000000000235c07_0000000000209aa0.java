import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            if (m % n != 0) {
                results.add("Case #" + i + ": IMPOSSIBLE");
            } else {
                results.add("Case #" + i + ": POSSIBLE");
                results.add(createMatrix(n, m));
            }
        }

        results.forEach(System.out::println);
    }

    private static String createMatrix(int n, int m) {
        StringBuilder matrixBuilder = new StringBuilder();
        List<Integer> range = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        Collections.rotate(range, n - m / n + 1);

        appendRow(matrixBuilder, range);
        for (int i = 1; i < n; i++) {
            matrixBuilder.append(System.lineSeparator());
            Collections.rotate(range, 1);
            appendRow(matrixBuilder, range);
        }

        return matrixBuilder.toString();
    }

    private static void appendRow(StringBuilder builder, List<Integer> row) {
        row.forEach(num -> builder.append(num).append(" "));
    }
}