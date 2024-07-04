import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int f = 0;
        while (f++ < t){
            int n = scan.nextInt();
            int k = scan.nextInt();

            int[][] ar = new int[n][n];
            ar[0][0] = 2;
            for (int i = 1; i < n-1; i++) {
                ar[0][i] +=1+ar[0][i-1];
            }
            ar[0][n-1] = 1;
            for (int i = 1; i < n; i++) {
                ar[i][0] = ar[i-1][n-1];
                for (int j = 0; j < n-1; j++) {
                    ar[i][j+1] = ar[i-1][j];
                }
            }
            int sum = 0;
            for (int i = 0; i < ar.length; i++) {
                sum+=ar[i][i];
            }
            if(sum == k){
                System.out.println("Case #"+f+": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(ar[i][j] + " ");
                    }
                    System.out.println();
                }
            }else{
                System.out.println("Case #"+f+": IMPOSSIBLE");
            }
        }
    }
}