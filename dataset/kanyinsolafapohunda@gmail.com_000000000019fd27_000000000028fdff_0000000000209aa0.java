import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Indicium solver = new Indicium();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Indicium {

        void solve(int testNumber, InputReader in, PrintWriter out) {

            int N = in.nextInt();
            int K = in.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                matrix[i] = new int[N];
            }

            boolean result = solveIncidium(matrix, 0, 0, K, 0);

            out.printf("Case #%d: %s", testNumber, result ? "POSSIBLE" : "IMPOSSIBLE");
            out.println();
            if (result) {
                printMatrix(out, matrix);
            }
        }

        void printMatrix(PrintWriter out, int[][] matrix) {
            for (int[] aMatrix : matrix) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < matrix.length; j++) {
                    sb.append(aMatrix[j]);
                    sb.append(" ");
                }
                out.println(sb.toString().trim());
            }
        }

       boolean solveIncidium(int[][] matrix, int row, int col, int K, int currentDiagonalSum) {

            int N = matrix.length;
            if (row == N || col == N) return true;

            int newRow = col + 1 == N ? row + 1 : row;
            int newCol = col + 1 == N ? 0 : col + 1 ;

            for (int i : allowedValues(matrix, row, col, K, currentDiagonalSum)) {

//                if (isValid(matrix, row, col, i, K, currentDiagonalSum)) {
//                    System.out.println("Did put " + i +" in " + row +"," +col);
                    matrix[row][col] = i;
                    if (row == col) {
                        currentDiagonalSum += i;
                    }
                    //printMatrix( new PrintWriter(System.out), matrix);
                    if (solveIncidium(matrix, newRow, newCol, K, currentDiagonalSum)) {
                        return true;
                    }
                    if (row == col) {
                        currentDiagonalSum -= i;
                    }
                    matrix[row][col] = 0;
//                } else {
//                    System.out.println("Cant put " + i +" in " + row +"," +col);
//                }
            }

            return false;
        }

 Set<Integer> allowedValues(int[][] matrix, int row, int col, int K, int currentDiagonalSum) {

            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= matrix.length; i++)
                set.add(i);

            for (int i = 0; i < matrix.length; i++) {

                if ( set.contains(matrix[row][i]) ) { // check row.
                    set.remove(matrix[row][i]);
                }

                if (  set.contains(matrix[i][col]) ) { // check col.
                    set.remove(matrix[i][col]);
                }
            }

            if (row == col) {
                for (int i = 1; i <= matrix.length; i++) {
                    int diagonalLeft = matrix.length - row - 1;
                    int left = K - currentDiagonalSum - i;
                    if (diagonalLeft == 0 && currentDiagonalSum + i != K) {
                        set.remove(i);
                    } else if (diagonalLeft > 0 && left < diagonalLeft) {
                        set.remove(i);
                    }
                }
            }

            return set;
        }

        boolean isValid(int[][] matrix, int row, int col, int value, int K, int currentDiagonalSum) {

            for (int i = 0; i < matrix.length; i++) {

                if ( matrix[row][i] == value ) { // check row.
                    return false;
                }

                if ( matrix[i][col] == value ) { // check col.
                    return false;
                }
            }

            if (row == col) {
                int diagonalLeft = matrix.length - row - 1;
                int left = K - currentDiagonalSum - value;

//                System.out.println("Left " + left + " DiagonalLeft " + diagonalLeft + " CurrentDiagonalSum " + currentDiagonalSum) ;

                if (diagonalLeft == 0) return currentDiagonalSum + value == K;
                else if (diagonalLeft > 0) return left >= diagonalLeft;
            }

            return true;
        }
    }
    
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            return nextToken();
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
    }
}