import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int m = 1; m <= t; m++) {
            int n = Integer.parseInt(br.readLine());
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + m + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        br.close();
    }
}