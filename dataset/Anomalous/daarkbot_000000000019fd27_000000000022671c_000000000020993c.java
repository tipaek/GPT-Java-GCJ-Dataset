import java.util.*;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int caseNumber = 1;

        while (T-- > 0) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int[] rowSum = new int[N];
            int[] colSum = new int[N];
            int trace = 0;
            Set<Integer> uniqueElements = new HashSet<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSum[i] += matrix[i][j];
                    colSum[j] += matrix[i][j];
                    uniqueElements.add(matrix[i][j]);
                }
            }

            int uniqueSum = uniqueElements.stream().mapToInt(Integer::intValue).sum();
            int rowCount = 0;
            int colCount = 0;

            for (int sum : rowSum) {
                if (sum != uniqueSum) {
                    rowCount++;
                }
            }

            for (int sum : colSum) {
                if (sum != uniqueSum) {
                    colCount++;
                }
            }

            System.out.println("#" + caseNumber + ": " + trace + " " + rowCount + " " + colCount);
            caseNumber++;
        }
    }
}