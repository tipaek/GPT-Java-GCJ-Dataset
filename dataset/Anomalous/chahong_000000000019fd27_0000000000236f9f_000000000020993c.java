import java.util.Scanner;

public class CodeJam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int crossSum = 0;
            int[][] matrix = new int[t][t];
            int rowDuplicates = 0, colDuplicates = 0;

            // Reading matrix and calculating crossSum
            for (int j = 0; j < t; j++) {
                for (int k = 0; k < t; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        crossSum += matrix[j][k];
                    }
                }
            }

            // Checking for duplicates in rows and columns
            for (int j = 0; j < t; j++) {
                boolean[] rowCheck = new boolean[t + 1];
                boolean[] colCheck = new boolean[t + 1];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int k = 0; k < t; k++) {
                    // Check row duplicates
                    if (rowCheck[matrix[j][k]]) {
                        if (!rowHasDuplicate) {
                            rowDuplicates++;
                            rowHasDuplicate = true;
                        }
                    } else {
                        rowCheck[matrix[j][k]] = true;
                    }

                    // Check column duplicates
                    if (colCheck[matrix[k][j]]) {
                        if (!colHasDuplicate) {
                            colDuplicates++;
                            colHasDuplicate = true;
                        }
                    } else {
                        colCheck[matrix[k][j]] = true;
                    }
                }
            }

            System.out.println(crossSum + " " + rowDuplicates + " " + colDuplicates);
        }

        sc.close();
    }
}