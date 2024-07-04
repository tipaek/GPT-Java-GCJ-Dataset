import java.util.*;

public class Vestigium {
    Scanner scanner = new Scanner(System.in);

    private void square() {
        int test = scanner.nextInt();
        for (int z = 0; z < test; z++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            boolean[] mask = new boolean[n];
            boolean[] maskk = new boolean[n];
            for (int i = 0; i < n; i++) {
                mask[i] = false;
                maskk[i] = false;
            }
            int rows = 0;
            int columns = 0;
            boolean row;
            boolean column;
            for (int i = 0; i < n; i++) {
                row = false;
                column = false;
                for (int j = 0; j < n; j++) {
                    if (!mask[matrix[i][j] - 1]) {
                        mask[matrix[i][j] - 1] = true;
                    } else if (!row) {
                        rows++;
                        row = true;
                    }
                    if (!maskk[matrix[j][i] - 1]) {
                        maskk[matrix[j][i] - 1] = true;
                    } else if (!column) {
                        columns++;
                        column = true;
                    }
                }
                for (int j = 0; j < n; j++) {
                    mask[j] = false;
                    maskk[j] = false;
                }
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[i][i];
            }
            int number = z + 1;
            System.out.println("Case #" + number + ": " + sum + " " + rows + " " + columns);
        }
    }

    public static void main(String[] args) {
        Vestigium latin = new Vestigium();
        latin.square();
    }
}
