import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];

            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            for (int i = 0; i < size; i++) {
                boolean[] rowFrequency = new boolean[size + 1];
                String[] inputRow = reader.readLine().split(" ");
                boolean rowHasDuplicate = false;

                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(inputRow[j]);

                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    if (!rowHasDuplicate) {
                        if (!rowFrequency[matrix[i][j]]) {
                            rowFrequency[matrix[i][j]] = true;
                        } else {
                            rowHasDuplicate = true;
                            repeatedRows++;
                        }
                    }
                }
            }

            for (int j = 0; j < size; j++) {
                boolean[] columnFrequency = new boolean[size + 1];
                boolean columnHasDuplicate = false;

                for (int i = 0; i < size; i++) {
                    if (!columnHasDuplicate) {
                        if (!columnFrequency[matrix[i][j]]) {
                            columnFrequency[matrix[i][j]] = true;
                        } else {
                            columnHasDuplicate = true;
                            repeatedColumns++;
                        }
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}