import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vestigium {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int nCases = Integer.parseInt(br.readLine());

            for (int i = 0; i < nCases; i++) {
                int N = Integer.parseInt(br.readLine());
                int[][] matrix = new int[N][N];
                int trace = 0;
                int rowDuplicates = 0;
                int colDuplicates = 0;

                for (int r = 0; r < N; r++) {
                    String[] rowValues = br.readLine().split(" ");
                    Set<Integer> rowSet = new HashSet<>();
                    boolean rowHasDuplicate = false;

                    for (int c = 0; c < N; c++) {
                        int value = Integer.parseInt(rowValues[c]);
                        matrix[r][c] = value;
                        if (r == c) {
                            trace += value;
                        }
                        if (!rowSet.add(value) && !rowHasDuplicate) {
                            rowHasDuplicate = true;
                            rowDuplicates++;
                        }
                    }
                }

                for (int c = 0; c < N; c++) {
                    Set<Integer> colSet = new HashSet<>();
                    boolean colHasDuplicate = false;

                    for (int r = 0; r < N; r++) {
                        int value = matrix[r][c];
                        if (!colSet.add(value) && !colHasDuplicate) {
                            colHasDuplicate = true;
                            colDuplicates++;
                        }
                    }
                }

                System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowDuplicates, colDuplicates);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}