import java.io.*; 
import java.util.Scanner;
public class Vestigium 
{ 
  public static void main(String[] args)throws Exception 
  { 
    File file = new File(args[0]); 
    Scanner sc = new Scanner(file);
    int numTc = sc.nextInt();
    for (int i = 1; i <= numTc; ++i) {
        int[][] arr = new int[101][101];
        int [][] b = new int[101][101];
        int len = sc.nextInt();
        int k = 0;
        int r =0;
        int c =0;
        for (int j1 = 0; j1 < len; j1++) {
            boolean isAddRow = false;
            for (int j2 = 0; j2 < len; j2++) {
                int a = sc.nextInt();
                arr[j1][j2] = a;
                if (j1 == j2) k+=arr[j1][j2];
                if (b[100][a] == j1+1) {
                    isAddRow = true;
                } else {
                    b[100][a] = j1+1;             
                }
                if (b[j2][a] == 1) {
                    b[j2][0] = 1;
                } else {
                    b[j2][a] = 1;
                }
            }

            if (isAddRow) r++;
        }


        for (int m = 0; m < len; m++) {
            c += b[m][0];
        }


        System.out.format("Case #%d: %d %d %d", i, k, r, c);
        System.out.println();
    }
  }
} 