import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= t; i++) {
            int sizeP = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[sizeP][sizeP];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            for (int r = 0; r < sizeP; r++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int c = 0; c < sizeP; c++) {
                    matrix[r][c] = Integer.parseInt(rowValues[c]);
                }
            }

            // Calculate trace
            for (int j = 0; j < sizeP; j++) {
                trace += matrix[j][j];
            }

            // Check for duplicate rows
            for (int r = 0; r < sizeP; r++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int c = 0; c < sizeP; c++) {
                    if (!rowSet.add(matrix[r][c])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate columns
            for (int c = 0; c < sizeP; c++) {
                Set<Integer> colSet = new HashSet<>();
                for (int r = 0; r < sizeP; r++) {
                    if (!colSet.add(matrix[r][c])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}