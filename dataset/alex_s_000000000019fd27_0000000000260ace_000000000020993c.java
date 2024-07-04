import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        
        for(int t = 1; t <= numCases; t++) {
            System.out.print("Case #" + t + ":");
            int[][] matrix = readMatrix(input);
            System.out.println(solve(matrix));
        }
        
        input.close();
    }
    
    static int[][] readMatrix(Scanner input){
        int dim = input.nextInt();
        int[][] result = new int[dim][dim];

        for(int row = 0; row < dim; row++) {
            for(int col = 0; col < dim; col++) {
                result[row][col] = input.nextInt();
            }
        }
        return result;
    }

    static String solve(int[][] matrix){
        int dim = matrix.length;

        int trace = 0;
        int rowCount = 0;
        int colCount = 0;
        
        for(int i = 0; i < dim; i++) {
            trace += matrix[i][i];
        }
        
        for(int row = 0; row < dim; row++) {
            boolean[] arr = new boolean[dim];
            for( int col = 0; col < dim; col++) {
                if(arr[matrix[row][col]-1]) {
                    rowCount++;
                    break;
                }
                arr[matrix[row][col]-1] = true;
            }
        }
        for(int col = 0; col < dim; col++) {
            boolean[] arr = new boolean[dim];
            for( int row = 0; row < dim; row++) {
                if(arr[matrix[row][col]-1]) {
                    colCount++;
                    break;
                }
                arr[matrix[row][col]-1] = true;
            }
        }
        
        return " " + trace + " " + rowCount + " " + colCount;
    }
}
