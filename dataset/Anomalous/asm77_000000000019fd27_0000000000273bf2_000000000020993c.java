import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Vestigium {

    static int countRepeatedRows(int[][] matrix, int n) {
        int repeatedRows = 0;
        for (int i = 0; i < n; i++) {
            int[] rowCopy = Arrays.copyOf(matrix[i], n);
            Arrays.sort(rowCopy);
            for (int j = 0; j < n - 1; j++) {
                if (rowCopy[j] == rowCopy[j + 1]) {
                    repeatedRows++;
                    break;
                }
            }
        }
        return repeatedRows;
    }

    static int countRepeatedColumns(int[][] matrix, int n) {
        int repeatedColumns = 0;
        for (int i = 0; i < n; i++) {
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = matrix[j][i];
            }
            Arrays.sort(column);
            for (int j = 0; j < n - 1; j++) {
                if (column[j] == column[j + 1]) {
                    repeatedColumns++;
                    break;
                }
            }
        }
        return repeatedColumns;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] results = new int[T][3];

        for (int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            int trace = 0;

            for (int i = 0; i < N; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            results[k][0] = trace;
            results[k][1] = countRepeatedRows(matrix, N);
            results[k][2] = countRepeatedColumns(matrix, N);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i][0] + " " + results[i][1] + " " + results[i][2]);
        }
    }
}