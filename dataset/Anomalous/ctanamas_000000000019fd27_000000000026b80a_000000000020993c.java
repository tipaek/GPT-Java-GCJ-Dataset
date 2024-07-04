import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();
        int size = sc.nextInt();

        int[][][] cases = new int[numCases][size][size];

        // Read input
        for (int c = 0; c < numCases; c++) {
            for (int d = 0; d < size; d++) {
                for (int e = 0; e < size; e++) {
                    cases[c][d][e] = sc.nextInt();
                }
            }
        }

        // Process each case
        for (int c = 0; c < numCases; c++) {
            int trace = 0;
            int rowsRep = 0;
            int colRep = 0;

            boolean[][] colExist = new boolean[size][size];

            // Check rows and trace
            for (int d = 0; d < size; d++) {
                boolean[] rowsExist = new boolean[size];
                boolean rowGood = true;

                for (int e = 0; e < size; e++) {
                    if (d == e) {
                        trace += cases[c][d][e];
                    }

                    if (rowsExist[cases[c][d][e] - 1]) {
                        rowGood = false;
                    } else {
                        rowsExist[cases[c][d][e] - 1] = true;
                    }

                    colExist[e][cases[c][d][e] - 1] = true;
                }

                if (!rowGood) {
                    rowsRep++;
                }
            }

            // Check columns
            for (int i = 0; i < size; i++) {
                boolean colGood = true;
                for (int j = 0; j < size; j++) {
                    if (!colExist[i][j]) {
                        colGood = false;
                        break;
                    }
                }
                if (!colGood) {
                    colRep++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", (c + 1), trace, rowsRep, colRep);
        }

        sc.close();
    }
}