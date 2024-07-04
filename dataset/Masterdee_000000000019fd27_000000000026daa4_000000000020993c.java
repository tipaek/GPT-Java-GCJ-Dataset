import java.io.*; 
import java.util.Scanner;
class Solution 
{ 
  public static void main(String[] args)throws Exception 
  { 
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTc = sc.nextInt();
    for (int i = 1; i <= numTc; ++i) {
        int len = sc.nextInt();
        int [][] b = new int[len+1][len+1];
        
        int k = 0;
        int r =0;
        int c =0;
        for (int j1 = 0; j1 < len; j1++) {
            boolean isAddRow = false;
            for (int j2 = 0; j2 < len; j2++) {
                int a = sc.nextInt();
                if (j1 == j2) k+=a;
                if (b[len][a] == j1+1) {
                    isAddRow = true;
                } else {
                    b[len][a] = j1+1;             
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


        System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
    }
  }
} 