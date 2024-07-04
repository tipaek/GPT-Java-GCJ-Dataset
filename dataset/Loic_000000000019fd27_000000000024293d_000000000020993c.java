
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import exercise2.Solver;
//import exercise3.Solver;
//import exercise4.Solver;
//import exercise5.Solver;

public class Solution {

    public static void main(String[] args) throws IOException {
        Solver solver = new Solver(args);

    }

}

class Solver {

    public Solver(String args[]) {
        int howManyMatrix = Integer.parseInt(args[0]);

        for (int i = 1, ii = 0; ii < howManyMatrix; i++, ii++) {
            int lineMatrix = Integer.parseInt(args[i]);
            int[][] matrix = new int[lineMatrix][lineMatrix];

            for (int j = 0; j < lineMatrix; j++) {
                ++i;
                String[] line = args[i].split(" ");
                matrix[j] = StringArrToIntArr(line);
            }
            eachMatrix(matrix, ii);
        }

    }

    public int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    private void eachMatrix(int[][] matrix, int which) {
        int sumDiag = 0;
        int lineR = 0;
        int colR = 0;

        for (int i = 0; i < matrix.length; i++) {
            List<Integer> rowR = new ArrayList<>();
            boolean moreOneLine = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (!rowR.contains(matrix[i][j])) {
                    rowR.add(matrix[i][j]);
                } else {
                    moreOneLine = true;
                }

                if (i == j) {
                    sumDiag += matrix[i][j];
                }
            }
            if (moreOneLine) {
                lineR++;
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            List<Integer> rowC = new ArrayList<>();
            boolean more = false;
            for (int i = 0; i < matrix[j].length; i++) {
                if (!rowC.contains(matrix[i][j])) {
                    rowC.add(matrix[i][j]);
                } else {
                    more = true;
                }
            }
            if (more) {
                colR++;
            }
        }

        System.out.println("Case #" + (which + 1) + ": " + sumDiag + " " + lineR + " " + colR);
    }

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}



