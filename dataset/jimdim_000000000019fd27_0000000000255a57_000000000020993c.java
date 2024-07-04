import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int testCase = 0; testCase < T; testCase++) {

            int N  = scanner.nextInt();

            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int sumOfDiagonal = 0;

            for (int i = 0; i < N; i++) {
                sumOfDiagonal += matrix[i][i];
            }

            int sameElRow = 0, sameElCol = 0;

            int[] sameElements;
            for (int i = 0; i < N; i++) {
                sameElements = new int[N];
                for (int j = 0; j < N; j++) {
                    sameElements[matrix[i][j] - 1]++;
                }
                for (int j = 0; j < N; j++) {
                    if (sameElements[j] >= 2){
                        sameElRow++;
                        break;
                    }
                }
            }


            for (int i = 0; i < N; i++) {
                sameElements = new int[N];
                for (int j = 0; j < N; j++) {
                    sameElements[matrix[j][i] - 1]++;
                }
                for (int j = 0; j < N; j++) {
                    if (sameElements[j] >= 2){
                        sameElCol++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", testCase + 1, sumOfDiagonal, sameElRow, sameElCol);
        }
    }
}
