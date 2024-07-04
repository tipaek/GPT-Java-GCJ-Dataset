import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] trace = new int[t];

        for (int i = 0; i < t; i++) {
            int dimension = sc.nextInt();
            int[][] matrix = new int[dimension][dimension];
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int row = 0; row < dimension; row++) {
                int[] rowCheck = new int[dimension];
                boolean rowHasDuplicate = false;

                for (int col = 0; col < dimension; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace[i] += matrix[row][col];
                    }
                    if (rowCheck[matrix[row][col] - 1] == 1) {
                        rowHasDuplicate = true;
                    } else {
                        rowCheck[matrix[row][col] - 1] = 1;
                    }
                }

                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }

            for (int col = 0; col < dimension; col++) {
                int[] colCheck = new int[dimension];
                boolean colHasDuplicate = false;

                for (int row = 0; row < dimension; row++) {
                    if (colCheck[matrix[row][col] - 1] == 1) {
                        colHasDuplicate = true;
                    } else {
                        colCheck[matrix[row][col] - 1] = 1;
                    }
                }

                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println(trace[i] + " " + rowDuplicates + " " + colDuplicates);
        }

        sc.close();
    }
}