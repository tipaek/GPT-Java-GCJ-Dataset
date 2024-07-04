import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine();

            List<List<Integer>> matrix = new ArrayList<>();
            for (int i = 0; i < matrixSize; i++) {
                String row = scanner.nextLine();
                matrix.add(parseRowToList(row, matrixSize));
            }

            processTestCase(t, matrixSize, matrix);
        }
    }

    private static void processTestCase(int testCaseNumber, int size, List<List<Integer>> matrix) {
        int trace = 0, duplicateRows = 0, duplicateColumns = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix.get(i).get(i);
        }

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix.get(i))) {
                duplicateRows++;
            }
        }

        for (int i = 0; i < size; i++) {
            List<Integer> column = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                column.add(matrix.get(j).get(i));
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }

        System.out.println("Case #" + (testCaseNumber + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    private static boolean hasDuplicates(List<Integer> list) {
        Set<Integer> uniqueElements = new HashSet<>(list);
        return uniqueElements.size() < list.size();
    }

    private static List<Integer> parseRowToList(String row, int size) {
        String[] elements = row.split(" ", size);
        return Arrays.stream(elements).map(Integer::parseInt).collect(Collectors.toList());
    }
}