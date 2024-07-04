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
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (m % n != 0) {
                results.add("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                results.add("Case #" + caseNum + ": POSSIBLE");
                results.add(createMatrix(n, m));
            }
        }

        results.forEach(System.out::println);
    }

    private static String createMatrix(int n, int m) {
        StringBuilder matrixBuilder = new StringBuilder();
        List<Integer> sequence = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        Collections.rotate(sequence, n - m / n + 1);

        appendRow(matrixBuilder, sequence);

        for (int i = 1; i < n; i++) {
            matrixBuilder.append(System.lineSeparator());
            Collections.rotate(sequence, 1);
            appendRow(matrixBuilder, sequence);
        }

        return matrixBuilder.toString();
    }

    private static void appendRow(StringBuilder builder, List<Integer> row) {
        row.forEach(num -> builder.append(num).append(" "));
    }
}