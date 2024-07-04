import java.util.Scanner;

class Solution {

    public static int countRows(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int countCols(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + countRows(matrix, size) + " " + countCols(matrix, size));
            caseNumber++;
        }

        scanner.close();
    }
}