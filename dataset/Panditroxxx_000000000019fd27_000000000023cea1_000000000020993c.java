import java.util.*;
class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int x = 0; x < T; x++) {
            int N = sc.nextInt();
            int[][] A = new int[N][N];
            int k=0;r=0;c=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = sc.nextInt();
                    if (i == j)
                        k += A[i][j];
                }
            }
            r = countRow(A, N);
            c = countCol(A, N);
            System.out.println("Case #"+(t+1)+": "+k+" "+r+" "+c);
        }
        
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