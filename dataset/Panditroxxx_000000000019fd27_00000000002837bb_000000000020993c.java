import java.util.*;
class Solution{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        for(int x=1;x<=T;x++){
            int N = sc.nextInt();
            int[][] M = new int[N][N];

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            int k,r,c;
            k = trace(M,N);
            r = countRow(M, N);
            c = countCol(M, N);
            System.out.println("Case #" + x + ": " + k + " " + r + " "+ c);
        }

    }
    public static int trace(int[][] a,int n){
        int count=0;
     for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i == j)
                    count += a[i][j];

                return count;
    }

    public static int countRow(int[][] a, int n) {
        int count = 0;
        
        for (int i = 0; i < n; i++){
            boolean flag = false;
            for (int j = 0; j < n; j++){
                for (int s = j + 1; s < n; s++) {
                    if (a[i][j] == a[i][s]) {
                        count++;
                        // System.out.print(i + " ");
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    break;
            }
        }
        return count;
    }

    public static int countCol(int[][] a, int n) {
        int count = 0;
        for (int i = 0; i < n; i++){
            boolean flag = false;
            for (int j = 0; j < n; j++){
                for (int s = j + 1; s < n; s++) {
                    if (a[j][i] == a[s][i]) {
                        count++;
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
        }
        return count;
    }
}
