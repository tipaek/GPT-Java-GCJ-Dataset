import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ass {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int testCaseCount = sc.nextInt();

        for (int t = 0; t < testCaseCount; t++) {
            System.out.println("Case #" + (t + 1) + ": " + processMatrix(sc));
        }
    }

    public static String processMatrix(Scanner sc) {
        final int size = sc.nextInt();
        int[][] matrix = new int[size][size];

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                matrix[y][x] = sc.nextInt();
            }
        }

        return getTrace(matrix) + " " + getRepeatingRows(matrix) + " " + getRepeatingColumns(matrix);
    }

    private static int getTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int getRepeatingRows(int[][] matrix) {
        int repeatingRows = 0;
        for (int y = 0; y < matrix.length; y++) {
            Set<Integer> occurrences = new HashSet<>();
            for (int x = 0; x < matrix[y].length; x++) {
                occurrences.add(matrix[y][x]);
            }
            if (occurrences.size() != matrix[y].length) {
                repeatingRows++;
            }
        }
        return repeatingRows;
    }

    private static int getRepeatingColumns(int[][] matrix) {
        int repeatingColumns = 0;
        for (int x = 0; x < matrix.length; x++) {
            Set<Integer> occurrences = new HashSet<>();
            for (int y = 0; y < matrix.length; y++) {
                occurrences.add(matrix[y][x]);
            }
            if (occurrences.size() != matrix.length) {
                repeatingColumns++;
            }
        }
        return repeatingColumns;
    }
}
