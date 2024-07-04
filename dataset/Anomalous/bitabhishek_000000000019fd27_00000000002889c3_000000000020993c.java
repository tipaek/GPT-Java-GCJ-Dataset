import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int trace = 0;
            int matrixSize = scanner.nextInt();

            ArrayList<TreeSet<Integer>> rows = new ArrayList<>();
            ArrayList<TreeSet<Integer>> columns = new ArrayList<>();

            for (int i = 0; i < matrixSize; i++) {
                rows.add(new TreeSet<>());
                columns.add(new TreeSet<>());
            }

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    rows.get(i).add(value);
                    columns.get(j).add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
            }

            int rowCount = countIncompleteSets(rows, matrixSize);
            int columnCount = countIncompleteSets(columns, matrixSize);

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowCount, columnCount);
            caseNumber++;
        }
    }

    private static int countIncompleteSets(ArrayList<TreeSet<Integer>> sets, int expectedSize) {
        int count = 0;
        for (TreeSet<Integer> set : sets) {
            if (set.size() != expectedSize) {
                count++;
            }
        }
        return count;
    }
}