import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

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

    public static  int[][] findSolution(int sizeOfMatrix, int trace) {
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

        // permute
      //  for (int k = 0; k < sizeOfMatrix; k++) {

            for(int i = 0; i < sizeOfMatrix; i++) {
                for(int j = 0; j < sizeOfMatrix; j++) {
                    matrix[i][j]=((i + 1) + j) % sizeOfMatrix;
                    if (matrix[i][j] == 0) matrix[i][j] = sizeOfMatrix;
                }
            }
      //  }

        // verify trace
        if(trace(matrix) == trace) {
            return matrix;
        } else return null;
    }
    public static void handleTestCase(int testId){
        String[] arr = scanner.nextLine().split(" ");
        int sizeOfMatrix = Integer.parseInt(arr[0]);
        int trace = Integer.parseInt(arr[1]);

        int[][] matrix = findSolution(sizeOfMatrix, trace);
        // output test case
        if(matrix != null){
            System.out.printf("Case #%d: POSSIBLE\n", testId);
            printMatrix(matrix);
        }   else {
            System.out.printf("Case #%d: IMPOSSIBLE\n", testId);
        }
    }


    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


    public static InputStream getFromFile() throws IOException{
        File initialFile = new File("src/input5.txt");
        InputStream targetStream = new FileInputStream(initialFile);
        return targetStream;
    }
}
