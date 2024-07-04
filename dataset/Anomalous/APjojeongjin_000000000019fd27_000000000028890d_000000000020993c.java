import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int test = 1; test <= T; test++) {
            int num = scanner.nextInt();
            int[][] matrix = new int[num][num];

            int diagonalSum = 0;
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = 0;
            int columnDuplicates = 0;

            for (int i = 0; i < num; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }

                int[] column = new int[num];
                for (int j = 0; j < num; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicates(column)) {
                    columnDuplicates++;
                }
            }

            System.out.println("Case #" + test + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}