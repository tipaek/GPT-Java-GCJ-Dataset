import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] trace = new int[t];
        int[] rowDuplicates = new int[t];
        int[] colDuplicates = new int[t];

        for (int i = 0; i < t; i++) {
            int dimension = sc.nextInt();
            int[][] matrix = new int[dimension][dimension];
            trace[i] = 0;
            rowDuplicates[i] = 0;
            colDuplicates[i] = 0;

            for (int j = 0; j < dimension; j++) {
                int[] rowCheck = new int[dimension];
                boolean rowHasDuplicate = false;

                for (int k = 0; k < dimension; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        trace[i] += matrix[j][k];
                    }
                    if (rowCheck[matrix[j][k] - 1] == 1) {
                        rowHasDuplicate = true;
                    } else {
                        rowCheck[matrix[j][k] - 1] = 1;
                    }
                }

                if (rowHasDuplicate) {
                    rowDuplicates[i]++;
                }
            }

            for (int j = 0; j < dimension; j++) {
                int[] colCheck = new int[dimension];
                boolean colHasDuplicate = false;

                for (int l = 0; l < dimension; l++) {
                    if (colCheck[matrix[l][j] - 1] == 1) {
                        colHasDuplicate = true;
                    } else {
                        colCheck[matrix[l][j] - 1] = 1;
                    }
                }

                if (colHasDuplicate) {
                    colDuplicates[i]++;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + trace[i] + " " + rowDuplicates[i] + " " + colDuplicates[i]);
        }
    }
}