import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        for (int c = 0; c < test; c++) {
            int n = s.nextInt();
            int key = s.nextInt();
            int a[][] = new int[n][n];
            int k = (int) Math.sqrt(key);
            int neg = 0, pos = 0;
            if (k - 1 > 0)
                neg = 1;
            else
                pos = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        a[i][j] = k;
                    } else if (neg > 0) {
                        a[i][j] = k - 1;
                        neg--;
                        if (neg == 0)
                            pos = 2;
                    } else if (pos > 0) {
                        a[i][j] = k + 1;
                        pos--;
                        if (pos == 0)
                            neg = 2;
                    }
                }
            }
            diasum(a,n,0,0,0,key,c+1);
            /*if (diasum(a, n, 0, 0, 0) != key) {
                System.out.print("Case #" + c + ": ");
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.print("Case #" + c + ": ");
                System.out.println("POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++)
                        System.out.print(a[i][j] + " ");
                    System.out.println();
                }
            }*/
        }
    }
    public static void diasum(int[][] a, int n, int i, int j, int sum,int k,int c) {
        if (i == j && i < n && j < n) {
            sum = sum + a[i][j];
            i = i + 1;
            j = j + 1;
            diasum(a, n, i, j, sum, k, c);
        } else if (i == n && i == j) {
            if (sum != k) {
                System.out.print("Case #" + c + ": ");
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.print("Case #" + c + ": ");
                System.out.println("POSSIBLE");
                for (int m = 0; m < n; m++) {
                    for (int p = 0; p < n; p++)
                        System.out.print(a[m][p] + " ");
                    System.out.println();
                }
            }
        }
    }
}
