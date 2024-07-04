import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // number of test
        int n_test = in.nextInt() ;
        in.nextLine(); // just move to next line

        int N = 0;
        int trace = 0;
        // actual test case
        for (int i = 0; i < n_test; i++) {

            // number of N, so N x N
            N = in.nextInt();
            in.nextLine(); // just move to next line

            // prepare a matrix
            trace = 0;
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {

                // make a row
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = in.nextInt();
                }
                in.nextLine(); // just move to next line
            }

            // just check (test)
//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < N; k++) {
//                    System.out.print(matrix[j][k] + " ");
//                }
//                System.out.println();
//            }

            // get trace
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (j == k)
                    trace += matrix[j][k];
                }
            }

            // check natural Latin square
            int[] array = new int[N];

            int n_row = 0;
            int n_col = 0;

            // for a given 1-dimension array,
            // store a vaule into a array of the index,
            // and before storing, check it is zero or not

            // check rows
            for (int j = 0; j < N; j++) {
                for ( int k = 0; k < N; k++ ) {
                    // check if it already exists
                    if ( array[ matrix[j][k] ] != 0) {
                        n_row++;
                        k = N;  // move to next row
                    } else {
                        array[ matrix[j][k] ]++;
                    }
                }
            }

            // reset array
            for (int j = 0; j < N; j++)
                array[j] = 0;

            // check columns
            for (int j = 0; j < N; j++) {
                for ( int k = 0; k < N; k++ ) {
                    // check if it already exists
                    if ( array[ matrix[k][j] ] != 0) {
                        n_col++;
                        k = N;  // move to next row
                    } else {
                        array[ matrix[k][j] ]++;
                    }
                }
            }

            // output display
            System.out.println("Case #" + i +": " + trace + " " + n_row + " " + n_col);
        }
    }
}
