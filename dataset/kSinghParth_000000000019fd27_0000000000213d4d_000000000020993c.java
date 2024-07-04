import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int k=1;k<=t;k++) {
            int n=sc.nextInt(); 
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    arr[i][j] = sc.nextInt();
            int p=0;
            for(int i=0;i<n;i++)p+=arr[i][i];
            int q=0,r=0;
            for(int i=0;i<n;i++){
                int brr[][] = new int[2][n+1];
                for(int j=0;j<n;j++){
                    brr[0][arr[i][j]]++;
                    brr[1][arr[j][i]]++;
                }
                int t1=q+1,t2=r+1;
                for(int j=1;j<=n;j++){
                    if(brr[0][j]!=1)
                        q=t1;
                    if(brr[1][j]!=1)
                        r=t2;
                }
            }
            System.out.println("Case #"+k+": "+p+" "+q+" "+r);
            //process(r,b,c);
        }
    }


   
}
