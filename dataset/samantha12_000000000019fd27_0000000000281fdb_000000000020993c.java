import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int p = in.nextInt();
            int[][] matrix = new int[p][p];
            int trace = 0;
            int row = 0;
            for(int j = 0; j < p; j ++) {
                for(int k = 0; k < p; k ++) {
                    matrix[j][k] = in.nextInt();
                    if(j == k) {
                        trace +=matrix[j][k];
                    }
                }
                row += hasRepeat(matrix[j]);
            }

            int col = 0;
            for(int j = 0; j < p; j ++) {
                int[] array = new int[p];
                for(int k = 0; k < p; k ++) {
                    array[k] = matrix[k][j];
                }
                col += hasRepeat(array);
            }
            System.out.println(String.format("Case #%d: %d %d %d", i, trace, row, col));
        }
    }

    private static int hasRepeat( final int[] matrix) {
        int[] a = Arrays.copyOf(matrix, matrix.length);
        for(int i = 0; i < a.length; i++) {
            int index = Math.abs(a[i]) - 1;
            if(a[index] < 0) {
                return 1;
            }else {
                a[index] *= -1;
            }
        }
        return 0;
    }
}
