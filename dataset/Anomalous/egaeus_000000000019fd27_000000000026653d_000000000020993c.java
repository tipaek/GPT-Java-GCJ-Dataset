import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int diagonalSum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < size; i++) {
                boolean[] rowCheck = new boolean[size];
                boolean[] colCheck = new boolean[size];

                for (int j = 0; j < size; j++) {
                    rowCheck[matrix[i][j] - 1] = !rowCheck[matrix[i][j] - 1];
                    colCheck[matrix[j][i] - 1] = !colCheck[matrix[j][i] - 1];

                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }

                if (containsDuplicate(rowCheck)) {
                    rowDuplicates++;
                }

                if (containsDuplicate(colCheck)) {
                    colDuplicates++;
                }
            }

            result.append("Case #").append(testCase).append(": ")
                  .append(diagonalSum).append(" ")
                  .append(rowDuplicates).append(" ")
                  .append(colDuplicates).append("\n");
        }

        System.out.print(result.toString());
    }

    private static boolean containsDuplicate(boolean[] checkArray) {
        for (boolean checked : checkArray) {
            if (!checked) {
                return true;
            }
        }
        return false;
    }
}