import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        List<String> results = new ArrayList<>();
        
        for (int i = 1; i <= t; i++) {
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
        List<Integer> sequence = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        Collections.rotate(sequence, m / n);

        appendRow(matrixBuilder, sequence);
        for (int i = 1; i < n; i++) {
            matrixBuilder.append(System.lineSeparator());
            Collections.rotate(sequence, 1);
            appendRow(matrixBuilder, sequence);
        }

        return matrixBuilder.toString();
    }

    private static void appendRow(StringBuilder builder, List<Integer> row) {
        row.forEach(value -> builder.append(value).append(" "));
        builder.setLength(builder.length() - 1); // Remove the trailing space
    }
}