import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int[] rowSum = new int[N];
            int[] colSum = new int[N];
            int trace = 0;
            Set<Integer> uniqueElements = new HashSet<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                    rowSum[i] += matrix[i][j];
                    colSum[j] += matrix[i][j];
                    uniqueElements.add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int expectedSum = uniqueElements.stream().mapToInt(Integer::intValue).sum();
            int rowIssues = 0, colIssues = 0;

            for (int sum : rowSum) {
                if (sum != expectedSum) {
                    rowIssues++;
                }
            }

            for (int sum : colSum) {
                if (sum != expectedSum) {
                    colIssues++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowIssues + " " + colIssues);
        }
    }
}