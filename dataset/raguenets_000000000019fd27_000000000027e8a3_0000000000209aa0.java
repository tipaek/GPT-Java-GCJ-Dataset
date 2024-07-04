import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    public static void main(String[] args) {

        int M = 10;
        int[] a = new int[M];
        for (int i=0; i < a.length; i++) a[i] = i;
        int[] S = new int[M];
        for (int i=0; i < a.length; i++) a[i] = ThreadLocalRandom.current().nextInt(M);

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[][] square2x2 = new int[][]{{1, 2}, {2, 1}};
        int[][] square3x3 = new int[][]{{2, 1, 3}, {3, 2, 1}, {1, 3, 2}};
        int[][] square4x4 = new int[][]{{3, 1, 2, 4}, {1, 4, 3, 2}, {2, 3, 4, 1}, {4, 2, 1, 3}};
        int[][] square5x5 = new int[][]{{3, 1, 2, 4, 5}, {4, 2, 5, 3, 1}, {1, 3, 4, 5, 2}, {2, 5, 3, 1, 4}, {5, 4, 1, 2, 3}};
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] square;
            if (N == 2) {
                square = (int[][]) square2x2.clone();
            } else if (N == 3) {
                square = (int[][]) square3x3.clone();
            } else if (N == 4) {
                square = (int[][]) square4x4.clone();
            } else {
                square = (int[][]) square5x5.clone();
            }
            checkSquare(square,t,K);
        }
    }

    public static void checkSquare(int[][] square, int t, int K) {
        int N = square.length;
        for (int i=0; i < 100000; i++) {
            int r = ThreadLocalRandom.current().nextInt(3);
            int i1 = ThreadLocalRandom.current().nextInt(square.length);
            int i2 = ThreadLocalRandom.current().nextInt(square.length);;
            while (i2 == i1) {
                i2 = ThreadLocalRandom.current().nextInt(square.length);
            }
            if (r ==0) {
                permuteRows(square, i1,i2);
                if (trace(square) == K) {
                    System.out.println("Case #" + t + ": POSSIBLE");
                    for (int ii = 0; ii < square.length; ii++) {
                        for (int jj = 0; jj < square.length; jj++) {
                            System.out.print(square[ii][jj]+" ");
                        }
                        System.out.println();
                    }
                    return;
                }
            } else if (r==1) {
                permuteColumns(square, i1,i2);
                if (trace(square) == K) {
                    System.out.println("Case #" + t + ": POSSIBLE");
                    for (int ii = 0; ii < square.length; ii++) {
                        for (int jj = 0; jj < square.length; jj++) {
                            System.out.print(square[ii][jj]+" ");
                        }
                        System.out.println();
                    }
                    return;
                }
            } else {
                int[] a = new int[square.length];
                for (int ii=0; ii < a.length;ii++) a[ii] = ii+1;
                for (int ii=0; ii < 2*a.length; ii++) {
                    int id1 = ThreadLocalRandom.current().nextInt(square.length);
                    int id2 = ThreadLocalRandom.current().nextInt(square.length);;
                    while (id2 == id1) {
                        id2 = ThreadLocalRandom.current().nextInt(square.length);
                    }
                    int tmp = a[id1];
                    a[id1] = a[id2];
                    a[id2] = tmp;
                }
                for (int ii=0; ii < square.length; ii++) {
                    for (int jj=0; jj < square.length; jj++) {
                        square[ii][jj] = a[square[ii][jj]-1];
                    }
                }
                if (trace(square) == K) {
                    System.out.println("Case #" + t + ": POSSIBLE");
                    for (int ii = 0; ii < square.length; ii++) {
                        for (int jj = 0; jj < square.length; jj++) {
                            System.out.print(square[ii][jj]+" ");
                        }
                        System.out.println();
                    }
                    return;
                }
            }
        }
        System.out.println("Case #" + t + ": IMPOSSIBLE");
    }

    public static int trace(int[][] square) {
        int trace = 0;
        for (int i=0; i < square.length; i++) {
            trace += square[i][i];
        }
        return trace;
    }

    public static void permuteRows(int[][] square, int r1, int r2) {
        int N = square.length;
        for (int i = 0; i<N; i++){
            int tmp = square[r2][i];
            square[r2][i] = square[r1][i];
            square[r1][i] = tmp;
        }
    }

    public static void permuteColumns(int[][] square, int c1, int c2) {
        int N = square.length;
        for (int i = 0; i<N; i++){
            int tmp = square[i][c1];
            square[i][c1] = square[i][c2];
            square[i][c2] = tmp;
        }
    }

}