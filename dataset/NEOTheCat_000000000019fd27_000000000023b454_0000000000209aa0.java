
import java.util.Scanner;

public class Solution {
    static boolean[] check;
    static boolean[][] r;
    static boolean[][] c;
    static int[][] a;
    private static String PATTEN = "Case #%d: %s";
    static boolean find;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int p = 1; p <= t; p++) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            if (n==3){
                if ((k == 5) || (k==7)){
                    System.out.println(String.format(PATTEN, p, "IMPOSSIBLE"));
                    continue;
                }
            }
            if ((k==n+1) || (k==n*n-1)){
                System.out.println(String.format(PATTEN, p, "IMPOSSIBLE"));
                continue;
            } else {
                System.out.println(String.format(PATTEN, p, "POSSIBLE"));
            }
            check = new boolean[n * n + 1];
            r = new boolean[n + 1][n + 1];
            c = new boolean[n + 1][n + 1];
            a = new int[n][n];
            find = false;
//            int x = k/n;
//            int y  =k %n;
//            for (int i =0;i<n;i++){
//                a[i][i] = x;
//            }
//            if (y!=0){
//                if (y!=1){
//                    a[n-1][n-1] = x+y-1;
//                    a[n-2][n-2] = x+1;
//                } else {
//                    a[n-1][n-1] = x+y-2;
//                    a[n-2][n-2] = x+1;
//                    a[n-3][n-3] = x+1;
//                }
//            }
//            for (int i =0;i<n;i++){
//                System.out.print(i+" "+a[i][i]);
//                r[i][a[i][i]] = true;
//                c[i][a[i][i]] = true;
//            }
            dfs(0, n,k);
        }
    }

    private static void dfs(int key, int n,int k) {
        if (key >= n * n) {
            int x= 0;
            for (int i =0;i<n;i++){
                x=x+a[i][i];
            }
            if (x != k){
                return;
            }
            for (int i=0;i<n;i++){

                for (int j =0;j<n-1;j++){
                    System.out.print(a[i][j]+" ");
                }

                System.out.println(a[i][n-1]);
            }
            find =true;
            return;
        }
        int row = key / n;
        int column = key % n;

//        if (row == column){
//            dfs(key+1,n);
//            return;
//        }
        for (int i = 1; i <= n; i++) {
            if ((!r[row][i]) && (!c[column][i])) {
                r[row][i] = true;
                c[column][i] = true;
                a[row][column] = i;
                dfs(key + 1, n,k);
                if (find){
                    return;
                }
                r[row][i] = false;
                c[column][i] = false;
            }
        }
    }
}