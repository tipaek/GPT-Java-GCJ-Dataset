import java.util.HashSet;
import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int di = scanner.nextInt();
            int[][] grid = new int[di][di];
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int row = 0; row < di; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateInRow = false;

                for (int col = 0; col < di; col++) {
                    int num = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += num;
                    }
                    if (!rowSet.add(num)) {
                        hasDuplicateInRow = true;
                    }
                    grid[row][col] = num;
                }

                if (hasDuplicateInRow) {
                    duplicateRows++;
                }
            }

            for (int col = 0; col < di; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean hasDuplicateInColumn = false;

                for (int row = 0; row < di; row++) {
                    if (!colSet.add(grid[row][col])) {
                        hasDuplicateInColumn = true;
                        break;
                    }
                }

                if (hasDuplicateInColumn) {
                    duplicateColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", i + 1, diagonalSum, duplicateRows, duplicateColumns);
        }

        scanner.close();
    }
}