import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class First {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                int size = scanner.nextInt();
                int[][] matrix = new int[size][size];
                int trace = 0;
                int rowRepeats = 0;
                int colRepeats = 0;

                // Reading the matrix and calculating trace and row repeats
                for (int row = 0; row < size; row++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int col = 0; col < size; col++) {
                        int value = scanner.nextInt();
                        matrix[row][col] = value;
                        rowSet.add(value);
                    }
                    if (rowSet.size() < size) {
                        rowRepeats++;
                    }
                    trace += matrix[row][row];
                }

                // Calculating column repeats
                for (int col = 0; col < size; col++) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int row = 0; row < size; row++) {
                        colSet.add(matrix[row][col]);
                    }
                    if (colSet.size() < size) {
                        colRepeats++;
                    }
                }

                System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
            }
        }
    }
}