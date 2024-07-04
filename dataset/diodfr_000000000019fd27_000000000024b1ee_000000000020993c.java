import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;



    public class Solution {
        public static void main(String[] args) {
            try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
                int T = in.nextInt();
                in.nextLine();


                for (int t = 1; t <= T; ++t) {
                    int N = Integer.valueOf(in.nextLine());
                    int[][] matrice = new int[N][N];

                    for (int i = 0; i < N; i++) {
                        String[] ligne = in.nextLine().split(" ");
                        for (int j = 0; j < N; j++) {
                            matrice[i][j] = Integer.parseInt(ligne[j]);
                        }
                    }

                    int sommeDiag = 0;

                    for (int i = 0; i < N; i++) {
                        sommeDiag += matrice[i][i];
                    }

                    int col = 0;
                    for (int i = 0; i < N; i++) {
                        int[] values = new int[N];
                        for (int j = 0; j < N; j++) {
                            values[matrice[i][j]-1] ++;
                        }
                        col = Math.max(col, almostMax(values));
                    }

                    int ligne = 0;
                    for (int i = 0; i < N; i++) {
                        int[] values = new int[N];
                        for (int j = 0; j < N; j++) {
                            values[matrice[j][i]-1] ++;
                        }
                        ligne = Math.max(ligne, almostMax(values));
                    }


                    System.out.println("Case #" + t + ": " + sommeDiag + " " + col + " " + ligne);
                }
            }
        }

    private static int almostMax(int[] values) {
            int max = 0;
            for (int i = 0; i < values.length; i++) {
                max = Math.max(max,values[i]);
            }
            return max == 1? 0 : max;
    }


}
