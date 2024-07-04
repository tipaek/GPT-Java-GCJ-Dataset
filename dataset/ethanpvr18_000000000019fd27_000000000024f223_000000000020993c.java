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
            int[][] helperMatrix = new int[sizeOfMatrix][sizeOfMatrix];

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

            //Matrix 2 Input Loop
            for(int row = 0; row < sizeOfMatrix; row++){
                for(int col = 0; col < sizeOfMatrix; col++){
                    //Input Element
                    helperMatrix[row][col] = givenMatrix[row][col];
                }
            }

            //Number of rows with repeated elements
            int rowRepeats = findRowRepeats(givenMatrix, helperMatrix, sizeOfMatrix);

            //Number of columns with repeated elements
            int colRepeats = findColRepeats(givenMatrix, helperMatrix, sizeOfMatrix);

            //Final Print Out
            System.out.println("Case #"+caseNum+": "+trace+" "+rowRepeats+" "+colRepeats);
        }

        //Close Program
        scanner.close();
        System.exit(0);
    }

    public static int findRowRepeats(int[][] mat, int[][] mat2, int size) {
        int rowRepeats = 0;

        int prevDoubleRowIndex = 0;

        for(int row = 0; row <= size-1; row++){
            for(int col = 0; col <= size-1 && rowRepeats <= row; col++){
                for(int rowIndex = 0; rowIndex <= mat2[row].length-1 && rowRepeats <= row; rowIndex++){
                        if(col != rowIndex){
                            if(row >= size-1 && col == prevDoubleRowIndex){
                                return rowRepeats;
                            } else if(mat[row][col] == mat2[row][rowIndex]){
                                prevDoubleRowIndex = rowIndex;
                                rowRepeats++;
                            }
                        }
                }
            }
        }
    
        return rowRepeats;
    }

    private static int findColRepeats(int[][] mat, int[][] mat2, int size) {
        int colRepeats = 0;

        int prevDoubleRowIndex = 0;

        for(int row = 0; row <= size-1; row++){
            for(int col = 0; col <= size-1 && colRepeats <= row; col++){
                for(int rowIndex = 0; rowIndex <= mat2[row].length-1 && colRepeats <= row; rowIndex++){
                    if(col != rowIndex){
                        if(row >= size-1 && col == prevDoubleRowIndex){
                            return colRepeats;
                        } else if(mat[col][row] == mat2[rowIndex][row]){
                            prevDoubleRowIndex = rowIndex;
                            colRepeats++;
                        }
                    }
                }
            }
        }
        
        return colRepeats;
    }
}