import java.util.*;
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int x=1;
        while(x<=T){
            int N = sc.nextInt();
            int[][] M = new int[N][N];
            int k=0,r=0,c=0;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                    if (i == j)
                        k += M[i][j];
                }
            r = countRow(M, N);
            c = countCol(M, N);
            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
        }
        x++;

    }

    public static int countRow(int[][] a, int n) {
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++){
                for (int s = j + 1; s < n; s++) {
                    if (a[i][j] == a[i][s]) {
                        count++;
                        flag = false;
                        break;
                    }
                }

                if (!flag)
                    break;
            }
        return count;
    }

    public static int countCol(int[][] a, int n) {
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++){
                for (int s = j + 1; s < n; s++) {
                    if (a[j][i] == a[s][i]) {
                        count++;
                        flag = false;
                        break;
                    }
                }

                if (!flag)
                    break;
            }
        return count;
    }
}