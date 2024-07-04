import java.util.*;

public class Solution {

    static int readMatrix_sumOfDiagonal(int size, int[][] m, Scanner scanner){
        int sum = 0;
        for(int i=1; i<=size; i++){
            for(int j=1; j<=size; j++){
                m[i][j] = scanner.nextInt();
            }
            sum+=m[i][i];
        }
        return sum;
    }

    static int countWrongRows(int[][] m, int size){
        int nrRows = 0;
        for(int i=1; i<=size; i++){
            Set<Integer> distinctValues = new HashSet<Integer>();
            for(int j=1; j<=size; j++) {
                distinctValues.add(m[i][j]);
            };
            if(distinctValues.size()<size) nrRows++;
        }
        return  nrRows;
    }

    static int countWrongCols(int[][] m, int size){
        int nrCols = 0;
        for(int i=1; i<=size; i++){ //column index
            Set<Integer> distinctValues = new HashSet<Integer>();
            for(int j=1; j<=size; j++) { //row index
                distinctValues.add(m[j][i]);
            };
            if(distinctValues.size()<size) nrCols++;
        }
        return  nrCols;
    }


    public static void main(String[] args){
        final int MAX_SIZE = 100;
        Scanner scanner = new Scanner(System.in);
        int noScuares, size, noWrongRows, noWrongColumns, diagSum;
        int[][] m = new int[MAX_SIZE+1][MAX_SIZE+1];

        noScuares = scanner.nextInt();
        for(int t=1; t<=noScuares; t++){
            size = scanner.nextInt();
            diagSum = readMatrix_sumOfDiagonal(size, m, scanner);
            System.out.println("Case #" + t + ": " + diagSum + " " + countWrongRows(m, size) + " " + countWrongCols(m, size));
        }
    }
}
