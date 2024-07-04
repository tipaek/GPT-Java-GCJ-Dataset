import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LatinSquares {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("input_file.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter("output_file.txt"))) {

            int testCases = Integer.parseInt(reader.readLine());

            for (int testCase = 1; testCase <= testCases; testCase++) {
                int size = Integer.parseInt(reader.readLine());
                int[][] matrix = new int[size][size];

                for (int i = 0; i < size; i++) {
                    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                    }
                }

                int trace = 0, repeatedRows = 0, repeatedColumns = 0;

                for (int i = 0; i < size; i++) {
                    if (hasDuplicates(matrix[i])) {
                        repeatedRows++;
                    }

                    int[] column = new int[size];
                    for (int j = 0; j < size; j++) {
                        column[j] = matrix[j][i];
                    }
                    if (hasDuplicates(column)) {
                        repeatedColumns++;
                    }
                }

                for (int i = 0; i < size; i++) {
                    trace += matrix[i][i];
                }

                String result = String.format("Case #%d: %d %d %d", testCase, trace, repeatedRows, repeatedColumns);
                System.out.println(result);
                writer.println(result);
            }
        }
    }

    private static boolean hasDuplicates(int[] array) {
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