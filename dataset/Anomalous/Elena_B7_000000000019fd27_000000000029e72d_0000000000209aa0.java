import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        processInput(inputStream);
        /* Uncomment to read from a file
        try (InputStream inputStream = getFileInputStream()) {
            processInput(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    private static void processInput(InputStream inputStream) {
        scanner = new Scanner(inputStream);
        int testCasesCount = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCasesCount; i++) {
            processTestCase(i);
        }
        scanner.close();
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix(int size, int targetTrace) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = ((i + 1) + j) % size;
                if (matrix[i][j] == 0) matrix[i][j] = size;
            }
        }
        return calculateTrace(matrix) == targetTrace ? matrix : null;
    }

    private static void processTestCase(int testId) {
        String[] input = scanner.nextLine().split(" ");
        int matrixSize = Integer.parseInt(input[0]);
        int traceValue = Integer.parseInt(input[1]);

        int[][] matrix = generateMatrix(matrixSize, traceValue);
        if (matrix != null) {
            System.out.printf("Case #%d: POSSIBLE\n", testId);
            displayMatrix(matrix);
        } else {
            System.out.printf("Case #%d: IMPOSSIBLE\n", testId);
        }
    }

    private static void permute(String str, int left, int right) {
        if (left == right) {
            System.out.println(str);
        } else {
            for (int i = left; i <= right; i++) {
                str = swapCharacters(str, left, i);
                permute(str, left + 1, right);
                str = swapCharacters(str, left, i);
            }
        }
    }

    private static String swapCharacters(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }

    private static InputStream getFileInputStream() throws IOException {
        File file = new File("src/input5.txt");
        return new FileInputStream(file);
    }
}