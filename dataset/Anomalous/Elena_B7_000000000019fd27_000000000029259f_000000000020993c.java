import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Task1 {

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
        readInput(fromStream);
    }

    private static void readInput(InputStream fromStream) {
        scanner = new Scanner(fromStream);
        int testCasesNum = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCasesNum; i++) {
            handleTestCase(i);
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

    private static void handleTestCase(int testId) {
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();
        }

        int trace = calculateTrace(matrix);
        int wrongRows = 0, wrongColumns = 0;
        boolean[] rowNums = new boolean[sizeOfMatrix];
        boolean[] colNums = new boolean[sizeOfMatrix];

        for (int i = 0; i < sizeOfMatrix; i++) {
            boolean isWrongRow = false, isWrongCol = false;
            Arrays.fill(rowNums, false);
            Arrays.fill(colNums, false);

            for (int j = 0; j < sizeOfMatrix; j++) {
                if (rowNums[matrix[i][j] - 1]) {
                    isWrongRow = true;
                }
                rowNums[matrix[i][j] - 1] = true;

                if (colNums[matrix[j][i] - 1]) {
                    isWrongCol = true;
                }
                colNums[matrix[j][i] - 1] = true;
            }

            if (isWrongRow) wrongRows++;
            if (isWrongCol) wrongColumns++;
        }

        System.out.printf("Case #%d: %d %d %d%n", testId, trace, wrongRows, wrongColumns);
    }

    private static InputStream getFromFile() throws IOException {
        File initialFile = new File("src/input.txt");
        return new FileInputStream(initialFile);
    }
}