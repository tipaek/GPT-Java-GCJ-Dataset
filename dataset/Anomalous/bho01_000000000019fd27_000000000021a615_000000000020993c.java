import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            int size = in.nextInt();
            in.nextLine(); // Consume the newline character
            int[][] matrix = new int[size][size];

            for (int j = 0; j < size; j++) {
                String row = in.nextLine();
                matrix[j] = convertRowToArray(row, size);
            }

            int trace = calculateTrace(matrix);
            int rowDuplicates = countDuplicateRows(matrix);
            int colDuplicates = countDuplicateCols(matrix);

            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowDuplicates, colDuplicates);
        }
    }

    public static int calculateTrace(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int countDuplicateRows(int[][] matrix) {
        int counter = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                counter++;
            }
        }
        return counter;
    }

    public static int countDuplicateCols(int[][] matrix) {
        int counter = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            int[] columnArray = new int[size];
            for (int row = 0; row < size; row++) {
                columnArray[row] = matrix[row][col];
            }
            if (hasDuplicates(columnArray)) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    public static int[] convertRowToArray(String row, int size) {
        int[] result = new int[size];
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(row);
        int index = 0;
        while (matcher.find() && index < size) {
            result[index++] = Integer.parseInt(matcher.group());
        }
        return result;
    }
}