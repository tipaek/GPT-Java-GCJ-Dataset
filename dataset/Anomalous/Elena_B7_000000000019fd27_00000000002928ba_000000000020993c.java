import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Matrix {

    private static Scanner scanner;

    public static void main(String[] args) {
        InputStream fromStream = System.in;
        /* Uncomment the following block to read from a file
        try (InputStream fromStream = getFromFile()) {
            readInput(fromStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    private static void readInput(InputStream fromStream) {
        scanner = new Scanner(fromStream);
        int testCasesNum = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCasesNum; i++) {
            handleTestCase(i);
        }
        scanner.close();
    }

    private static int trace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static void handleTestCase(int testId) {
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();
        }

        int tr = trace(matrix);

        int wrongRows = 0;
        int wrongColumns = 0;

        for (int i = 0; i < sizeOfMatrix; i++) {
            if (containsDuplicate(matrix[i])) {
                wrongRows++;
            }
            if (containsDuplicate(getColumn(matrix, i))) {
                wrongColumns++;
            }
        }

        System.out.printf("Case #%d: %d %d %d\n", testId, tr, wrongRows, wrongColumns);
    }

    private static boolean containsDuplicate(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int num : array) {
            if (seen[num - 1]) {
                return true;
            }
            seen[num - 1] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        return Arrays.stream(matrix)
                     .mapToInt(row -> row[colIndex])
                     .toArray();
    }

    private static InputStream getFromFile() throws IOException {
        File initialFile = new File("src/input.txt");
        return new FileInputStream(initialFile);
    }
}