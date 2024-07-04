import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int q=1;q<=t;q++) {
            int n = s.nextInt();
            int k = s.nextInt();
            if (k == n+1 || k == n*n-1) {
                System.out.println("Case #" + q + ": IMPOSSIBLE");
                continue;
            }
            if (n == 3 && k!=3 && k!=6 && k!=9) {
                System.out.println("Case #" + q + ": IMPOSSIBLE");
                continue;
            }
            int [][] arr = new int [n][n];
            diagonalElements(arr,k,n,0,n);
            fillElements(arr,n);
            System.out.println("Case #" + q + ": POSSIBLE");
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++)
                    System.out.print(arr[i][j] + " ");
                System.out.println();
            }
        }
    }
    private static boolean fillElements (int [][] arr , int n){
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (arr[i][j] == 0) {
                    for (int k=1;k<=n;k++) {
                        if (isColumnSafe(arr,i,j,k,n) && isRowSafe(arr,i,j,k,n)) {
                            arr[i][j] = k;
                            if (fillElements(arr,n)) return true;
                            else arr[i][j] = 0;
                        }
                    }
                    if (arr[i][j] == 0) return false;
                }
            }
        }
        return true;
    }
    private static boolean isColumnSafe (int [][] arr , int i , int j , int x , int n) {
        for (int a=0;a<n;a++) {
            if (arr[a][j] == x)
                return false;
        }
        return true;
    }
    private static boolean isRowSafe (int [][] arr , int i , int j , int x , int n) {
        for (int a=0;a<n;a++) {
            if (arr[i][a] == x)
                return false;
        }
        return true;
    }
    private static boolean diagonalElements (int [][] arr , int k , int n , int i , int x) {
        if (i==n && k == 0) return true;
        if (i==n && k != 0) return false;
        if (i == 1 && k == n - i && x != 1) return false;
        if (k < n-i) return false;
        if (i == n-1 && x == n && k!=n) return false;
        if (i == n-1 && x == n && k==n) {
            arr[i][i] = k;
            return true;
        }
        if (i==n-1 && x!=n) {
            arr[i][i] = k;
            return true;
        }
        for (int a=x;a>=1;a--) {
            if (k > a) {
                arr[i][i] = a;
                if (!diagonalElements(arr,k-a,n,i+1,a)) {
                    arr[i][i] = 0;
                } else return true;
            }
        }
        return false;
    }
}
