import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Indicium {

    public static int[][] matrix;

    public static void Solution(String[] args) {

        Scanner scanner = new Scanner(System.in); 

        int testCases = scanner.nextInt();

        for(int i = 1; i <= testCases; i++){

            int matrixSize = scanner.nextInt();
            int trace = scanner.nextInt();

            matrix = new int[matrixSize][matrixSize];

            ArrayList<Integer> assumedRow = new ArrayList<>();
            for(int defaultNum = 1; defaultNum < matrixSize; defaultNum++){
                assumedRow.add(defaultNum);
            }

            // FILLL MATRIX
            Indicium indicium = new Indicium();
            indicium.solve(trace);


            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++){
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }
        }
    }


    public boolean solve(int trace){
        for (int row = 0; row < matrix.length; row++) {
            // int startNum = 1;
            for(int startNum = 1; startNum < matrix.length; startNum++){
                if(TryRowForming(row, startNum))
                    break;
            }
            

            
            // System.out.println();
        }

        return true;
    }

    public boolean fillDiagonal(int trace){
        if(trace < matrix.length){
            return false;
        }

        for(int i = 1; i < matrix.length; i++){
            // System.out.println(latinSquare[i][i]);
            trace += latinSquare[i][i];
        }

        return true;
    }

    public boolean TryRowForming(int row, int startNum){
        boolean isRowFormationOk = true;
        for (int col = 0; col < matrix.length; col++){
            // System.out.print(matrix[row][col] + " ");
            boolean isNumInserted = false;
            for (int number = startNum; number <= matrix.length; number++) {
            
                if(isNumToBeInserted(number, row, col)){
                    matrix[row][col] = number;
                    isNumInserted = true;
                    break;
                }
                
            }

            for (int number = 1; number < startNum; number++) {
            
                if(isNumToBeInserted(number, row, col)){
                    matrix[row][col] = number;
                    isNumInserted = true;
                    break;
                }
                
            }

            if(!isNumInserted){
                isRowFormationOk = false;
                break;
            }

        }

        return isRowFormationOk;
    }

    public boolean isNumToBeInserted(int number, int row, int col){

        if(inRow(row, number) || inCol(col, number)){
            return false;
        }

        return true;
    }

    public boolean inRow(int row, int number){
        boolean inRow = false;

        for(int i = 0; i < matrix.length; i++){
            if(matrix[row][i] == number){
                inRow = true;
                break;
            }
        }

        return inRow;
    }

    public boolean inCol(int col, int number){
        boolean inCol = false;

        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][col] == number){
                inCol = true;
                break;
            }
        }

        return inCol;
    }
}