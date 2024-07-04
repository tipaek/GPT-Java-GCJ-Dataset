import java.util.*;
class Solution
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int c1=0;
        while(t-->0)
        {
            c1++;
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int tr=0;
            int r=0;
            int c=0;
            int flag=0;
            for(int i=0;i<n;i++)
            {
                flag=0;
                 HashSet<Integer> h=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(h.contains(a[i][j]))
                    {
                        flag=1;
                    }
                    else
                    {
                        h.add(a[i][j]);
                    }
                    if(i==j)
                    {
                        tr=tr+a[i][j];
                    }
                }
                if(flag==1)
                {
                    r++;
                }
            }
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> h=new HashSet<Integer>();
                flag=0;
                for(int j=0;j<n;j++)
                {
                    if(h.contains(a[j][i]))
                    {
                        flag=1;
                    }
                    else
                    {
                        h.add(a[j][i]);
                    }
                }
                if(flag=1)
                {
                c++;
                }
            }
            System.out.println("Case #"+c1+": "+tr+" "+r+" "+c);
        }
    }
}