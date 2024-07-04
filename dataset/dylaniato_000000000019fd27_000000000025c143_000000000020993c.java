import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Vestigium {

    private static String output = "Case #%s: %s %s %s";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            Integer[][] matrix = new Integer[size][size];

            int trace = 0;
            for (int j = 0; j < size; j++) {
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                        .toArray(matrix[j]);
                trace += matrix[j][j];
            }

            System.out.println(String.format(output, i, trace, repeatedRows(matrix), repeatedCols(matrix)));
        }
    }

    private static int repeatedRows(Integer[][] matrix) {
        int length = matrix.length;
        int repeatedRows = 0;
        for (int i = 0; i < length; i++) {
            boolean[] presentRows = new boolean[length + 1];
            for (int j = 0; j < length; j++) {
                if (presentRows[matrix[i][j]]) {
                    repeatedRows++;
                    break;
                }
                presentRows[matrix[i][j]] = true;
            }
        }
        return repeatedRows;
    }

    private static int repeatedCols(Integer[][] matrix) {
        int length = matrix.length;
        int repeatedCols = 0;
        for (int i = 0; i < length; i++) {
            boolean[] presentCols = new boolean[length + 1];
            for (int j = 0; j < length; j++) {
                if (presentCols[matrix[j][i]]) {
                    repeatedCols++;
                    break;
                }
                presentCols[matrix[j][i]] = true;
            }
        }
        return repeatedCols;
    }

}
