import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        List<List<Integer>> results = new ArrayList<>();

        for (int caseNum = 0; caseNum < T; caseNum++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            // Read the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagSum = 0;
            int rowDups = 0;
            int colDups = 0;

            // Calculate diagonal sum
            for (int i = 0; i < N; i++) {
                diagSum += matrix[i][i];
            }

            // Check for row duplicates
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDups++;
                        break;
                    }
                }
            }

            // Check for column duplicates
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colDups++;
                        break;
                    }
                }
            }

            results.add(Arrays.asList(diagSum, rowDups, colDups));
        }

        // Print results
        for (int i = 0; i < results.size(); i++) {
            List<Integer> result = results.get(i);
            System.out.println("Case #" + (i + 1) + ": " + result.get(0) + " " + result.get(1) + " " + result.get(2));
        }
    }
}