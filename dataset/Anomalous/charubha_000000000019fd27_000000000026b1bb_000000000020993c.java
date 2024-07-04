package test;

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
                int cntr = 0;
                int cntc = 0;
                int[] compr = new int[size];
                int[] compc = new int[size];

                for (int z = 0; z < size; z++) {
                    compr[z] = z + 1;
                    compc[z] = z + 1;
                }

                for (int l = 0; l < size; l++) {
                    if (m == l) {
                        sump += matrix[m][l];
                    }

                    for (int g = 0; g < size; g++) {
                        if (matrix[m][l] == compr[g]) {
                            compr[g] = 0;
                            cntr++;
                        }
                        if (matrix[l][m] == compc[g]) {
                            compc[g] = 0;
                            cntc++;
                        }
                    }
                }

                if (cntc != size) {
                    colsum++;
                }
                if (cntr != size) {
                    rowsum++;
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
    }
}