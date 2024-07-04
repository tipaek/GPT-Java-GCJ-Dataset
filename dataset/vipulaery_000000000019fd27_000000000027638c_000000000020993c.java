import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(bufferedReader.readLine());
        int max_size = 100;
        int[][] squareMatrix = new int[max_size][max_size];

        for (int testcaseNumber = 0; testcaseNumber < testcases; testcaseNumber++) {
            int squareMatrixSize = Integer.parseInt(bufferedReader.readLine().trim());
            int repeatedElementsRow = 0, repeatedElementsColumn = 0;

            for (int rowCount = 0; rowCount < squareMatrixSize; rowCount++) {
                String[] row = bufferedReader.readLine().split(" ");
                int[] elementsCount = new int[squareMatrixSize+1];
                boolean isRepatedElementsRow = false;
                for (int columnCount = 0; columnCount < squareMatrixSize; columnCount++) {
                    squareMatrix[rowCount][columnCount] = Integer.parseInt(row[columnCount]);
                    elementsCount[squareMatrix[rowCount][columnCount]]++;
                    if(!isRepatedElementsRow && elementsCount[squareMatrix[rowCount][columnCount]] == 2){
                        isRepatedElementsRow = true;
                    }
                }
                if(isRepatedElementsRow){
                    repeatedElementsRow++;
                }
            }
            int sum = 0;
            for (int columnCount = 0; columnCount < squareMatrixSize; columnCount++) {
                int[] elementsCount = new int[squareMatrixSize+1];
                boolean isRepatedElementsColumn = false;
                for (int rowCount = 0; rowCount < squareMatrixSize; rowCount++) {
                    elementsCount[squareMatrix[rowCount][columnCount]]++;
                    if(!isRepatedElementsColumn && elementsCount[squareMatrix[rowCount][columnCount]] == 2){
                        isRepatedElementsColumn = true;
                    }
                    if(rowCount == columnCount){
                        sum += squareMatrix[rowCount][columnCount];
                        if(isRepatedElementsColumn){
                            rowCount = squareMatrixSize;
                        }
                    }
                }
                if(isRepatedElementsColumn){
                    repeatedElementsColumn++;
                }
            }
            System.out.println("Case #"+testcaseNumber+1+": "+ sum +" "+ repeatedElementsRow +" "+ repeatedElementsColumn);
        }
    }
}
