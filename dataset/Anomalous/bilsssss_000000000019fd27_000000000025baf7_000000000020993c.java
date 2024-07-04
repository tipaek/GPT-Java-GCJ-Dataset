import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            int sumDiagonal = 0;
            int repeatRowCount = 0;
            int repeatColumnCount = 0;

            for (int row = 0; row < matrixSize; row++) {
                String[] rowElements = scanner.nextLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();

                for (int col = 0; col < matrixSize; col++) {
                    int value = Integer.parseInt(rowElements[col]);
                    matrix[row][col] = value;

                    if (rowSet.contains(value)) {
                        repeatRowCount++;
                        break;
                    } else {
                        rowSet.add(value);
                    }
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    if (colSet.contains(matrix[row][col])) {
                        repeatColumnCount++;
                        break;
                    } else {
                        colSet.add(matrix[row][col]);
                    }
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                sumDiagonal += matrix[i][i];
            }

            System.out.println("case #" + (caseIndex + 1) + ": " + sumDiagonal + " " + repeatRowCount + " " + repeatColumnCount);
        }
        scanner.close();
    }
}