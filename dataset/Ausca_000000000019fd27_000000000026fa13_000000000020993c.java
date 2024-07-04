import java.util.Scanner;
import java.io.PrintWriter;
class Vestigium {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int T = in.nextInt();
        int[] seen = new int[101];
        int CT = T;
        while (CT-->0) {
            int N = in.nextInt();
            int[][] matr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matr[i][j] = in.nextInt();
                }
            }
            int trace = 0;
            int rowRep = 0;
            int colRep = 0;
            for (int i = 0; i < N; i++) {
                trace += matr[i][i];
            }
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (seen[matr[row][col]] == sentinel) {
                        rowRep++;
                        break;
                    }
                    seen[matr[row][col]] = sentinel;
                }
                sentinel++;
            }
            for (int col = 0; col < N; col++) {
                for (int row = 0; row < N; row++) {
                    if (seen[matr[row][col]] == sentinel) {
                        colRep++;
                        break;
                    }
                    seen[matr[row][col]] = sentinel;
                }
                sentinel++;
            }
            StringBuilder str = new StringBuilder();
            str.append("Case #");
            str.append(T-CT);
            str.append(": ");
            str.append(trace + " " + rowRep + " " + colRep);
            out.println(str.toString());
        }
    }
    static int sentinel = 1;
}
