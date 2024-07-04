import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class FirstQuestion {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCaseCount; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] rowInput = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(rowInput[j]);
                }
            }

            int rowCount = 0;
            int colCount = 0;
            long diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colHasDuplicate = true;
                    }
                }

                if (rowHasDuplicate) {
                    rowCount++;
                }
                if (colHasDuplicate) {
                    colCount++;
                }
            }

            bw.write("Case #" + (t + 1) + ": " + diagonalSum + " " + rowCount + " " + colCount + "\n");
        }

        bw.flush();
    }
}