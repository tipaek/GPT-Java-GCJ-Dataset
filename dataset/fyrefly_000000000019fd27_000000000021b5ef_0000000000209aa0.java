import java.util.Scanner;
public class Solution { 
    public static void main (String[]args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int tn = 1; tn <= t; tn++) {
            boolean possible = false;
            int n = scan.nextInt(), k = scan.nextInt();
            int[][] nums = new int[n][n];
            for (int times = 1; times <= n; times++) { 
               for (int i = 0; i < n; i++) {
                  int num = times;
                  num += i;
                  for (int j = 0; j < n; j++) {
                     if (num == n + 1) num = 1;
                     nums[i][j] = num;
                     num++;
                  }  
               }
               int trace = 0;
               for (int i = 0; i < n; i++) trace += nums[i][i];
                  if (trace == k) {
                     possible = true;
                     break;
                  }             
            }
            if (possible) {
               System.out.println("Case #" + tn + " : POSSIBLE");
               for (int i = 0; i < n; i++) {
                  for (int j = 0; j < n; j++)
                     System.out.print(nums[i][j] + " ");
                  System.out.println();
               }
            } else {
               System.out.println("Case #" + tn + " : IMPOSSIBLE");
            }
        }
    }
}