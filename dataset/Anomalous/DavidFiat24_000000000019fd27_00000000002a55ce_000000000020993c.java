import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int cases = Integer.parseInt(reader.nextLine());

        for (int i = 0; i < cases; i++) {
            int size = Integer.parseInt(reader.nextLine());
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                String[] inputLine = reader.nextLine().split(" ");
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = Integer.parseInt(inputLine[col]);
                }
            }

            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            for (int j = 0; j < size; j++) {
                trace += matrix[j][j];

                if (hasRepeatedElements(matrix[j])) {
                    repeatedRows++;
                }

                int[] columnElements = new int[size];
                for (int k = 0; k < size; k++) {
                    columnElements[k] = matrix[k][j];
                }
                if (hasRepeatedElements(columnElements)) {
                    repeatedColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, repeatedRows, repeatedColumns);
        }
    }

    private static boolean hasRepeatedElements(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}