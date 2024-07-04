import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long T = input.nextLong();
        input.nextLine();
        input.nextLine();

        for (long i = 0; i < T; i++) {
            int N = input.nextInt();
            input.nextLine();

            long[][] matrix = new long[N][N];
            long[][] transmatrix = new long[N][N];

            long trace = 0;
            int repeatedCol = 0;
            int repeatedRow = 0;
            for (int j = 0; j < N; j++) {    //y- row number
                for (int k = 0; k < N; k++) {    //x-column number
                    matrix[j][k] = input.nextLong();
                    transmatrix[k][j] = matrix[j][k];
                }
                input.nextLine();
                trace += matrix[j][j];
            }

            //count rows
            for (int j = 0; j < N; j++) {
                Arrays.sort(matrix[j]);
                for (int p = 1; p < N; p++) {
                    if (matrix[j][p]==matrix[j][p-1]){
                        repeatedRow++;
                        break;
                    }
                }
            }

            //count cols
            for (int j = 0; j < N; j++) {
                Arrays.sort(transmatrix[j]);
                for (int p = 1; p < N; p++) {
                    if (transmatrix[j][p]==transmatrix[j][p-1]){
                        repeatedCol++;
                        break;
                    }
                }
            }

            System.out.println("Case #"+(i+1)+": "+trace + " " + repeatedRow + " " + repeatedCol);

        }
    }
}