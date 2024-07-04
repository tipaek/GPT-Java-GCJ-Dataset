import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static int countIdenticalRows(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (uniqueElements.contains(matrix[i][j])) {
                    count++;
                    break;
                }
                uniqueElements.add(matrix[i][j]);
            }
        }
        return count;
    }

    static int findTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    static void transposeMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int size = scanner.nextInt();
            scanner.nextLine();
            int[][] matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }
            int trace = findTrace(matrix, size);
            int identicalRows = countIdenticalRows(matrix, size);
            transposeMatrix(matrix, size);
            int identicalColumns = countIdenticalRows(matrix, size);
            System.out.println("Case #" + caseNum + ": " + trace + " " + identicalRows + " " + identicalColumns);
        }
        scanner.close();
    }
}