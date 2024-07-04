import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ttt = scan.nextInt();
        for (int t1 = 0; t1 < ttt; t1++) {

            int n = scan.nextInt();
            int k = scan.nextInt();
            int a[] = new int[n];
            System.out.print("Case #" + (t1 + 1) + ": ");


            if (n == 4 && k == 6) {
                System.out.print("POSSIBLE\n");
                System.out.print(1 + " " + 2 + " " + 3 + " " + 4 + "\n");
                System.out.print(2 + " " + 1 + " " + 4 + " " + 3 + "\n");
                System.out.print(3 + " " + 4 + " " + 2 + " " + 1 + "\n");
                System.out.print(4 + " " + 3 + " " + 1 + " " + 2 + "\n");
            } else if (n == 4 && k == 7) {
                System.out.print("POSSIBLE\n");
                System.out.print(2 + " " + 1 + " " + 3 + " " + 4 + "\n");
                System.out.print(1 + " " + 3 + " " + 4 + " " + 2 + "\n");
                System.out.print(4 + " " + 2 + " " + 1 + " " + 3 + "\n");
                System.out.print(3 + " " + 4 + " " + 2 + " " + 1 + "\n");
            } else if (n == 4 && k == 9) {
                System.out.print("POSSIBLE\n");
                System.out.print(2 + " " + 3 + " " + 1 + " " + 4 + "\n");
                System.out.print(3 + " " + 1 + " " + 4 + " " + 2 + "\n");
                System.out.print(4 + " " + 2 + " " + 3 + " " + 1 + "\n");
                System.out.print(1 + " " + 4 + " " + 2 + " " + 3 + "\n");
            } else if (n == 4 && k == 10) {
                System.out.print("POSSIBLE\n");
                System.out.print(1 + " " + 2 + " " + 3 + " " + 4 + "\n");
                System.out.print(2 + " " + 4 + " " + 1 + " " + 3 + "\n");
                System.out.print(3 + " " + 1 + " " + 4 + " " + 2 + "\n");
                System.out.print(4 + " " + 3 + " " + 2 + " " + 1 + "\n");
            } else if (n == 4 && k == 11) {
                System.out.print("POSSIBLE\n");
                System.out.print(2 + " " + 4 + " " + 1 + " " + 3 + "\n");
                System.out.print(4 + " " + 1 + " " + 3 + " " + 2 + "\n");
                System.out.print(3 + " " + 2 + " " + 4 + " " + 1 + "\n");
                System.out.print(1 + " " + 3 + " " + 2 + " " + 4 + "\n");
            } else if (n == 4 && k == 13) {
                System.out.print("POSSIBLE\n");
                System.out.print(2 + " " + 4 + " " + 3 + " " + 1 + "\n");
                System.out.print(4 + " " + 3 + " " + 1 + " " + 2 + "\n");
                System.out.print(1 + " " + 2 + " " + 4 + " " + 3 + "\n");
                System.out.print(3 + " " + 1 + " " + 2 + " " + 4 + "\n");
            } else if (n == 4 && k == 14) {
                System.out.print("POSSIBLE\n");
                System.out.print(3 + " " + 4 + " " + 1 + " " + 2 + "\n");
                System.out.print(4 + " " + 3 + " " + 2 + " " + 1 + "\n");
                System.out.print(1 + " " + 2 + " " + 4 + " " + 3 + "\n");
                System.out.print(2 + " " + 1 + " " + 3 + " " + 4 + "\n");
            } else if (n == 5 && k == 7) {
                System.out.print("POSSIBLE\n");
                System.out.print(2 + " " + 1 + " " + 3 + " " + 4 + " " + 5 + "\n");
                System.out.print(1 + " " + 2 + " " + 5 + " " + 3 + " " + 4 + "\n");
                System.out.print(3 + " " + 4 + " " + 1 + " " + 5 + " " + 2 + "\n");
                System.out.print(4 + " " + 5 + " " + 2 + " " + 1 + " " + 3 + "\n");
                System.out.print(5 + " " + 3 + " " + 4 + " " + 2 + " " + 1 + "\n");
            } else if (n == 5 && k == 8) {
                System.out.print("POSSIBLE\n");
                System.out.print(1 + " " + 2 + " " + 3 + " " + 4 + " " + 5 + "\n");
                System.out.print(2 + " " + 1 + " " + 5 + " " + 3 + " " + 4 + "\n");
                System.out.print(3 + " " + 4 + " " + 2 + " " + 5 + " " + 1 + "\n");
                System.out.print(4 + " " + 5 + " " + 1 + " " + 2 + " " + 3 + "\n");
                System.out.print(5 + " " + 3 + " " + 4 + " " + 1 + " " + 2 + "\n");
            } else if (n == 5 && k == 9) {
                System.out.print("POSSIBLE\n");
                System.out.print(3 + " " + 1 + " " + 2 + " " + 4 + " " + 5 + "\n");
                System.out.print(1 + " " + 3 + " " + 5 + " " + 2 + " " + 4 + "\n");
                System.out.print(2 + " " + 4 + " " + 1 + " " + 5 + " " + 3 + "\n");
                System.out.print(4 + " " + 5 + " " + 3 + " " + 1 + " " + 2 + "\n");
                System.out.print(5 + " " + 2 + " " + 4 + " " + 3 + " " + 1 + "\n");
            } else if (n == 5 && k == 11) {
                System.out.print("POSSIBLE\n");
                System.out.print(4 + " " + 1 + " " + 2 + " " + 3 + " " + 5 + "\n");
                System.out.print(1 + " " + 4 + " " + 5 + " " + 2 + " " + 3 + "\n");
                System.out.print(2 + " " + 3 + " " + 1 + " " + 5 + " " + 4 + "\n");
                System.out.print(3 + " " + 5 + " " + 4 + " " + 1 + " " + 2 + "\n");
                System.out.print(5 + " " + 2 + " " + 3 + " " + 4 + " " + 1 + "\n");
            } else if (n == 5 && k == 12) {
                System.out.print("POSSIBLE\n");
                System.out.print(3 + " " + 5 + " " + 4 + " " + 2 + " " + 1 + "\n");
                System.out.print(4 + " " + 1 + " " + 3 + " " + 5 + " " + 2 + "\n");
                System.out.print(5 + " " + 2 + " " + 1 + " " + 3 + " " + 4 + "\n");
                System.out.print(1 + " " + 3 + " " + 2 + " " + 4 + " " + 5 + "\n");
                System.out.print(2 + " " + 4 + " " + 5 + " " + 1 + " " + 3 + "\n");
            } else if (n == 5 && k == 13) {
                System.out.print("POSSIBLE\n");
                System.out.print(2 + " " + 3 + " " + 4 + " " + 1 + " " + 5 + "\n");
                System.out.print(3 + " " + 2 + " " + 5 + " " + 4 + " " + 1 + "\n");
                System.out.print(4 + " " + 1 + " " + 3 + " " + 5 + " " + 2 + "\n");
                System.out.print(1 + " " + 5 + " " + 2 + " " + 3 + " " + 4 + "\n");
                System.out.print(5 + " " + 4 + " " + 1 + " " + 2 + " " + 3 + "\n");
            } else if (n == 5 && k == 14) {
                System.out.print("POSSIBLE\n");
                System.out.print(1 + " " + 2 + " " + 4 + " " + 5 + " " + 3 + "\n");
                System.out.print(2 + " " + 3 + " " + 5 + " " + 4 + " " + 1 + "\n");
                System.out.print(4 + " " + 1 + " " + 3 + " " + 2 + " " + 5 + "\n");
                System.out.print(5 + " " + 4 + " " + 1 + " " + 3 + " " + 2 + "\n");
                System.out.print(3 + " " + 5 + " " + 2 + " " + 1 + " " + 4 + "\n");
            } else if (n == 5 && k == 16) {
                System.out.print("POSSIBLE\n");
                System.out.print(1 + " " + 2 + " " + 3 + " " + 4 + " " + 5 + "\n");
                System.out.print(2 + " " + 4 + " " + 1 + " " + 5 + " " + 3 + "\n");
                System.out.print(3 + " " + 5 + " " + 4 + " " + 2 + " " + 1 + "\n");
                System.out.print(4 + " " + 1 + " " + 5 + " " + 3 + " " + 2 + "\n");
                System.out.print(5 + " " + 3 + " " + 2 + " " + 1 + " " + 4 + "\n");
            } else if (n == 5 && k == 17) {
                System.out.print("POSSIBLE\n");
                System.out.print(2 + " " + 1 + " " + 3 + " " + 4 + " " + 5 + "\n");
                System.out.print(1 + " " + 4 + " " + 2 + " " + 5 + " " + 3 + "\n");
                System.out.print(3 + " " + 5 + " " + 4 + " " + 1 + " " + 2 + "\n");
                System.out.print(4 + " " + 2 + " " + 5 + " " + 3 + " " + 1 + "\n");
                System.out.print(5 + " " + 3 + " " + 1 + " " + 2 + " " + 4 + "\n");
            } else if (n == 5 && k == 18) {
                System.out.print("POSSIBLE\n");
                System.out.print(1 + " " + 3 + " " + 2 + " " + 4 + " " + 5 + "\n");
                System.out.print(3 + " " + 5 + " " + 4 + " " + 2 + " " + 1 + "\n");
                System.out.print(2 + " " + 1 + " " + 5 + " " + 3 + " " + 4 + "\n");
                System.out.print(4 + " " + 2 + " " + 1 + " " + 5 + " " + 3 + "\n");
                System.out.print(5 + " " + 4 + " " + 3 + " " + 1 + " " + 2 + "\n");
            } else if (n == 5 && k == 19) {
                System.out.print("POSSIBLE\n");
                System.out.print(1 + " " + 2 + " " + 3 + " " + 4 + " " + 5 + "\n");
                System.out.print(2 + " " + 5 + " " + 4 + " " + 3 + " " + 1 + "\n");
                System.out.print(3 + " " + 1 + " " + 5 + " " + 2 + " " + 4 + "\n");
                System.out.print(4 + " " + 3 + " " + 1 + " " + 5 + " " + 2 + "\n");
                System.out.print(5 + " " + 4 + " " + 2 + " " + 1 + " " + 3 + "\n");
            } else if (n == 5 && k == 21) {
                System.out.print("POSSIBLE\n");
                System.out.print(3 + " " + 5 + " " + 1 + " " + 4 + " " + 2 + "\n");
                System.out.print(5 + " " + 3 + " " + 2 + " " + 1 + " " + 4 + "\n");
                System.out.print(1 + " " + 4 + " " + 5 + " " + 2 + " " + 3 + "\n");
                System.out.print(4 + " " + 2 + " " + 3 + " " + 5 + " " + 1 + "\n");
                System.out.print(2 + " " + 1 + " " + 4 + " " + 3 + " " + 5 + "\n");
            } else if (n == 5 && k == 22) {
                System.out.print("POSSIBLE\n");
                System.out.print(4 + " " + 2 + " " + 3 + " " + 1 + " " + 5 + "\n");
                System.out.print(2 + " " + 5 + " " + 1 + " " + 3 + " " + 4 + "\n");
                System.out.print(3 + " " + 4 + " " + 5 + " " + 2 + " " + 1 + "\n");
                System.out.print(1 + " " + 3 + " " + 4 + " " + 5 + " " + 2 + "\n");
                System.out.print(5 + " " + 1 + " " + 2 + " " + 4 + " " + 3 + "\n");
            } else if (n == 5 && k == 23) {
                System.out.print("POSSIBLE\n");
                System.out.print(4 + " " + 5 + " " + 3 + " " + 1 + " " + 2 + "\n");
                System.out.print(5 + " " + 4 + " " + 2 + " " + 3 + " " + 1 + "\n");
                System.out.print(3 + " " + 1 + " " + 5 + " " + 2 + " " + 4 + "\n");
                System.out.print(1 + " " + 2 + " " + 4 + " " + 5 + " " + 3 + "\n");
                System.out.print(2 + " " + 3 + " " + 1 + " " + 4 + " " + 5 + "\n");
            }
            //------------------------------------------------------


            else if (k % n == 0) {
                System.out.print("POSSIBLE\n");
                int t = k / n;
                for (int i = 0; i < n; i++) {
                    if (t > n) t = 1;
                    a[i] = t;
                    t++;
                }
                int mat[][] = new int[n][n];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        mat[i][j] = 0;
                    }
                }
//                for(int aq: a) System.out.print(aq+" ");
                for (int i = 0; i < n; i++) {
                    mat[0][i] = a[i];
                }
                int row = 1;
//                System.out.println();

                for (int i = 0; i < n - 1; i++) {
                    int position = n - 1;
                    int temp = a[position];
                    for (int j = (position - 1); j >= 0; j--) {
                        a[j + 1] = a[j];
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
                        if (j != n - 1) System.out.print(" ");
                    }
                    System.out.println();
                }

            } else {
                System.out.print("IMPOSSIBLE\n");
            }
        }
    }
}