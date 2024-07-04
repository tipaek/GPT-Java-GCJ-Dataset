import java.util.Scanner;

public class Solution {

    /*
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
        Scanner s = new Scanner(System.in);

        //Number of Cases
        int numCases = s.nextInt();

        //Case Loop
        for(int caseNum = 1; caseNum < numCases+1; caseNum++){

            //Size of the Given Matrix
            int sizeOfMatrix = s.nextInt();

            //Given Matrix to determine if Latin Square and trace
            int[][] givenMatrix = new int[sizeOfMatrix][sizeOfMatrix];
            int[][] helperMatrix = new int[sizeOfMatrix][sizeOfMatrix];

            //Trace is the sum of the main diagonal of the given matrix
            int trace = 0;

            //Matrix Input Loop
            for(int i = 0; i < sizeOfMatrix; i++){
                for(int j = 0; j < sizeOfMatrix; j++){
                    //Input Element
                    givenMatrix[i][j] = s.nextInt();

                    //Compute Trace
                    if(i == j){
                        trace += givenMatrix[i][j];
                    }
                }
            }

            //Matrix 2 Input Loop
            for(int i = 0; i < sizeOfMatrix; i++){
                for(int j = 0; j < sizeOfMatrix; j++){
                    //Input Element
                    helperMatrix[i][j] = givenMatrix[i][j];
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
        s.close();
        System.exit(0);
    }

    public static int findRowRepeats(int[][] mat, int[][] mat2, int size) {
        int rowRepeats = 0;

        int prevDubX = 0;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size && rowRepeats <= i; j++){
                for(int x = 0; x < mat2[i].length && rowRepeats <= i; x++){
                        if(j != x){
                            if(i >= size-1 && j == prevDubX){
                                return rowRepeats;
                            } else if(mat[i][j] == mat2[i][x]){
                                prevDubX = x;
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

        int prevDubX = 0;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size && colRepeats <= i; j++){
                for(int x = 0; x < mat2[i].length && colRepeats <= i; x++){
                    if(j != x){
                        if(i >= size-1 && j == prevDubX){
                            return colRepeats;
                        } else if(mat[j][i] == mat2[x][i]){
                            prevDubX = x;
                            colRepeats++;
                        }
                    }
                }
            }
        }
        
        return colRepeats;
    }
}