import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());

        for (int a = 0; a < T; a++) {
            int N = Integer.parseInt(scanner.nextLine());
            String[][] matrix = new String[N][N];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read matrix and calculate trace and row duplicates
            for (int i = 0; i < N; i++) {
                matrix[i] = scanner.nextLine().split(" ");
                trace += Integer.parseInt(matrix[i][i]);
                Set<String> rowSet = new HashSet<>(Arrays.asList(matrix[i]));
                if (rowSet.size() != N) {
                    rowDuplicates++;
                }
            }

            // Calculate column duplicates
            for (int j = 0; j < N; j++) {
                Set<String> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (a + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}