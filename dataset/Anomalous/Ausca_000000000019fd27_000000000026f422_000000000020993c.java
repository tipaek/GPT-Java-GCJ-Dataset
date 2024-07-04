import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] seen = new int[101];
        int caseNumber = 1;
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int trace = 0;
            int rowRep = 0;
            int colRep = 0;

            // Calculate trace
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            // Calculate row repetitions
            int sentinel = 1;
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (seen[matrix[row][col]] == sentinel) {
                        rowRep++;
                        break;
                    }
                    seen[matrix[row][col]] = sentinel;
                }
                sentinel++;
            }

            // Calculate column repetitions
            for (int col = 0; col < N; col++) {
                for (int row = 0; row < N; row++) {
                    if (seen[matrix[row][col]] == sentinel) {
                        colRep++;
                        break;
                    }
                    seen[matrix[row][col]] = sentinel;
                }
                sentinel++;
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRep + " " + colRep);
            caseNumber++;
        }
        scanner.close();
    }
}