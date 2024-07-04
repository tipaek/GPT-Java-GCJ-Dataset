import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            processTestCase(scanner);
            System.out.println();
        }
        scanner.close();
    }

    static void processTestCase(Scanner scanner) {
        int size = scanner.nextInt();
        int rowRepeats = 0;
        int columnRepeats = 0;
        int diagonalSum = 0;
        int[] tempArray = new int[size];
        int[][] matrix = new int[size][size];

        // Read the matrix and calculate diagonal sum
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
            }
        }

        // Check for repeated elements in rows
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tempArray[j] = matrix[i][j];
            }
            Arrays.sort(tempArray);
            for (int j = 0; j < size - 1; j++) {
                if (tempArray[j] == tempArray[j + 1]) {
                    rowRepeats++;
                    break;
                }
            }
        }

        // Check for repeated elements in columns
        for (int i = 0; i < size; i++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!columnSet.add(matrix[j][i])) {
                    columnRepeats++;
                    break;
                }
            }
        }

        // Output the results
        System.out.print(diagonalSum + " " + rowRepeats + " " + columnRepeats);
    }
}