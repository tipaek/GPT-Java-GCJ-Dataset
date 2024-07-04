import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTestCases = scanner.nextInt();

        for (int i = 0; i < numOfTestCases; i++) {
            int matrixSize = scanner.nextInt();
            int trace = scanner.nextInt();
            new Solution().generateMatrix(i + 1, matrixSize, trace);
        }
    }

    public void generateMatrix(int testCaseNumber, int matrixSize, int trace) {
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> traceValues = new ArrayList<>();
        boolean isImpossible = false;

        if (trace < matrixSize) {
            isImpossible = true;
        } else if (trace % matrixSize == 0) {
            int quotient = trace / matrixSize;
            for (int i = 0; i < matrixSize; i++) {
                traceValues.add(quotient);
            }
        } else {
            int sum = 0;
            for (int i = 1; sum < trace; i++) {
                sum += i;
                traceValues.add(i);
                if (sum == trace) {
                    break;
                }
            }

            if (traceValues.size() < matrixSize) {
                int difference = matrixSize - traceValues.size();
                for (int i = difference; i >= 0; i--) {
                    int value = traceValues.remove(i);
                    traceValues.add(value / 2);
                    traceValues.add(value / 2);
                }
            } else if (traceValues.size() > matrixSize) {
                int difference = traceValues.size() - matrixSize;
                for (int i = 0; i <= matrixSize; i += 2) {
                    int value1 = traceValues.remove(i);
                    int value2 = traceValues.remove(i + 1);
                    traceValues.add(value1 + value2);
                }
            }
        }

        if (isImpossible) {
            System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
            return;
        }
        System.out.println("Case #" + testCaseNumber + ": POSSIBLE");

        for (int i = 1; i <= matrixSize; i++) {
            values.add(i);
        }

        int[][] matrix = new int[matrixSize][matrixSize];
        int traceIndex = 0;

        for (int row = 0; row < matrixSize; row++) {
            int valueIndex = 0;
            int diagonalValue = traceValues.get(traceIndex);

            for (int col = 0; col < matrixSize; col++) {
                if (row == col) {
                    matrix[row][col] = diagonalValue;
                    traceIndex++;
                } else {
                    int currentValue = values.get(valueIndex);
                    if (currentValue == diagonalValue) {
                        valueIndex++;
                        currentValue = values.get(valueIndex);
                    }
                    matrix[row][col] = currentValue;
                    valueIndex++;
                }
                System.out.print(matrix[row][col] + " ");
            }

            int firstValue = values.remove(0);
            if (traceIndex < traceValues.size() && firstValue == traceValues.get(traceIndex)) {
                values.add(firstValue);
                firstValue = values.remove(0);
            }
            values.add(firstValue);
            System.out.println();
        }
    }
}