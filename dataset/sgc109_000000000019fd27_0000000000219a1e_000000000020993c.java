import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int N = scanner.nextInt();

            int[][] matrix = new int[N][N];
            boolean[] chk = new boolean[N + 1];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int cntCols = 0;
            for(int i = 0; i < N; i++) {
                Arrays.fill(chk, false);
                for(int j = 0; j < N; j++) {
                    if(chk[matrix[j][i]]) {
                        cntCols++;
                        break;
                    }

                    chk[matrix[j][i]] = true;
                }
            }

            int cntRows = 0;
            for(int i = 0; i < N; i++) {
                Arrays.fill(chk, false);
                for(int j = 0; j < N; j++) {
                    if(chk[matrix[i][j]]) {
                        cntRows++;
                        break;
                    }

                    chk[matrix[i][j]] = true;
                }
            }

            int trace = 0;
            for(int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            System.out.println("Case #" + tc + ": " + trace + " " + cntRows + " " + cntCols);
        }
    }
}
