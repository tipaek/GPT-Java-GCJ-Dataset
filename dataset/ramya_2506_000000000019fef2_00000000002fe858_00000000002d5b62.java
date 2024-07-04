import java.io.*;
import java.util.*;
class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            int count=0;
            for(int j=0;j<n;j++)
            {
                a[j]=sc.nextInt();
                if(j>1 && j<n)
                {
                    if(a[j-1]>a[j-2] && a[j-1]>a[j])
                    {
                        count++;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+":"+count);
        }
    }
}