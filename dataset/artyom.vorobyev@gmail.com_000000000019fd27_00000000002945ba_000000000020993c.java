import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int tx = 0, ty = 0;

    public static void main(String[] args) {
        Scanner myInput = new Scanner( System.in );
        int cases = myInput.nextInt();
        for (int i = 0; i<cases; i++) {
            int sz = myInput.nextInt();
            int[][] matrix = new int[sz][sz];
            for (int j=0; j<sz; j++) {
                for (int k = 0; k<sz; k++) {
                    matrix[j][k] = myInput.nextInt();
                }
            }
            int trace = traceMatrix(matrix);
            System.out.println("Case #"+(i+1)+": " + trace + " " + tx + " " + ty);
        }
    }

    private static int traceMatrix(int[][] m) {
        int[] tracer = new int[m.length];
        tx = 0;
        for (int i = 0; i<m.length; i++) {
           Arrays.fill(tracer, 0);
           for (int j = 0; j<m.length; j++) {
               if (tracer[m[i][j]-1] == 0) {
                   tracer[m[i][j]-1] = 1;
               } else {
                   tx++;
                   break;
               }
           }
        }
        ty = 0;
        for (int i = 0; i<m.length; i++) {
            Arrays.fill(tracer, 0);
            for (int j = 0; j<m.length; j++) {
                if (tracer[m[j][i]-1] == 0) {
                    tracer[m[j][i]-1] = 1;
                } else {
                    ty++;
                    break;
                }
            }
        }

        int r = 0;

        for (int i=0; i<m.length; i++) {
            r+=m[i][i];
        }

        return r;
    }
}
