import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int i,j,k,l,r;
        for(r=1;r<=t;r++)
        {
            int n=sc.nextInt();
            int a[][]=new int [n][n];
            int b[]=new int[n];
            int count=0,count1=0,sum=0;
            for(i=0;i<n;i++){
                for(j=0;j<n;j++)
                {
                  a[i][j]=sc.nextInt();
                  if(i==j){sum=sum+a[i][j];}
                }
            }
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    b[j]=a[i][j];
                }
                Arrays.sort(b);
                for(k=0;k<b.length-1;k++)
                {
                    if(b[k]==b[k+1]){count=count+1;k=b.length;}
                }
            }
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    b[j]=a[j][i];
                }
                Arrays.sort(b);
                for(k=0;k<b.length-1;k++)
                {
                    if(b[k]==b[k+1]){count1=count1+1;k=b.length;}
                }
            }
            System.out.print("Case #"+r+": ");
            System.out.print(sum+" ");
            System.out.print(count+" ");
            System.out.println(count1);
            //System.out.println("\n");
        }
    }
}
