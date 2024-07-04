import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        Scanner r=new Scanner(System.in);
        int t=r.nextInt();
        for(int z=1;z<=t;z++)
        {
            int n=r.nextInt();
            int a[]=new int[n];
            int b[]=new int[n];
            int in[]=new int[n];
            char ch[]=new char[n];
            int temp=0,flag=0;
            char tempc;
            String ans="";
            int ja=0,c=0;
            for(int i=0;i<n;i++)
            {
                a[i]=r.nextInt();
                b[i]=r.nextInt();
                in[i]=i;
            }
            for(int i=0;i<n-1;i++)
            {
                for(int j=0;j<n-i-1;j++)
                {
                    if(a[j]>a[j+1])
                    {
                        temp=a[j];
                        a[j]=a[j+1];
                        a[j+1]=temp;
                        
                        temp=b[j];
                        b[j]=b[j+1];
                        b[j+1]=temp;
                        
                        temp=in[j];
                        in[j]=in[j+1];
                        in[j+1]=temp;
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                if(a[i]>=ja)
                {
                    ans+="J";
                    ja=b[i];
                }
                else if(a[i]>=c)
                {
                    ans+="C";
                    c=b[i];
                }
                else
                {
                    flag=1;
                    break;
                }
            }
            ch=ans.toCharArray();
            for(int i=0;i<n-1;i++)
            {
                for(int j=0;j<n-i-1;j++)
                {
                    if(in[j]>in[j+1])
                    {
                        temp=in[j];
                        in[j]=in[j+1];
                        in[j+1]=temp;
                        
                        tempc=ch[j];
                        ch[j]=ch[j+1];
                        ch[j+1]=tempc;
                    }
                }
            }
            if(flag==1)
            {
                System.out.println("IMPOSSIBLE");
            }
            else
            {
                System.out.print("Case #"+z+":"+" ");
                for(int i=0;i<n;i++)
                {
                    System.out.print(ch[i]);
                }
                System.out.println();
            }
        }
    }
}