import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());
        for (int x = 0; x < cases; x++) {
            int size = Integer.parseInt(br.readLine());
            int[][] matrix = new int[size][size];
            int trace = 0;
            int repRows = 0;
            int repCols = 0;

            for (int r = 0; r < size; r++) {
                String[] line = br.readLine().split(" ");
                HashSet<Integer> uniqueRowElements = new HashSet<>();
                boolean rowHasDuplicates = false;

                for (int c = 0; c < size; c++) {
                    int value = Integer.parseInt(line[c]);
                    matrix[r][c] = value;

                    if (!rowHasDuplicates && !uniqueRowElements.add(value)) {
                        repRows++;
                        rowHasDuplicates = true;
                    }

                    if (r == c) {
                        trace += value;
                    }
                }
            }

            for (int c = 0; c < size; c++) {
                HashSet<Integer> uniqueColElements = new HashSet<>();
                for (int r = 0; r < size; r++) {
                    if (!uniqueColElements.add(matrix[r][c])) {
                        repCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (x + 1) + ": " + trace + " " + repRows + " " + repCols);
        }
    }
}