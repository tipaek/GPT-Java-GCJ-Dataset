import java.util.*;

public class Solution {
    public static void main (String [] args) {
        naturalLatinSquareFromScannerInput();
    }

    public static void naturalLatinSquareFromScannerInput() {
        Scanner scanner = new Scanner(System.in);


        int numberOfWrongRows = 0;
        int numberOfWrongColumns = 0;
        int traceOfMatrix = 0;

        //[numberOfTestCases, rowOfMatrix]
        String[][] inputMatrices = getInput(scanner,  Integer.parseInt(scanner.nextLine()));
        String [] output = new String[inputMatrices.length];
        //numberOfTestCases
        for (int matrixCase = 0; matrixCase < inputMatrices.length; matrixCase++) {
            int[][] matrix = getMatrix(inputMatrices[matrixCase]);
            //calc trace of matrix
            traceOfMatrix = getTraceOfMatrix(matrix);
            //ccheck duplicate of column
            for (int column = 0; column < matrix.length; column++) { //number of elements in a row (#columns)
                if (findDuplicateInArray(matrix[column])) {
                    numberOfWrongColumns++;
                }
            }
            //check duplicate of Row, use the String matrix, to get lazier the rows
            for (int row = 0; row < inputMatrices[matrixCase].length; row++) {
                if (findDuplicateInArray(inputMatrices[matrixCase][row])) {
                    numberOfWrongRows++;
                }
            }
            output[matrixCase] = "Case #" + (matrixCase + 1) + ": " + traceOfMatrix + " " + numberOfWrongRows + " " + numberOfWrongColumns;
            //reset counters
            numberOfWrongColumns = 0;
            numberOfWrongRows = 0;
        }
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    /**
     * sums the diagonal values in matrix
     * @param matrix
     * @return
     */
    private static int getTraceOfMatrix(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    /**
     * [column] [rows]
     * @param rows
     * @return
     */
    private static int[][] getMatrix (String[] rows) {
        int[][] matrix = new int[rows.length][rows.length];
        for (int i = 0; i < rows.length; i++) {
            String[] cellsOfRow = rows[i].split(" ");
            for (int j = 0; j < cellsOfRow.length; j++) {
                matrix[j][i] = Integer.parseInt(cellsOfRow[j]);
            }
        }
        return matrix;
    }
    /**
     * uses Scanner to get the Input and returns it as a String list, each element in list, is one line
     * @return
     */
    private static String[][] getInput(Scanner scanner, int nummberOfTestCases) {
        String[][] matrix = new String[0][0];

        matrix = new String[nummberOfTestCases][];
        for (int caseMatrix = 0; caseMatrix < nummberOfTestCases; caseMatrix++) {

           //[#matrix][eachString element is one row]
            int sizeMatrixOfCase = Integer.parseInt(scanner.nextLine());
            String[] rows = new String[sizeMatrixOfCase];
            for (int row = 0; row < rows.length; row++) {
               rows[row] = scanner.nextLine();
            }
            matrix[caseMatrix] = rows;
        }
        return matrix;
    }
    private static int[] getRowAsIntArray(String row) {
        String[] eachNumbAsString = row.split(" ");
        int[] myArray = new int[eachNumbAsString.length];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = Integer.parseInt(eachNumbAsString[i]);
        }
        return myArray;
    }

    /**
     * returns true if one number is duplicate
     * @param row
     * @return
     */
    private static boolean findDuplicateInArray(int [] row) {
        Set<Integer> mySet = new HashSet<>();
        for (int i = 0; i < row.length; i++) {
            mySet.add(row[i]);
        }
        return mySet.size() != row.length;
    }
    private static boolean findDuplicateInArray(String row) {
        String [] eachNumber = row.split(" ");
        Set<Integer> mySet = new HashSet<>();
        for (int i = 0; i < eachNumber.length; i++) {
            mySet.add(Integer.parseInt(eachNumber[i]));
        }
        return mySet.size() != eachNumber.length;
    }
}
