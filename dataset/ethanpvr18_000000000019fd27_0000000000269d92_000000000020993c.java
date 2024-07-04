import java.util.Scanner;

public class Solution{

    /*
        Vestigium
        Sample Cases:

3
4
1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
3
2 1 3
1 3 2
1 2 3       

            Case #1: 4 0 0

            Case #2: 9 4 4

            Case #3: 8 0 2
     */

    public static void main(String[] args){
        //Scanner
        Scanner scanner = new Scanner(System.in);

        //Number of Cases
        int numCases = scanner.nextInt();

        //Case Loop
        for(int caseNum = 1; caseNum < numCases+1; caseNum++){

            //Size of the Given Matrix
            int sizeOfMatrix = scanner.nextInt();

            //Given Matrix to determine if Latin Square and trace
            int[][] givenMatrix = new int[sizeOfMatrix][sizeOfMatrix];
            // int[][] helperMatrix = new int[sizeOfMatrix][sizeOfMatrix];

            //Trace is the sum of the main diagonal of the given matrix
            int trace = 0;

            //Matrix Input Loop
            for(int row = 0; row < sizeOfMatrix; row++){
                for(int col = 0; col < sizeOfMatrix; col++){
                    //Input Element
                    givenMatrix[row][col] = scanner.nextInt();

                    //Compute Trace
                    if(row == col){
                        trace += givenMatrix[row][col];
                    }
                }
            }

            //Number of rows with repeated elements
            int rowRepeats = findRowRepeats(givenMatrix, /*helperMatrix, */sizeOfMatrix);

            //Number of columns with repeated elements
            int colRepeats = findColRepeats(givenMatrix, /*helperMatrix, */sizeOfMatrix);

            //Final Print Out
            System.out.println("Case #"+caseNum+": "+trace+" "+rowRepeats+" "+colRepeats);
        }

        //Close Program
        scanner.close();
        System.exit(0);
    }

    private static int findRowRepeats(int[][] mat, int size) {
        int rowRepeats = 0;

        for(int row = 0; row <= size-1; row++){
            if((perfectSum(size) != sumRow(mat, size, row))){
                rowRepeats++;
            } else if ((fhalfSumRow(mat, size/2, row) == shalfSumRow(mat, size/2, row))){
                rowRepeats++;
            }
        }
    
        return rowRepeats;
    }

    private static int fhalfSumRow(int[][] mat, int size, int row) {
        int sum = 0;

        for(int n = 0; n < size; n++){
            sum += mat[row][n];
        }
        return sum;
    }

    private static int shalfSumRow(int[][] mat, int size, int row) {
        int sum = 0;

        for(int n = 0; n < size; n++){
            sum += mat[row][n+size];
        }
        return sum;
    }

    private static int findColRepeats(int[][] mat, int size) {
        int colRepeats = 0;

        for(int col = 0; col <= size-1; col++){
            if((perfectSum(size) != sumCol(mat, size, col))){
                colRepeats++;
            } else if ((fhalfSumCol(mat, size/2, col) == shalfSumCol(mat, size/2, col))){
                colRepeats++;
            }
        }
        
        return colRepeats;
    }

    private static int fhalfSumCol(int[][] mat, int size, int col) {
        int sum = 0;

        for(int n = 0; n < size; n++){
            sum += mat[n][col];
        }
        return sum;
    }

    private static int shalfSumCol(int[][] mat, int size, int col) {
        int sum = 0;

        for(int n = 0; n < size; n++){
            sum += mat[n+size][col];
        }
        return sum;
    }

    private static int perfectSum(int n) {
        if(n == 1){
            return 1;
        } else {
            return n + perfectSum(n-1);
        }
    }

    private static int sumRow(int[][] arr, int size, int row){
        int sum = 0;

        for(int n = 0; n < size; n++){
            sum += arr[row][n];
        }
        return sum;
    }

    private static int sumCol(int[][] arr, int size, int col){
        int sum = 0;

        for(int n = 0; n < size; n++){
            sum += arr[n][col];
        }
        return sum;
    }
}