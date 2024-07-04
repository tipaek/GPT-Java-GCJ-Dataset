import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            Integer[][] matrix = new Integer[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }

            calculateMatrix(matrix, ks);
        }
    }

    private static Integer[] getColumn(Integer[][] array, int index) {
        Integer[] column = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            column[i] = array[i][index];
        }
        return column;
    }

    private static void calculateMatrix(Integer[][] matrix, int iteration) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowSet = new HashSet<>(Arrays.asList(matrix[i]));
            if (rowSet.size() < matrix[i].length) {
                duplicateRows++;
            }

            Integer[] columnArray = getColumn(matrix, i);
            Set<Integer> columnSet = new HashSet<>(Arrays.asList(columnArray));
            if (columnSet.size() < columnArray.length) {
                duplicateColumns++;
            }
        }

        System.out.println("Case #" + iteration + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }
}