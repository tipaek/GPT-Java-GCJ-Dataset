import java.util.*;
import java.io.*;
public class Solution
{
    static void count(int a[][],int n,int t)
    {
        int rowc=0,colc=0;
        int sum=0;
        
        for(int i=0;i<n;i++)
        {
            int temp1[]=new int[n+1];
            int temp2[]=new int[n+1];
            boolean visitedr=false;
            boolean visitedc=false;
            for(int j=0;j<n;j++)
            {
                if(!visitedr && temp1[a[i][j]]!=0)
                {
                    rowc++;
                    visitedr=true;
                }
                else
                {
                    temp1[a[i][j]]++;
                }
                if(!visitedc && temp2[a[j][i]]!=0)
                {
                    colc++;
                    visitedc=true;
                }
                else
                {
                    temp2[a[j][i]]++;
                }
            }
            sum+=a[i][i];
        }
        System.out.println("Case #"+(t+1)+": "+sum+" "+rowc+" "+colc); 
    }
    public static void main(String s[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=0;
        while(k<t)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                }
            }
            count(a,n,k);
            k++;
        }
    }
}