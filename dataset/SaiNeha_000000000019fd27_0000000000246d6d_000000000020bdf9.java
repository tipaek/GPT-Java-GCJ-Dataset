import java.util.*;
import java.io.*;
import java.lang.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=0;
        while(t-->0)
        {
            k++;
            int n=sc.nextInt();
            int a[][]=new int[n][3];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<2;j++)
                {
                    a[i][j]=sc.nextInt();
                }
                a[i][2]=i;
            }
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(a[i][0]>a[j][0])
                {
                    int temp=a[i][0];
                    a[i][0]=a[j][0];
                    a[j][0]=temp;
                    temp=a[i][1];
                    a[i][1]=a[j][1];
                    a[j][1]=temp;
                    temp=a[i][2];
                    a[i][2]=a[j][2];
                    a[j][2]=temp;
                }
            }
        }
        char ch[]=new char[n];
        for(int i=0;i<n;i++)
        {
            ch[i]='0';
        }
        ch[0]='J';
        int sum=a[0][1];
        for(int i=1;i<n;i++)
        {
            if(a[i][0]>=sum)
            {
                ch[i]='J';
                sum=a[i][1];
            }
        }
        int sum2=0;
        for(int i=1;i<n;i++)
        {
            if(ch[i]=='0')
            {
                if(sum2<=a[i][0])
                {
                    ch[i]='C';
                    sum2=a[i][1];
                }
            }
        }
        int f=0;
        for(int i=0;i<n;i++)
        {
            if(ch[i]=='0')
            {
                f=1;
                System.out.print("Case #"+k+": IMPOSSIBLE");
                break;
            }
        }
        if(f==0)
        {
            System.out.print("Case #"+k+": ");
             int y=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(a[j][2]==i)
                    {
                        y=j;
                    }
                }
                System.out.print(ch[y]);
            }
        }
        System.out.println();
        }
    }
}