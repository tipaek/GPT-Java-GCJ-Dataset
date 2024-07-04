import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(reader.readLine());
        String[] output = new String[t];

        for (int i=1; i<=t; i++) {
            int dim = Integer.parseInt(reader.readLine());
            String[][] matrix = parseToArray(dim);

            int trace = getTrace(matrix);
            int r = getInvalidRows(matrix);
            int c = getInvalidRows(rotate(matrix));

            output[i-1] = "Case #" + i + ": " + trace + " " + r + " " + c;
        }

        for (int i=0; i<output.length; i++) {
            System.out.println(output[i]);
        }
    }

    public static String[][] parseToArray(int dim) throws IOException {
        String[][] array = new String[dim][dim];

        for (int i=0; i<dim; i++) {
            array[i] = stringIntoArray(reader.readLine());
        }

        return array;
    }

    private static String[] stringIntoArray(String line) {
        return line.split(" ");
    }

    private static int getTrace(String[][] matrix) {
        int trace = 0;

        for (int i=0; i<matrix.length; i++) {
            trace += Integer.valueOf(matrix[i][i]);
        }

        return trace;
    }

    private static int getInvalidRows(String[][] matrix) {
        int invalidRows = 0;

        for (int i=0; i<matrix.length; i++) {
            Set<String> targetSet = new HashSet<>(Arrays.asList(matrix[i]));
            if (!(matrix[i].length == targetSet.size())) {
                invalidRows += 1;
            }
        }

        return invalidRows;
    }

    private static String[][] rotate(String[][] matrix) {

        int N = matrix.length;

        for (int x = 0; x < N/2; x++) {
            for (int y = x; y < N - x - 1; y++) {
                String temp = matrix[x][y];
                matrix[x][y] = matrix[y][N - 1 - x];
                matrix[y][N - 1 - x] = matrix[N - 1 - x][N - 1 - y];
                matrix[N - 1 - x][N - 1 - y] = matrix[N - 1 - y][x];
                matrix[N - 1 - y][x] = temp;
            }
        }

        return matrix;
    }
}