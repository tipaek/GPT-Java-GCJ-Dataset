import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalNumberOfMatrix = in.nextInt();
        in.nextLine();
        
        for (int i = 1; i <= totalNumberOfMatrix; ++i) {
            int matrixSize = in.nextInt();
            in.nextLine();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                String line = in.nextLine();
                String[] splittedLine = line.split(" ");
                
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = Integer.parseInt(splittedLine[k]);
                }

            }

            int traceResult = traceSolution(matrix);
            int rowResult = rowSolution(matrix);
            int columnResult = columnSolution(matrix);

            System.out.println("Case #" + i + ": " + traceResult + " " + rowResult + " " + columnResult);
        }
    }

    private static int traceSolution(int[][] matrix) {
        int result = 0;
        for( int i = 0; i < matrix.length; i++) {
            result += matrix[i][i];
        }
        return result;
    }

    private static int rowSolution(int[][] matrix) {
        int result = 0;
        for( int i = 0; i < matrix.length; i++) {
            boolean repeated = false;
            for( int j = 0; j < matrix.length; j++) {
                int selectedItem = matrix[i][j];
                for( int k = j+1; k < matrix.length; k++) {
                    if ( selectedItem == matrix[i][k] ) {
                        repeated = true;
                    }
                }
            }
            if (repeated) {
                result+=1;
            }
        }
        return result;
    }

    private static int columnSolution(int[][] matrix) {
        int result = 0;
        for( int i = 0; i < matrix.length; i++) {
            boolean repeated = false;
            for( int j = 0; j < matrix.length; j++) {
                int selectedItem = matrix[j][i];
                for( int k = j+1; k < matrix.length; k++) {
                    if ( selectedItem == matrix[k][i] ) {
                        repeated = true;
                    }
                }
            }
            if (repeated) {
                result+=1;
            }
        }
        return result;
    }
}