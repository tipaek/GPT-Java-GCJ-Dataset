import java.util.*;
import java.util.Scanner;
class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int sum=0;
        int t=sc.nextInt();
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=1;i<=t;i++)
        {
            for(int k=0;k<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[k][j]=sc.nextInt();
                }
            }
            for(int k=0;k<n;k++)
            {
                j=i+1;
                sum=sum+a[k][j];
            }
            System.out.println("Case #"+i+":"+sum);
        }
    }
}