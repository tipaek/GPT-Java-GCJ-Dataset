import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();
        for (int i = 1; i <= T; i++) {
            int N = readInt();
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                matrix[j] = readIntArray(N);
            }
            Result result = analyzeMatrix(i, N, matrix);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    private static int[] readIntArray(int n) throws IOException {
        int[] array = new int[n];
        Scanner scanner = new Scanner(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static Result analyzeMatrix(int caseNumber, int size, int[][] matrix) {
        int trace = calculateTrace(size, matrix);
        int rowDuplicates = countRowDuplicates(size, matrix);
        int colDuplicates = countColDuplicates(size, matrix);
        return new Result(caseNumber, trace, rowDuplicates, colDuplicates);
    }

    private static int calculateTrace(int size, int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countRowDuplicates(int size, int[][] matrix) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (containsDuplicates(size, matrix, i, 0, 0, 1)) {
                count++;
            }
        }
        return count;
    }

    private static int countColDuplicates(int size, int[][] matrix) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (containsDuplicates(size, matrix, 0, i, 1, 0)) {
                count++;
            }
        }
        return count;
    }

    private static boolean containsDuplicates(int size, int[][] matrix, int row, int col, int rowIncrement, int colIncrement) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int i = 0; i < size; i++) {
            uniqueElements.add(matrix[row][col]);
            row += rowIncrement;
            col += colIncrement;
        }
        return uniqueElements.size() < size;
    }

    static class Result {
        int caseNumber, trace, rowDuplicates, colDuplicates;

        Result(int caseNumber, int trace, int rowDuplicates, int colDuplicates) {
            this.caseNumber = caseNumber;
            this.trace = trace;
            this.rowDuplicates = rowDuplicates;
            this.colDuplicates = colDuplicates;
        }

        @Override
        public String toString() {
            return String.format("Case #%d: %d %d %d", caseNumber, trace, rowDuplicates, colDuplicates);
        }
    }
}