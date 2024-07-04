import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int t1 = 0; t1 < t; t1++) {
            int n = scan.nextInt();
            int x = 0, r = 0, c = 0, sum = 0;
            int a[][] = new int[n][n];
            int b[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = scan.nextInt();
                    b[j][i] = a[i][j];
                    if(i==j) sum+=a[i][j];
                }
            }


            for (int i = 0; i < n; i++) {
                if(issame(a[i])) r++;
                if(issame(b[i])) c++;
            }

            // System.out.println(sum+" "+r+" "+c );
            System.out.println("Case #" + (t1+1) + ": " + sum + " " + r + " " + c);
        }
    }
    private static boolean issame(int []a)
    {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]==a[j]) return true;
            }
        }
        return false;
    }
}
