import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int[] rowSums = new int[N];
            int[] colSums = new int[N];
            int traceSum = 0;
            Set<Integer> uniqueElements = new HashSet<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                    uniqueElements.add(matrix[i][j]);
                    rowSums[i] += matrix[i][j];
                    colSums[j] += matrix[i][j];
                    if (i == j) {
                        traceSum += matrix[i][j];
                    }
                }
            }

            int uniqueSum = uniqueElements.stream().mapToInt(Integer::intValue).sum();
            int rowCount = 0;
            int colCount = 0;

            for (int i = 0; i < N; i++) {
                if (rowSums[i] != uniqueSum) rowCount++;
                if (colSums[i] != uniqueSum) colCount++;
            }

            System.out.println("#" + testCase + ": " + traceSum + " " + rowCount + " " + colCount);
        }
        
        sc.close();
    }
}