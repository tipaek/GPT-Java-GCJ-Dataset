import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int i_t=0;i_t<test;i_t++)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int t=0;
            for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
                if(i==j)
                t+=a[i][j];
            }
            int c=0;
            for(int i=0;i<n;i++)
            {
                Set<Integer> s=new HashSet<Integer>();
                for(int j=0;j<n;j++)
                s.add(a[i][j]);
                if(n!=s.size())
                c++;
            }
            int c1=0;
            for(int i=0;i<n;i++)
            {
                Set<Integer> s=new HashSet<Integer>();
                for(int j=0;j<n;j++)
                s.add(a[j][i]);
                if(n!=s.size())
                c1++;
            }
            System.out.println("Case #"+(i_t+1)+": "+t+" "+c+" "+c1);
        }
    }
}