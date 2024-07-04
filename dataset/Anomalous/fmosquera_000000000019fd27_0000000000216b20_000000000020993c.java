import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            List<List<Integer>> matrix = new ArrayList<>(matrixSize);

            int repeatedRows = 0;
            int repeatedCols = 0;

            for (int rowNum = 0; rowNum < matrixSize; rowNum++) {
                List<Integer> row = Arrays.stream(scanner.nextLine().split(" "))
                                          .map(Integer::parseInt)
                                          .collect(Collectors.toList());
                matrix.add(row);
                if (row.stream().distinct().count() != matrixSize) {
                    repeatedRows++;
                }
            }

            int trace = IntStream.range(0, matrixSize)
                                 .map(index -> matrix.get(index).get(index))
                                 .sum();

            for (int colNum = 0; colNum < matrixSize; colNum++) {
                Set<Integer> columnValues = new HashSet<>();
                for (List<Integer> row : matrix) {
                    columnValues.add(row.get(colNum));
                }
                if (columnValues.size() != matrixSize) {
                    repeatedCols++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, repeatedRows, repeatedCols);
        }
    }
}