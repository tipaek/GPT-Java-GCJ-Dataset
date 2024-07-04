import java.io.FileInputStream;
import java.util.*;
import java.util.Scanner;

 class Main {

    public static long add(int temp[][], int x) {
        long  sum = 0;
        for (int i = 0; i < x; i++) {
            sum += temp[i][i];
        }
        return sum;
    }

    public static int row(int temp1[][], int x) {
        int count = 0;
        for (int i = 0; i < x; i++) {
            boolean e[] = new boolean[x + 1];
            for (int k = 0; k < x + 1; k++) {
                e[k] = false;
            }

            for (int j = 0; j < x; j++) {
                if (e[temp1[i][j]] == false) {
                    e[temp1[i][j]] = true;
                } else if (e[temp1[i][j]] == true) {
                    count++;
                    break;
                }

            }
        }
        return count;
    }

    public static int col(int temp2[][], int x) {
        int count = 0;
        for (int i = 0; i < x; i++) {
            boolean e[] = new boolean[x + 1];
            for (int k = 0; k < x + 1; k++) {
                e[k] = false;
            }

            for (int j = 0; j < x; j++) {
                if (e[temp2[j][i]] == false) {
                    e[temp2[j][i]] = true;
                } else if (e[temp2[j][i]] == true) {
                    count++;
                    break;
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        if(t<1||t>100)
        {
            System.exit(0);
        }
        for (int v = 0; v < t; v++) {
            Scanner l = new Scanner(System.in);
            int n = l.nextInt();
            if(n<2||t>100)
        {
            System.exit(0);
        }

            int a[][] = new int[n][n];
            for (int i = 0; i < n; i++)  { 
                for (int j = 0; j < n; j++) {
                    a[i][j] = s.nextInt();
                }
            }
            long u = add(a, n);
            int r = row(a, n);
            int c = col(a, n);
            System.out.print("Case #" + (v + 1) + ":");
            System.out.print(" " + u);
            System.out.print(" " + r);
            System.out.print(" " + c) ;
        } 
        s.close();

    }

}