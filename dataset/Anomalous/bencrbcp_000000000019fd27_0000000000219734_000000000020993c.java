import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());
        for (int x = 1; x <= cases; x++) {
            int size = Integer.parseInt(br.readLine());
            int[][] square = new int[size][size];
            int trace = 0;
            int repRows = 0;
            int repCols = 0;

            for (int r = 0; r < size; r++) {
                String[] line = br.readLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int c = 0; c < size; c++) {
                    int value = Integer.parseInt(line[c]);
                    square[r][c] = value;

                    if (!rowHasDuplicate && !rowSet.add(value)) {
                        repRows++;
                        rowHasDuplicate = true;
                    }
                    if (r == c) {
                        trace += value;
                    }
                }
            }

            for (int c = 0; c < size; c++) {
                Set<Integer> colSet = new HashSet<>();
                for (int r = 0; r < size; r++) {
                    if (!colSet.add(square[r][c])) {
                        repCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + x + ": " + trace + " " + repRows + " " + repCols);
        }
    }
}