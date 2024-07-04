import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numCases; i++) {
            int size = Integer.parseInt(br.readLine());
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                String[] line = br.readLine().split(" ");
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = Integer.parseInt(line[col]);
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int j = 0; j < size; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    rowSet.add(matrix[j][k]);
                    colSet.add(matrix[k][j]);
                }

                if (rowSet.size() < size) {
                    rowDuplicates++;
                }
                if (colSet.size() < size) {
                    colDuplicates++;
                }

                trace += matrix[j][j];
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}