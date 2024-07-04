import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    int squareSize;
    int[][] matrix;
    int trace;
    int doubledRows;
    int doubledColumns;

    public Solution(int squareSize){
        this.squareSize = squareSize;
        this.matrix = new int[squareSize][squareSize];
        trace = 0;
        doubledRows = 0;
        doubledColumns = 0;
    }

    public static Solution readInputOfOneSquare(Scanner in){
        int squareNParameter = in.nextInt();
        Solution square = new Solution(squareNParameter);
        for(int i = 0; i < squareNParameter; i++){
            for (int j = 0; j < squareNParameter; j++) {
                square.matrix[i][j] = in.nextInt();
            }
        }
        return square;
    }

    public static ArrayList<Solution> createArrayListOfAllSquares(Scanner in){
        int numberOfSquares = in.nextInt();
        Solution square;
        ArrayList<Solution> squareArrayList = new ArrayList<>();
        for (int i = 0; i < numberOfSquares ; i++) {
            square = readInputOfOneSquare(in);
            square.trace = square.calculateTrace();
            square.doubledRows = square.calculateDoubleRows();
            square.doubledColumns = square.calculateDoubleColumns();
            squareArrayList.add(square);
        }
        return squareArrayList;
    }

    public int calculateTrace(){
        int trace = 0;
        for (int i = 0; i < squareSize; i++) {
            trace = trace + matrix[i][i];
        }
        return trace;
    }

    public int calculateDoubleRows(){
        int doubleRows = 0;
        HashSet checkForDoubles = new HashSet();

        for (int row = 0; row < squareSize; row++) {

            checkForDoubles = new HashSet();
            for (int column = 0; column < squareSize; column++) {

                int element = matrix[row][column];
                if (!checkForDoubles.add(element)) {
                    doubleRows++;
                    break;
                }
            }

        }
        return doubleRows;
    }

    public int calculateDoubleColumns(){
        int doubleColumns = 0;
        HashSet checkForDoubles = new HashSet();

        for (int column = 0; column < squareSize; column++) {

            checkForDoubles = new HashSet();
            for (int row = 0; row < squareSize; row++) {
                int element = matrix[row][column];
                if (!checkForDoubles.add(element)) {
                    doubleColumns++;
                    break;
                }
            }
        }
        return doubleColumns;
    }

    public String latinSquareMatrixToString(){
        String squareString = "";
        for(int i = 0; i < squareSize; i++){
            for (int j = 0; j < squareSize; j++) {
                squareString = squareString + matrix[i][j] + " ";
            }
            squareString += "\n";
        }
        return squareString;
    }

    public void outputAnswers(ArrayList<Solution> squareList){

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<Solution> mySquares = createArrayListOfAllSquares(in);
        int i = 1;
        for (Solution square: mySquares) {
            System.out.println("Case #" + i + ": " + square.trace + " " + square.doubledRows + " " + square.doubledColumns);
            i++;
        }
    }
}
