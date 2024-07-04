import java.util.*;
import java.io.*;

/**
 *
 * @author josuepirir
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static StringBuilder operar(int caso, int[][] inLin) {

        int diagonal = 0;
        int columna = 0;
        int fila = 0;
        boolean columnaStep = false;
        Boolean filaStep = false;

        for (int i2 = 0; i2 < inLin.length; i2++) {
            for (int j = 0; j < inLin[i2].length; j++) {

                if (j != 0 && columnaStep != true) {
                    for (int k = 0; k < j; k++) {
                        if (inLin[i2][k] == inLin[i2][j]) {
                            columna++;
                            columnaStep = true;
                            break;
                        }
                    }
                }

                if (j != 0 && filaStep != true) {
                    for (int k = 0; k < j; k++) {
                        if (inLin[k][i2] == inLin[j][i2]) {
                            fila++;
                            filaStep = true;
                            break;
                        }
                    }
                }

                if (i2 == j) {
                    diagonal += inLin[i2][j];
                }

            }

            columnaStep = false;

            filaStep = false;

        }

        StringBuilder sb = new StringBuilder("Case #");
        sb.append(caso);
        sb.append(": ");
        sb.append(diagonal);
        sb.append(" ");
        sb.append(columna);
        sb.append(" ");
        sb.append(fila);

        return sb;
    }

    public static void main(String[] args) {

        int[][] inLin;

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        //System.out.println("t: " + t);
        for (int i = 1; i <= t; ++i) {

            int n = in.nextInt();
            //System.out.println("n: " + n);

            inLin = new int[n][n];

            for (int j = 1; j <= n; ++j) {
                for (int k = 1; k <= n; ++k) {
                    int m1 = in.nextInt();
                    inLin[j - 1][k - 1] = m1;
                }

            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                    //System.out.print(inLin[j][k] + " ");
                }
                //System.out.println("");
            }

            //System.out.println("");

            System.out.println(operar(i, inLin));

        }
    }

}
