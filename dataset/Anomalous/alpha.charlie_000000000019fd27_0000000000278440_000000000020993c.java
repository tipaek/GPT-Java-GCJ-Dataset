import java.util.Hashtable;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int z = 1; z <= T; z++) {
            int size = sc.nextInt();
            int[][] mat = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int traceValue = calculateTrace(mat, size);
            int rowDuplicates = countRowDuplicates(mat, size);
            int colDuplicates = countColDuplicates(mat, size);

            System.out.println("Case #" + z + ": " + traceValue + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    public static int calculateTrace(int[][] matrix, int size) {
        int traceSum = 0;
        for (int i = 0; i < size; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    public static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            Hashtable<Integer, Integer> rowElements = new Hashtable<>();
            for (int j = 0; j < size; j++) {
                if (rowElements.containsKey(matrix[i][j])) {
                    duplicateCount++;
                    break;
                } else {
                    rowElements.put(matrix[i][j], 1);
                }
            }
        }
        return duplicateCount;
    }

    public static int countColDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            Hashtable<Integer, Integer> colElements = new Hashtable<>();
            for (int j = 0; j < size; j++) {
                if (colElements.containsKey(matrix[j][i])) {
                    duplicateCount++;
                    break;
                } else {
                    colElements.put(matrix[j][i], 1);
                }
            }
        }
        return duplicateCount;
    }
}