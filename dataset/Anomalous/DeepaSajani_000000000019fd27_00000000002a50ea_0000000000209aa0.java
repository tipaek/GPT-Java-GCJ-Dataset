import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String[] inputs = reader.readLine().split(" ");
            int size = Integer.parseInt(inputs[0]);
            int trace = Integer.parseInt(inputs[1]);

            if (!findSolution(trace, trace, new int[size], 0, size, trace, caseNumber)) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static int[][] generateLatinSquare(int size, int trace, int[] partitions) {
        int[][] matrix = new int[size][size];
        int computedTrace = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i + j) % size + 1;
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

            if (!swapped) return null;
        }

        return matrix;
    }

    private static boolean findSolution(int chosenNumber, int remainder, int[] partitions, int index, int size, int trace, int caseNumber) {
        if (remainder == 0) {
            if (index == size) {
                int[][] solution = generateLatinSquare(size, trace, partitions);
                if (solution != null) {
                    System.out.println("Case #" + caseNumber + ": POSSIBLE");
                    for (int[] row : solution) {
                        for (int elem : row) {
                            System.out.print(elem + " ");
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
                if (findSolution(nextChosenNumber, remainder - nextChosenNumber, partitions, index + 1, size, trace, caseNumber)) {
                    return true;
                }
            }
        }

        return false;
    }
}