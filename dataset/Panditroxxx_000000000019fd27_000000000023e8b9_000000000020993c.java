import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int x = 1; x <= T; x++) {
            int N = sc.nextInt();
            int[][] M = new int[N][N];
            int k=0,r=0,c=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                    if (i == j)
                        k += M[i][j];
                }
            }
            r = countRow(M, N);
            c = countCol(M, N);
            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
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