import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseSetSize = Integer.parseInt(scanner.nextLine().trim());

        for (int testCaseNumber = 1; testCaseNumber <= testCaseSetSize; testCaseNumber++) {
            String digits = scanner.nextLine().trim();
            int closingParenthesisNum = 0;
            StringBuilder result = new StringBuilder();

            for (char c : digits.toCharArray()) {
                int digit = Character.getNumericValue(c);

                while (closingParenthesisNum > digit) {
                    result.append(')');
                    closingParenthesisNum--;
                }

                while (closingParenthesisNum < digit) {
                    result.append('(');
                    closingParenthesisNum++;
                }

                result.append(c);
            }

            while (closingParenthesisNum > 0) {
                result.append(')');
                closingParenthesisNum--;
            }

            System.out.println("Case #" + testCaseNumber + ": " + result);
        }
    }

    private static void showRepeatedNumbers(int matrixSize, int[][] matrix) {
        int rowWithRepeatedNumbers = 0;

        for (int rowNumber = 0; rowNumber < matrixSize; rowNumber++) {
            Set<Integer> uniqueNumbers = Arrays.stream(matrix[rowNumber]).boxed().collect(Collectors.toSet());
            if (matrixSize != uniqueNumbers.size()) {
                rowWithRepeatedNumbers++;
            }
        }

        System.out.print(" " + rowWithRepeatedNumbers);
    }

    private static int[][] transpose(int[][] matrix) {
        int size = matrix.length;
        int[][] transposedMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }
}