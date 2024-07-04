import java.util.*;

public class Solution
{
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int counter = 0; counter < n; counter++){
            int k = 0;
            int r = 0;
            int c = 0;

            int matrixDimension = in.nextInt();
            int[][] matrix = new int[matrixDimension][matrixDimension];

            for(int i = 0; i < matrixDimension; i++){
                for(int j = 0; j < matrixDimension; j++){
                    matrix[i][j] = in.nextInt();
                }
            }

            for(int i = 0; i < matrixDimension; i++){
                boolean[] row = new boolean[matrixDimension + 1];
                boolean[] col = new boolean[matrixDimension + 1];
                Arrays.fill(row, false);
                Arrays.fill(col, false);
                boolean rowRepetition = false;
                boolean colRepetition = false;

                for(int j = 0; j < matrixDimension; j++){
                    if(row[matrix[i][j]]) rowRepetition = true;
                    else row[matrix[i][j]] = true;
                    if(col[matrix[j][i]]) colRepetition = true;
                    else col[matrix[j][i]] = true;
                }

                k += matrix[i][i];
                if(rowRepetition) r++;
                if(colRepetition) c++;
            }

            System.out.println("Case #" + (counter + 1) + ": " + k + " " + r + " " + c);
        }
    }
}