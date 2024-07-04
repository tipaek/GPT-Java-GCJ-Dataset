import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCaseSetSize = Integer.parseInt(scanner.nextLine().trim());
        for (int testCaseNumber = 1; testCaseNumber <= testCaseSetSize; testCaseNumber++) {
            int matrixSize = Integer.parseInt(scanner.nextLine().trim());

            int[][] matrix = new int[matrixSize][matrixSize];

            int trace = 0;

            for (int rowNumber = 0; rowNumber < matrixSize; rowNumber++) {
                String[] strings = scanner.nextLine().trim().split(" ");
                matrix[rowNumber] = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

                trace += matrix[rowNumber][rowNumber];
            }

            System.out.print("Case #" + testCaseNumber + ": " + trace);



            showRepeactedNumbers(matrixSize, matrix);

            matrix = transpose(matrix);

            showRepeactedNumbers(matrixSize, matrix);

            System.out.println();

        }

    }

    private static void showRepeactedNumbers(int matrixSize, int[][] matrix) {
        int rowWithRepeatedNumbers = 0;
        for (int rowNumber = 0; rowNumber < matrixSize; rowNumber++) {
            Set<Integer> uniqueNumbers = Arrays.stream(matrix[rowNumber]).boxed().collect(Collectors.toSet());
            if (matrixSize != uniqueNumbers.size()) {
                rowWithRepeatedNumbers++;
            }

        }

        System.out.print(" " + rowWithRepeatedNumbers);
    }

    private static int[][] transpose(int[][] matrix){
        int m = matrix.length;
        int[][] ret = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                ret[j][i] = matrix[i][j];
            }
        }

        return ret;
    }
}
