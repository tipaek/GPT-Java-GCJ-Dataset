import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LatinSquares {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new FileReader("input_file.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output_file.txt"));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            for (int i = 0; i < size; i++) {
                int[] rowOccurrences = new int[size + 1];
                int[] columnOccurrences = new int[size + 1];

                for (int j = 0; j < size; j++) {
                    rowOccurrences[matrix[i][j]]++;
                    columnOccurrences[matrix[j][i]]++;

                    if (rowOccurrences[matrix[i][j]] > 1) {
                        repeatedRows++;
                        break;
                    }
                    if (columnOccurrences[matrix[j][i]] > 1) {
                        repeatedColumns++;
                        break;
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            String result = String.format("Case #%d: %d %d %d", testCase, trace, repeatedRows, repeatedColumns);
            System.out.println(result);
            writer.println(result);
        }

        scanner.close();
        writer.close();
    }
}