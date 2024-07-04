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

            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int size = Integer.parseInt(reader.readLine());
                int[][] matrix = new int[size][size];

                for (int i = 0; i < size; i++) {
                    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                    }
                }

                int trace = 0;
                int repeatedRows = 0;
                int repeatedColumns = 0;

                for (int i = 0; i < size; i++) {
                    boolean[] rowCheck = new boolean[size + 1];
                    boolean[] columnCheck = new boolean[size + 1];

                    for (int j = 0; j < size; j++) {
                        if (rowCheck[matrix[i][j]]) {
                            repeatedRows++;
                            break;
                        }
                        rowCheck[matrix[i][j]] = true;
                    }

                    for (int j = 0; j < size; j++) {
                        if (columnCheck[matrix[j][i]]) {
                            repeatedColumns++;
                            break;
                        }
                        columnCheck[matrix[j][i]] = true;
                    }
                }

                for (int i = 0; i < size; i++) {
                    trace += matrix[i][i];
                }

                writer.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
            }
        }
    }
}