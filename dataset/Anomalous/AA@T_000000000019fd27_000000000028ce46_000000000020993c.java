import java.io.*;
import java.util.*;

public class Vestigium {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            int N = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Calculate trace
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate rows
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate columns
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            result.append("Case #").append(t + 1).append(": ").append(trace).append(" ").append(duplicateRows).append(" ").append(duplicateColumns).append("\n");
        }

        System.out.print(result);
    }
}