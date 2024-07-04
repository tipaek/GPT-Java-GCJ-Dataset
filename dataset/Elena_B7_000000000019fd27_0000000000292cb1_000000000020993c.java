import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStream;
import java.io.File;
import java.io. FileInputStream;
import java.io.IOException;

public class Solution {

    public static Scanner scanner;

    public static void main(String[] args) {
        InputStream fromStream = System.in;
        readInput(fromStream);
       /* try (InputStream fromStream = getFromFile()) {
            readInput(fromStream);
        } catch (IOException e){
            e.printStackTrace();
        }*/
    }

    public static void readInput(InputStream fromStream) {
        scanner = new Scanner(fromStream);
        int testCasesNum = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCasesNum; i++) {
            handleTestCase(i);
        }

        scanner.close();
    }


    public static int trace(int matrix[][]) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void handleTestCase(int testId){
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        }

        //printMatrix(matrix);
        int tr = trace( matrix);
       // System.out.println("trace="+tr);

        int wrongRows = 0;
        int wrongColumns = 0;
        boolean[] rowNums = new boolean[sizeOfMatrix];
        boolean[] colNums = new boolean[sizeOfMatrix];
        boolean isWrongRow = false;
        boolean isWrongCol = false;
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                if(rowNums[matrix[i][j]-1]){ // wrong row
                    isWrongRow = true;
                }
                rowNums[matrix[i][j]-1] = true;

                if(colNums[matrix[j][i]-1]){ // wrong col
                    isWrongCol = true;
                }
                colNums[matrix[j][i]-1] = true;
            }
            if(isWrongRow) wrongRows++;
            if(isWrongCol) wrongColumns++;
            // clear
            rowNums = new boolean[sizeOfMatrix];
            colNums = new boolean[sizeOfMatrix];
            isWrongRow = false;
            isWrongCol = false;
        }
        // output test case
        /*
         Case #x: k r c, where x is the test case number (starting from 1),
         k is the trace of the matrix,
         r is the number of rows of the matrix that contain repeated elements,
         and c is the number of columns of the matrix that contain repeated elements.
         */
        System.out.printf("Case #%d: %d %d %d\n", testId, tr, wrongRows, wrongColumns);
    }

    public static InputStream getFromFile() throws IOException{
        File initialFile = new File("src/input.txt");
        InputStream targetStream = new FileInputStream(initialFile);
        return targetStream;
    }
}
