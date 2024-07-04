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
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCases; i++) {
            List<Integer> inputNumbers = Arrays.stream(scanner.nextLine().split(" "))
                                                .map(Integer::parseInt)
                                                .collect(Collectors.toList());

            int n = inputNumbers.get(0);
            int k = inputNumbers.get(1); // trace value
            int centerValue = k / n;

            List<List<Integer>> matrix = new ArrayList<>(n);
            for (int row = 0; row < n; row++) {
                List<Integer> rowData = new ArrayList<>(n);
                for (int col = 0; col < n; col++) {
                    int value = ((n - row + col) % n) + centerValue;
                    if (value > n) {
                        value -= n;
                    }
                    rowData.add(value);
                }
                matrix.add(rowData);
            }

            int calculatedTrace = IntStream.range(0, n).map(index -> matrix.get(index).get(index)).sum();
            if (calculatedTrace == k) {
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