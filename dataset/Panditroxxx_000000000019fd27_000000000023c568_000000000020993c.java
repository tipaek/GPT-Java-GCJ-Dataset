import java.util.*;
public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] k = new int[T];
        int[] r = new int[T];
        int[] c = new int[T];
        for (int x = 0; x < T; x++) {
            int N = sc.nextInt();
            int[][] A = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = sc.nextInt();
                    if (i == j)
                        k[x] += A[i][j];
                }
            }
            r[x] = countRow(A, N);
            c[x] = countCol(A, N);
        }
        for(int x=0;x<T;x++)
        System.out.println("Case #"+(x+1)+": "+k[x]+" "+r[x]+" "+c[x]);
    }

    public static int countRow(int[][] a, int n) {
        int r = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++){
                for (int s = j + 1; s < n; s++) {
                    if (a[i][j] == a[i][s]) {
                        r++;
                        flag = false;
                        break;
                    }
                }

                    if (!flag)
                        break;
                }
        return r;
    }

    public static int countCol(int[][] a, int n) {
        int c = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++){
                for (int s = j + 1; s < n; s++) {
                    if (a[j][i] == a[s][i]) {
                        c++;
                        flag = false;
                        break;
                    }
                }

                    if (!flag)
                        break;
                }
        return c;
        }
}