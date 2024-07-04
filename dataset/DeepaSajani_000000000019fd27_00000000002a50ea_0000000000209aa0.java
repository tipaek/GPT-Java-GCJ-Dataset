import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer numberOfCases = Integer.parseInt(bufferedReader.readLine());
        for (int caseNumber = 1; caseNumber <= numberOfCases ; caseNumber++) {
            String input = bufferedReader.readLine();
            String[] inputElems = input.split(" ");
            int size = Integer.parseInt(inputElems[0]);
            int trace = Integer.parseInt(inputElems[1]);
            boolean hasSolution = diagonalElem(trace, trace, new int[size], 0, size, trace, caseNumber);
            if (!hasSolution) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static int[][] computeLatin(int size, int trace, int[] partitions) {
        int[][] matrix = new int[size][size];
        int computedTrace = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0)
                    matrix[i][j] = j + 1;
                else
                    matrix[i][j] = matrix[i - 1][(j + 1) % size];
                if (i == j) computedTrace += matrix[i][j];
            }
        }
        if (computedTrace == trace) return matrix;
        for (int partitionIndex = 0; partitionIndex < partitions.length; partitionIndex++) {
            boolean swapped = false;
            for (int row = partitionIndex; row < size; row++) {
                if (matrix[row][partitionIndex] == partitions[partitionIndex]) {
                    if (row != partitionIndex) {
                        for (int column = 0; column < size; column++) {
                            int temp = matrix[row][column];
                            matrix[row][column] = matrix[partitionIndex][column];
                            matrix[partitionIndex][column] = temp;
                        }
                    }
                    swapped = true;
                    break;
                }
            }
            if (!swapped) {
                return null;
            }
        }
        return matrix;
    }

    private static boolean diagonalElem(int chosenNumber, int remainder, int[] partitions, int index, int size, int trace, int caseNumber) {
        if (remainder == 0) {
            if (index == size) {
                int[][] solution = computeLatin(size, trace, partitions);
                if (solution != null) {
                    System.out.println("Case #" + caseNumber + ": POSSIBLE");
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            System.out.print(solution[i][j] + " ");
                        }
                        System.out.println();
                    }
                    return true;
                }
            }
            return false;
        }
        for (int nextChosenNumber = chosenNumber; nextChosenNumber >= 1; nextChosenNumber--) {
            if (nextChosenNumber <= remainder && index < size) {
                partitions[index] = nextChosenNumber;
                boolean hasSolution = diagonalElem(nextChosenNumber, remainder - nextChosenNumber, partitions, index + 1, size, trace, caseNumber);
                if (hasSolution) return true;
            }
        }
        return false;
    }
}
