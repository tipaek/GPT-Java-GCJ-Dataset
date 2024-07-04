import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            List<List<Integer>> matrix = new ArrayList<>(matrixSize);

            int repeatedRows = 0;
            int repeatedCols = 0;

            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                List<Integer> row = Arrays.stream(scanner.nextLine().split(" "))
                                          .map(Integer::parseInt)
                                          .collect(Collectors.toList());
                if (row.stream().distinct().count() != matrixSize) {
                    repeatedRows++;
                }
                matrix.add(row);
            }

            int trace = IntStream.range(0, matrixSize)
                                 .map(index -> matrix.get(index).get(index))
                                 .sum();

            for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                Set<Integer> columnSet = new HashSet<>();
                for (List<Integer> row : matrix) {
                    columnSet.add(row.get(colIndex));
                }
                if (columnSet.size() != matrixSize) {
                    repeatedCols++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, repeatedRows, repeatedCols);
        }
    }
}