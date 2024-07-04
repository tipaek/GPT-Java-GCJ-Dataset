import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int test = 1; test <= t; ++test) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for(int i=0;i<n;i++) {
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
            }
            char dp[]=new char[n];
            dp[0]='C';
            int c=1,k=0;
            for(int i=1;i<n;i++) {
                boolean f1 = true;
                boolean f2 = true;
                for(int j=0;j<i;j++) {
                    if(dp[j]=='J'){
                        if (a[i][0]>=a[j][1]||a[i][1]<=a[j][0])
                            continue;
                        else {
                            f1=false;
                        }
                    }
                    if(dp[j]=='C'){
                        if (a[i][0]>=a[j][1]||a[i][1]<=a[j][0])
                            continue;
                        else {
                            f2=false;
                        }
                    }
                }
                if(f1 && f2) {
                    dp[i]=(k>c)?'J':'C';
                    if(k>c)
                        k++;
                    else
                        c++;
                }
                else {
                    if(f1) {
                        k++;
                        dp[i]='J';
                    }
                    else if(f2) {
                        c++;
                        dp[i]='C';
                    }
                    else {
                        dp[i]='#';
                    }
                }
            }

            System.out.print("Case #" + test + ": ");
            if(c+k==n) {
                for(char it:dp)
                    System.out.print(it);
            }
            else {
                System.out.print("IMPOSSIBLE");
            }

            System.out.println();
        }
    }
}
