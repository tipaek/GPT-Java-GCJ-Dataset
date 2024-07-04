import java.util.Scanner;

public class Easy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();
        int diagonalSum = 0;
        int rowDuplicates = 0;
        int columnDuplicates = 0;
        int[][] array = new int[N][N];

        // Read the matrix and calculate the diagonal sum
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = sc.nextInt();
                if (i == j) {
                    diagonalSum += array[i][j];
                }
            }
        }

        // Check for duplicates in rows and columns
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && array[i][j] == array[i][j + 1]) {
                    rowDuplicates++;
                }
                if (i + 1 < N && array[i][j] == array[i + 1][j]) {
                    columnDuplicates++;
                }
            }
        }

        System.out.print(diagonalSum);
        System.out.print(rowDuplicates);
        System.out.print(columnDuplicates);
    }
}