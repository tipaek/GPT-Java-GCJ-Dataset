import java.awt.datatransfer.FlavorTable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = (new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(in.readLine()); //Int();

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(in.readLine());

            int [][] latin_matrix = new int[N][N];

            int trace = 0;
            for (int a = 0; a < N; a++) {
                String[] line = in.readLine().split(" ");
                for (int b = 0; b < line.length; b++) {
                    int number = Integer.parseInt(line[b]);
                    latin_matrix[a][b] = number;

                    trace = a == b ? (trace + number) : trace;
                }
            }

            int rowDuplicate = 0;
            int columnDuplicate = 0;

            int[][] transposedMatrix = transpose(latin_matrix);

            for (int q = 0; q < latin_matrix.length; q++) {
                Set<Integer> rowDuplicates = new HashSet<>();
                Set<Integer> columnDuplicates = new HashSet<>();
                for (int w = 0; w < latin_matrix[q].length; w++) {
                    rowDuplicates.add(latin_matrix[q][w]);
                    columnDuplicates.add(transposedMatrix[q][w]);
                }

                if (rowDuplicates.size() < latin_matrix[q].length) {
                    rowDuplicate++;
                }

                if (columnDuplicates.size() < transposedMatrix[q].length) {
                    columnDuplicate++;
                }
            }

            System.out.println("case #" + i + ": " + trace + " " + rowDuplicate + " " + columnDuplicate);
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] transposed = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }

        return transposed;
    }
}
