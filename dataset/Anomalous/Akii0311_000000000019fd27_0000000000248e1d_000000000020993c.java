import java.util.Scanner;

class Codejam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int c = 1; c <= t; c++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = countDuplicates(matrix, n, true);
            int colDuplicates = countDuplicates(matrix, n, false);

            System.out.println("Case #" + c + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    public static int countDuplicates(int[][] matrix, int n, boolean isRow) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                if (seen[value]) {
                    count++;
                    break;
                }
                seen[value] = true;
            }
        }
        return count;
    }
}