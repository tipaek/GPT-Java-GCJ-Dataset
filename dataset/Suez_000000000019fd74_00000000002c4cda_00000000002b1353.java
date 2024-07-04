import java.util.Scanner;

class Solution {
    static long[][] tab;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
//        triangle(false);

        for (int t=0; t<T; t++) {
            int N = in.nextInt();

            long sum = 0;
            boolean firstRange = N>=4 && N<8;
            boolean secondRange = N>=8;
            boolean thirdRange = N>503;
            int appendIndex = N-501;
//            System.out.println(appendIndex + " -> " + tab[appendIndex][1]);

            int size = firstRange ? N-1 : N;
            size = secondRange ? N-3 : size;
            size = Math.min(size, 500);

            int[] x = new int[size];
            int[] y = new int[size];
            for (int j=0; j<size; j++) {
                x[j] = j+1;
                y[j] = 1;

                if (firstRange) {
                    if (j==2) y[j]=2;
                    if (j>2) x[j]--;
                }
                if (secondRange) {
                    if (j==4) y[j]=2;
                    if (j>4) x[j]--;
                }
                if (thirdRange) {
                    if (j == appendIndex) y[j] = 2;
                    if (j > appendIndex) x[j]--;
                }
//                sum += tab[x[j]-1][y[j]-1];
            }
//            System.out.println(String.format("Case #%s: %s %s", t+1, size, sum));
            System.out.println(String.format("Case #%s:", t+1));
            for (int j=0; j<size; j++) {
                System.out.println(x[j] + " " + y[j]);
            }
        }
    }

    private static void triangle(boolean print) {
        int a = 1000;
        tab = new long[a][a];
        tab[0][0] = 1;
        for (int i=1; i<a; i++) {
            for (int j=0; j<=i; j++) {
                if (j==0) tab[i][j] = 1;
                else if (j==i) tab[i][j] = 1;
                else tab[i][j] = tab[i-1][j-1] + tab[i-1][j];
            }
        }

        if (print) {
            for (int i = 0; i < a; i++) {
                System.out.print("Index " + i + ": ");
                for (int j = 0; j <= i; j++) {
                    System.out.print(tab[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
