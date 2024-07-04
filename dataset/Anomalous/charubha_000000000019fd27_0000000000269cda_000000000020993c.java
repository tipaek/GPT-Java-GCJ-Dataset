import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        int[][] output = new int[tc][3];

        for (int i = 0; i < tc; i++) {
            int size = Integer.parseInt(sc.nextLine());
            int[][] matrix = new int[size][size];
            int compsum = (size * (size + 1)) / 2;

            for (int d = 0; d < size; d++) {
                String[] result = sc.nextLine().split(" ");
                for (int f = 0; f < size; f++) {
                    matrix[d][f] = Integer.parseInt(result[f]);
                }
            }

            int sump = 0;
            int rowsum = 0;
            int colsum = 0;

            for (int m = 0; m < size; m++) {
                int[] rowCheck = new int[size + 1];
                int[] colCheck = new int[size + 1];
                boolean rowValid = true;
                boolean colValid = true;

                for (int l = 0; l < size; l++) {
                    if (m == l) {
                        sump += matrix[m][l];
                    }

                    rowCheck[matrix[m][l]]++;
                    colCheck[matrix[l][m]]++;

                    if (rowCheck[matrix[m][l]] > 1) {
                        rowValid = false;
                    }
                    if (colCheck[matrix[l][m]] > 1) {
                        colValid = false;
                    }
                }

                if (!rowValid) {
                    rowsum++;
                }
                if (!colValid) {
                    colsum++;
                }
            }

            output[i][0] = sump;
            output[i][1] = rowsum;
            output[i][2] = colsum;
        }

        for (int h = 0; h < tc; h++) {
            System.out.print("Case #" + (h + 1) + ": ");
            for (int a = 0; a < 3; a++) {
                System.out.print(output[h][a] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}