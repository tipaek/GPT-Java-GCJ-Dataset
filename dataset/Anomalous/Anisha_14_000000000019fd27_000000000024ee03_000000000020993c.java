import java.util.Scanner;
import java.io.IOException;

class Ques {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Ques obj = new Ques();

        System.out.println("Enter no. of test cases: ");
        int t = scanner.nextInt();

        while (t > 0) {
            System.out.println("Enter the size of square matrix: ");
            int n = scanner.nextInt();
            int sum = 0;
            int[][] matrix = new int[n][n];

            System.out.println("Enter the elements of the matrix: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                sum += matrix[i][i];
            }

            System.out.print(sum + " ");
            obj.fun(matrix, n);

            t--;
        }

        scanner.close();
    }

    void fun(int[][] matrix, int n) {
        int maxRowFrequency = Integer.MIN_VALUE;
        int maxColFrequency = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                int rowFrequency = 0;
                int colFrequency = 0;

                for (int k = 0; k < n; k++) {
                    if (matrix[i][k] == value) {
                        rowFrequency++;
                    }
                    if (matrix[k][j] == value) {
                        colFrequency++;
                    }
                }

                if (rowFrequency > maxRowFrequency) {
                    maxRowFrequency = rowFrequency;
                }
                if (colFrequency > maxColFrequency) {
                    maxColFrequency = colFrequency;
                }
            }
        }

        System.out.print(maxRowFrequency + " ");
        System.out.print(maxColFrequency + " ");
    }
}