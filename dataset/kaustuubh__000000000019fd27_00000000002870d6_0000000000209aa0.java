import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ttt = scan.nextInt();
        for (int t1 = 0; t1 < ttt; t1++) {

            int n = scan.nextInt();
            int k = scan.nextInt();
            int a[] = new int[n];
            System.out.print("Case #" + (t1+1) + ": ");
            if (k % n == 0) {
                System.out.print("POSSIBLE\n");
                int t = k / n;
                for (int i = 0; i < n; i++) {
                    if(t>n) t = 1;
                    a[i] = t;
                    t++;
                }
                int mat[][] = new int[n][n];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        mat[i][j]=0;
                    }
                }
//                for(int aq: a) System.out.print(aq+" ");
                for (int i = 0; i < n; i++) {
                        mat[0][i] = a[i];
                }
                int row=1;
//                System.out.println();

                for (int i = 0; i < n-1; i++) {
                    int position = n-1;
                    int temp = a[position];
                    for (int j = (position - 1); j >= 0; j--) {
                        a[j+1] = a[j];
                    }
                    a[0] = temp;

                    for (int j = 0; j < n; j++) {
                        mat[row][j] = a[j];
                    }
                    row++;
//                    for (int aq: a) {
//                        System.out.print(aq+" ");
//                    }
//                    System.out.println();
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(mat[j][i]);
                        if(j!=n-1) System.out.print(" ");
                    }
                    System.out.println();
                }

            }
            else
            {
                System.out.print("IMPOSSIBLE\n");
            }
        }
    }
}
/*
3
3 6
2 3
4 12

*/
