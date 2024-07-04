
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GoogleJam1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();

        for (int i = 0; i < numberOfTestCases; i++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            findTrace(i+1, matrix, N);
        }
    }

    private static void findTrace(int t, int[][] matrix, int n) {
        int diagonalSum = 0;

        int rowDupCount = 0;
        int colDupCount = 0;

        for (int i = 0; i < n; i++) {
            diagonalSum += matrix[i][i];
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if(rowSet.contains(matrix[i][j])) {
                    rowDupCount++;
                    break;
                }
                rowSet.add(matrix[i][j]);
            }

            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if(colSet.contains(matrix[j][i])) {
                    colDupCount++;
                    break;
                }
                colSet.add(matrix[j][i]);
            }
        }

        System.out.println("Case #"+t+": "+diagonalSum+" "+rowDupCount+" "+colDupCount);
    }
}