import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t=0; t<T; t++) {
            int N = in.nextInt();

            int size = N>=4 ? N-1 : N;
            int[] x = new int[size];
            int[] y = new int[size];
            for (int j=0; j<size; j++) {
                x[j] = j+1;
                y[j] = 1;
                if (N>=4 && j==2) {
                    y[j] = 2;
                }
            }
            System.out.println(String.format("Case #%s:", t+1));
            for (int j=0; j<size; j++) {
                System.out.println(x[j] + " " + y[j]);
            }
        }
    }

    private static void triangle() {
        int a = 100;
        long[][] tab = new long[a][a];
        tab[0][0] = 1;
        for (int i=1; i<a; i++) {
            for (int j=0; j<=i; j++) {
                if (j==0) tab[i][j] = 1;
                else if (j==i) tab[i][j] = 1;
                else tab[i][j] = tab[i-1][j-1] + tab[i-1][j];
            }
        }

        for (int i=0; i<a; i++) {
            for (int j = 0; j<=i; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }
}
