import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            int duplicateRows = 0;
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < N) {
                    duplicateRows++;
                }
            }

            int duplicateColumns = 0;
            for (int i = 0; i < N; i++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    columnSet.add(matrix[j][i]);
                }
                if (columnSet.size() < N) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}