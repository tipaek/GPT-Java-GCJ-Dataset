import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
            for (int tt = 1; tt <=t; t++) {
                int N = in.nextInt();
                int mat[][] = new int[N][N];
                int dsum = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        mat[i][j] = in.nextInt();
                        if (i == j)
                            dsum += mat[i][j];
                    }
                }
                int row = 0;
                int col = 0;
                int rarr[] = new int[N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (rarr[mat[i][j] - 1] == 1) {
                            row++;
                            break;
                        } else
                            rarr[mat[i][j] - 1]++;
                    }
                    Arrays.fill(rarr, 0);
                }
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (rarr[mat[j][i] - 1] == 1) {
                            col++;
                            break;
                        } else
                            rarr[mat[j][i] - 1]++;
                    }
                    Arrays.fill(rarr, 0);
                }
                System.out.println("Case #" + t + ": " + dsum + " " + row + " " + col);
        }
    }
}
