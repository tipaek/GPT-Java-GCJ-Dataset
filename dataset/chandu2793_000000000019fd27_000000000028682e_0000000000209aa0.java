import java.util.Scanner;

public class Solution {

    private static int computeTraceSum(int[][] a) {
        int n = a.length;
        int k = 0;
        for(int i=0; i<n; i++) {
            k += a[i][i];
        }
        return k;
    }


    private static void swapRows(int[][] a, int i, int j) {
        int n = a.length;
        int temp[] = new int[n];
        for(int x=0; x<n; x++) {
            temp[x] = a[i][x];
        }
        for(int x=0; x<n; x++) {
            a[i][x] = a[j][x];
        }
        for(int x=0; x<n; x++) {
            a[j][x] = temp[x];
        }
    }

    private static void swapCols(int[][] a, int i, int j) {
        int n = a.length;
        int temp[] = new int[n];
        for (int x=0; x<n; x++) {
            temp[x] = a[x][i];
        }
        for (int x=0; x<n; x++) {
            a[x][i] = a[x][j];
        }
        for (int x=0; x<n; x++) {
            a[x][j] = temp[x];
        }
    }

    private static boolean findTrace(int[][] a, int l, int r, int k, int[][] res) {
        if (l == r) {
            if(computeTraceSum(a) == k) {
                int n = a.length;
                for (int i=0; i<n; i++) {
                    for (int j=0; j<n; j++) {
                        res[i][j] = a[i][j];
                    }
                }
                return true;
            }
        } else {
            for (int i = l; i <= r; i++) {
               swapRows(a, l, i);
               boolean res1 = findTrace(a, l+1, r, k, res);
               if(res1) {
                 return true;
               }
               swapRows(a, l, i);
               swapCols(a, l, i);
               boolean res2 = findTrace(a, l+1, r, k, res);
               if(res2) {
                  return true;
               }
               swapCols(a, l, i);
            }
        }
        return false;
    }

    private static void setLatinSquare(int a[][]) {
        int n = a.length;
        int x = n+1;
        for (int i=0; i<n; i++) {
            int temp = x;
            int y = 0;
            while (temp <= n) {
                a[i][y++] = temp++;
            }
            for (int j=1; j<x; j++) {
                a[i][y++] = j;
            }
            x--;
        }
    }

    private static void printArr(int arr[][]) {
        int n = arr.length;
        for(int x=0; x<n; x++) {
            for(int y=0; y<n-1; y++) {
                System.out.print(arr[x][y] + " ");
            }
            System.out.println(arr[x][n-1]);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=1; i<=t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int a[][] = new int[n][n];
            setLatinSquare(a);
            int res[][] = new int[n][n];
            boolean isPossible = findTrace(a, 0, n-1, k, res);
            if(isPossible) {
                System.out.printf("Case #%d: POSSIBLE\n", i);
                printArr(res);
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", i);
            }
        }
    }
}
