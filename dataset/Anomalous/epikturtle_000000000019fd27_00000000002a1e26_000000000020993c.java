import java.util.*;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= cases; i++) {
            int side = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[side][side];
            for (int j = 0; j < side; j++) {
                String[] row = scanner.nextLine().split(" ");
                for (int k = 0; k < side; k++) {
                    matrix[j][k] = Integer.parseInt(row[k]);
                }
            }

            int trace = 0;
            for (int j = 0; j < side; j++) {
                trace += matrix[j][j];
            }

            int rowsWithDuplicates = 0;
            for (int[] row : matrix) {
                if (hasDuplicates(row)) {
                    rowsWithDuplicates++;
                }
            }

            int colsWithDuplicates = 0;
            for (int j = 0; j < side; j++) {
                int[] col = new int[side];
                for (int k = 0; k < side; k++) {
                    col[k] = matrix[k][j];
                }
                if (hasDuplicates(col)) {
                    colsWithDuplicates++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowsWithDuplicates + " " + colsWithDuplicates);
        }
        scanner.close();
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}