import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int totalTests = Integer.parseInt(input.nextLine());

        int counter = 0;
        while(counter < totalTests){
            int N = Integer.parseInt(input.nextLine());
            int[][] matrix = new int[N][N];
            for (int i=0; i<N; i++){
                String[] row = input.nextLine().split(" ");

                for(int r =0; r<row.length; r++){
                    matrix[i][r] = Integer.parseInt(row[r]);
                }
            }

            int trace = getTrace(matrix);
            long numofRowRepeated = getNoOfRepeatedRows(matrix);
            long numOfColumnRepeated = getNoOfRepeatedColumns(matrix);

            System.out.printf("Case #%d: %d %d %d\n",counter+1, trace, numofRowRepeated,numOfColumnRepeated);
            counter++;
        }
    }

    private static int getTrace (int[][] matrix){
        int trace = 0;
        for (int j= 0; j<matrix.length; j++){
            trace += matrix[j][j];
        }
        return trace;
    }

    private static long getNoOfRepeatedRows (int[][] matrix){
        int repeatedRows = 0;

        Long newSizes = Arrays.stream(matrix).mapToLong(arr-> Arrays.stream(arr).distinct().count()).filter((i)->i<matrix.length)
                .count();
        return newSizes;
    }

    private static long getNoOfRepeatedColumns (int [][] matrix){
        int repeatedRows = 0;
        int temp[][] = reverseRowsColumn(matrix);
        Long newSizes = Arrays.stream(temp).mapToLong(arr-> Arrays.stream(arr).distinct().count()).filter((i)->i<matrix.length)
                .count();
        return newSizes;
    }

    private static int [][] reverseRowsColumn (int [][] matrix){
        int reverse[][]= new int [matrix.length][matrix.length];
        for(int row = 0; row<matrix.length; row++){
            for(int col = 0; col<matrix.length; col++){
                reverse[row][col] = matrix[col][row];
            }
        }
        return reverse;
    }
}
