import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Vestigium {

    public static void main(String[] args) {

        InputStream inputStream = Vestigium.class.getClassLoader().getResourceAsStream("Vestigium_input_file.txt");
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<List<Integer>> matrix = new ArrayList<>();

            int repeatedRows = 0;
            int repeatedColumns = 0;
            for (int rowIndex = 0; rowIndex < n; rowIndex++) {
                List<Integer> row = Arrays.stream(scanner.nextLine().split(" "))
                                          .map(Integer::parseInt)
                                          .collect(Collectors.toList());
                if (row.size() != new HashSet<>(row).size()) {
                    repeatedRows++;
                }
                matrix.add(row);
            }

            int trace = IntStream.range(0, n)
                                 .map(i -> matrix.get(i).get(i))
                                 .sum();

            for (int colIndex = 0; colIndex < n; colIndex++) {
                List<Integer> column = new ArrayList<>();
                for (List<Integer> row : matrix) {
                    column.add(row.get(colIndex));
                }
                if (column.size() != new HashSet<>(column).size()) {
                    repeatedColumns++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}