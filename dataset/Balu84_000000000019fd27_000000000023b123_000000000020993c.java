import java.util.*;
import java.io.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %d %d %d"; //Use with String.format - 1.: number of the test case, 2.: is the trace of the matrix, 3.: is the number of rows of the matrix that contain repeated elements, 4.: is the number of columns of the matrix that contain repeated elements
    private static final String SEPARATOR = " ";
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt(); //number of test cases
        in.nextLine();
        for (int currentTestCase = 1; currentTestCase <= T; currentTestCase++) {
            int k = 0; //the trace of the matrix
            int r = 0; //the number of rows of the matrix that contain repeated elements
            int c = 0; //the number of columns of the matrix that contain repeated elements
            final int N = in.nextInt(); //natural matrix size
            in.nextLine();
            final int[][] matrix = new int[N][N];
            for(int matrixRowIndex = 0; matrixRowIndex < N; matrixRowIndex++) {
                String matrixRowStr = in.nextLine();
                String[] matrixCellStrs = matrixRowStr.split(SEPARATOR);
                int matrixColumnIndex = 0;
                Set<Integer> rowSet = new HashSet(); //to check if rows contain duplicated elements
                for(String cellStr : matrixCellStrs) {
                    int cell = Integer.parseInt(cellStr.trim());
                    matrix[matrixRowIndex][matrixColumnIndex++] = cell;
                    rowSet.add(cell);
                }
                if(rowSet.size() != N) { //if there are less element in the set, there were duplicated ones
                    r++;
                }
            } //end of parsing the input matrix
            //calculate the trace of the matrix
            for(int i=0; i<N; i++) {
                k += matrix[i][i];
            }
            //check for columns whit repeated elements
            for(int columnIndex=0; columnIndex<N; columnIndex++) {
                Set<Integer> columnSet = new HashSet(); //to check if columns contain duplicated elements
                for(int rowIndex=0; rowIndex<N; rowIndex++) {
                    columnSet.add(matrix[rowIndex][columnIndex]);
                }
                if(columnSet.size() != N) { //if there are less element in the set, there were duplicated ones
                    c++;
                }
            }
            System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, k, r, c));
        }
    }
}