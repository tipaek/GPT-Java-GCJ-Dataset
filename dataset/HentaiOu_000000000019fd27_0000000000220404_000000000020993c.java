import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());

        int[][] printValues = new int[T][3];

        for (int i = 1; i <= T; i++) {
            int matrixWidth = Integer.parseInt(in.nextLine());

            // record string P
            int[][] matrix = new int[matrixWidth][matrixWidth];

            for (int rw = 0; rw < matrixWidth; rw++) {
                String[] inputRow = in.nextLine().trim().split(" ");
                for(int cln = 0; cln < matrixWidth; cln++) {
                    matrix[rw][cln] = Integer.parseInt(inputRow[cln]);
                }
            }

            // compare
            int trace = 0;
            for (int j = 0; j < matrixWidth; j++) {
                for (int k = 0; k < matrixWidth; k++) {
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }
            int r = 0;
            //Row COUNT
            for (int j = 0; j < matrixWidth; j++) {
                for (int k = 0; k < matrixWidth; k++) {
                    int c = 0;
                    for (int l = k + 1; l < matrixWidth; l++)
                        if (matrix[j][k] == matrix[j][l]) {
                            r++;
                            c = 1;
                            break;
                        }
                    if (c == 1)
                        break;
                }
            }
            int c = 0;
            //Row COUNT
            for (int j = 0; j < matrixWidth; j++) {
                for (int k = 0; k < matrixWidth; k++) {
                    int x = 0;
                    for (int l = k + 1; l < matrixWidth; l++)
                        if (matrix[k][j] == matrix[l][j]) {
                            c++;
                            x = 1;
                            break;
                        }
                    if (x == 1)
                        break;
                }
            }
            printValues[i-1][0] = trace;
            printValues[i-1][1] = r;
            printValues[i-1][2] = c;
        }
        for(int i = 1; i <= T; i++) {
            System.out.println("Case #" + i + ": " + printValues[i-1][0] + " " + printValues[i-1][1] + " " + printValues[i-1][2]);
        }
        in.close();
    }
}