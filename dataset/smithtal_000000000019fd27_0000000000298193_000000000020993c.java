import java.util.Scanner;

public class Solution{
    private static Scanner scanner;
    public static void main(String[] args){
        scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < cases; i++){
            int n = scanner.nextInt();
            int[][] matrix = buildMatrix(n);
            int trace = calculateTrace(matrix, n);
            int numberOfRows = rowsWithDuplicates(matrix,n);
            int numberOfColumns = columnsWithDuplicates(matrix, n);
            System.out.printf("Case #%d: %d %d %d", i, trace, numberOfRows, numberOfColumns);
            if(i < cases - 1){
                System.out.println();
            }
        }
    }

    private static int calculateTrace(int[][] matrix, int n){
        int trace = 0;
        for(int i = 0; i < n; i++){
            trace += matrix[i][i];
        }

        return trace;
    }

    private static int rowsWithDuplicates(int[][] matrix, int n){
        int numberOfRows = 0;
        for(int i = 0; i < n; i++){
            int[] values = new int[n];
            for(int j = 0; j < n; j++){
                if(values[matrix[i][j] - 1] != 0){
                    numberOfRows++;
                    break;
                }else{
                    values[matrix[i][j] - 1] = 1;
                }
            }
        }
        return numberOfRows;
    }

    private static int columnsWithDuplicates(int[][] matrix, int n){
        int numberOfColumns = 0;
        for(int i = 0; i < n; i++){
            int[] values = new int[n];
            for(int j = 0; j < n; j++){
                if(values[matrix[j][i] - 1] != 0){
                    numberOfColumns++;
                    break;
                }else{
                    values[matrix[j][i] - 1] = 1;
                }
            }
        }
        return numberOfColumns;
    }



    private static int[][] buildMatrix(int n){
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = scanner.nextInt();
            }
            if(scanner.hasNext()){
                scanner.nextLine();
            }
        }
        return matrix;
    }

}