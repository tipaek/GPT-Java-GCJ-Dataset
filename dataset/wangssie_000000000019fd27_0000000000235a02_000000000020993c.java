import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            Matrix matrix = new Matrix(N);

            int[][] matrixHolder = new int[N][N];
            for (int x=0; x<N; x++) {
                for (int y=0; y<N; y++){
                    matrixHolder[x][y] = in.nextInt();
                }
            }
            matrix.setMatrix(matrixHolder);
            System.out.println("Case #" + t + ": "+matrix.calcTrace() + " " + matrix.rowRepeats() + " " + matrix.colRepeats());
        }
    }
}


class Matrix {
    private int dimension;
    private int[][] matrix;
    private int trace;

    /*Constructor*/
    public Matrix(int dimension) {
        this.dimension = dimension;
    }

    /*Setter*/
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    /*Getter*/
    public int getDimension() {
        return dimension;
    }

    public int getTrace() {
        return trace;
    }

    /*Methods*/
    public int calcTrace() {
        int trace = 0;
        for (int i = 0; i < dimension; i++) {
            trace += this.matrix[i][i];
        }
        this.trace = trace;
        return trace;
    }

    public int rowRepeats() {
        int repeats = 0;
        for (int[] row : this.matrix) {

            int[] track = new int[this.dimension];

            for (int element : row) {

                if (track[element - 1] == 0) {
                    track[element - 1] = 1;
                } else {
                    repeats++;
                    break;
                }
            }

        }
        return repeats;
    }

    public int colRepeats() {
        int repeats = 0;

        for (int i=0; i<this.dimension; i++) {
            int[] track = new int[this.dimension];
            for (int j=0; j<this.dimension;j++){
                int num = this.matrix[j][i];
                if (track[num-1] == 0) {
                    track[num-1] = 1;
                }
                else {
                    repeats ++;
                    break;
                }
            }
        }

        return repeats;
    }
}