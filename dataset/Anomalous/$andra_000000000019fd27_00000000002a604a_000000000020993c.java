import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Book {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());

            for (int n = 1; n <= testCases; n++) {
                String[] dimensions = br.readLine().split(" ");
                int rows = Integer.parseInt(dimensions[0]);
                int cols = Integer.parseInt(dimensions[1]);

                String[] columnData = new String[cols];
                int diagonalSum = 0;
                int repeatedRows = 0;
                int repeatedCols = 0;

                for (int i = 0; i < rows; i++) {
                    String[] rowData = br.readLine().split(" ");
                    String rowValues = "";

                    for (int j = 0; j < cols; j++) {
                        String cell = rowData[j];

                        // Check for repeated values in the row
                        if (!rowValues.equals("f") && rowValues.contains(cell)) {
                            repeatedRows++;
                            rowValues = "f";
                        } else if (!rowValues.equals("f") && !rowValues.contains(cell)) {
                            rowValues += cell;
                        }

                        // Check for repeated values in the column
                        if (columnData[j] != null && !columnData[j].equals("f") && columnData[j].contains(cell)) {
                            repeatedCols++;
                            columnData[j] = "f";
                        } else if (columnData[j] == null || (!columnData[j].equals("f") && !columnData[j].contains(cell))) {
                            if (columnData[j] == null) {
                                columnData[j] = "";
                            }
                            columnData[j] += cell;
                        }

                        // Check for diagonal elements
                        if (j == i) {
                            diagonalSum += Integer.parseInt(cell);
                        }
                    }
                }
                System.out.println("Case #" + n + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}