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
            for(i=0;i<n;i++)
            {
                int a[][]=new int[n][n];
                for(int j=0;j<n;j++)
                {
                    for(int k=0;k<n;k++)
                    {
                        a[j][k]=sc.nextInt();
                        System.out.print(a[j][k]);
                    }
                }
            }
        }
    }
}