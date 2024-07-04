import java.util.Scanner;

public class Easy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();
        int diagonalSum = 0;
        int rowRepeats = 0;
        int columnRepeats = 0;
        int[][] array = new int[N][N];

        // Reading the array and calculating the diagonal sum
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = sc.nextInt();
                if (i == j) {
                    diagonalSum += array[i][j];
                }
            }
        }

        // Checking for repeated elements in rows
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (array[i][j] == array[i][j + 1]) {
                    rowRepeats++;
                }
            }
        }

        // Checking for repeated elements in columns
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N - 1; i++) {
                if (array[i][j] == array[i + 1][j]) {
                    columnRepeats++;
                }
            }
        }

        System.out.print(diagonalSum);
        System.out.print(rowRepeats);
        System.out.print(columnRepeats);
    }
}