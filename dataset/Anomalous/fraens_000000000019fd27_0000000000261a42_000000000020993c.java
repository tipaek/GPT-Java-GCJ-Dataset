import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    private int squareSize;
    private int[][] matrix;
    private int trace;
    private int doubledRows;
    private int doubledColumns;

    public Solution(int squareSize) {
        this.squareSize = squareSize;
        this.matrix = new int[squareSize][squareSize];
        this.trace = 0;
        this.doubledRows = 0;
        this.doubledColumns = 0;
    }

    public static Solution readInputOfOneSquare(Scanner in) {
        int squareSize = in.nextInt();
        Solution square = new Solution(squareSize);
        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                square.matrix[i][j] = in.nextInt();
            }
        }
        return square;
    }

    public static ArrayList<Solution> createArrayListOfAllSquares(Scanner in) {
        int numberOfSquares = in.nextInt();
        ArrayList<Solution> squares = new ArrayList<>();
        for (int i = 0; i < numberOfSquares; i++) {
            Solution square = readInputOfOneSquare(in);
            square.trace = square.calculateTrace();
            square.doubledRows = square.calculateDoubledRows();
            square.doubledColumns = square.calculateDoubledColumns();
            squares.add(square);
        }
        return squares;
    }

    private int calculateTrace() {
        int trace = 0;
        for (int i = 0; i < squareSize; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int calculateDoubledRows() {
        int doubledRows = 0;
        for (int row = 0; row < squareSize; row++) {
            HashSet<Integer> elements = new HashSet<>();
            for (int column = 0; column < squareSize; column++) {
                if (!elements.add(matrix[row][column])) {
                    doubledRows++;
                    break;
                }
            }
        }
        return doubledRows;
    }

    private int calculateDoubledColumns() {
        int doubledColumns = 0;
        for (int column = 0; column < squareSize; column++) {
            HashSet<Integer> elements = new HashSet<>();
            for (int row = 0; row < squareSize; row++) {
                if (!elements.add(matrix[row][column])) {
                    doubledColumns++;
                    break;
                }
            }
        }
        return doubledColumns;
    }

    public String latinSquareMatrixToString() {
        StringBuilder squareString = new StringBuilder();
        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                squareString.append(matrix[i][j]).append(" ");
            }
            squareString.append("\n");
        }
        return squareString.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<Solution> squares = createArrayListOfAllSquares(in);
        int caseNumber = 1;
        for (Solution square : squares) {
            System.out.println("Case #" + caseNumber + ": " + square.trace + " " + square.doubledRows + " " + square.doubledColumns);
            caseNumber++;
        }
    }
}