import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws Exception {
        //BufferedReader bufferRead = new BufferedReader(new FileReader("A-small-practice.in"));
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new FileWriter("A-small-practice.out"));

        int caseCnt = Integer.parseInt(bufferRead.readLine());

        for(int l=0; l<caseCnt; l++) {
            int N = Integer.parseInt(bufferRead.readLine());

            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] caseData = bufferRead.readLine().split(" ");
                for(int j=0; j<N; j++) {
                    matrix[i][j] = Integer.parseInt(caseData[j]);
                }
                //System.out.println(Arrays.toString(matrix[i]));
            }

            //out.println("Case #"+(l+1)+": "+checkChaos(N, L, source, target));\
            System.out.println("Case #"+(l+1)+": "+checkLatinSquare(N, matrix));
        }

        //out.close();
        bufferRead.close();
    }

    private static String checkLatinSquare(int N, int[][] matrix) {
        int trace = 0;
        int rows = 0;
        int cols = 0;
        int[][] rowsA = new int[N][N+1];
        int[][] colsA = new int[N][N+1];
        boolean[] row = new boolean[N];
        boolean[] col = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                int num = matrix[i][j];
                if (rowsA[i][num] > 0) {
                    row[i] = true;
                }

                if (colsA[j][num] > 0) {
                    col[j] = true;
                }

                rowsA[i][num]++;
                colsA[j][num]++;
                //System.out.println(Arrays.toString(colsA[j]));
            }
            //System.out.println(Arrays.toString(rowsA[i]));
        }

        for (int i = 0; i < N; i++) {
            if (row[i]) {
                rows++;
            }

            if (col[i]) {
                cols++;
            }
        }

        return "" + trace + " " + rows + " " + cols;
    }
}
