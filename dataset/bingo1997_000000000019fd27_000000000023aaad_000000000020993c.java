import java.util.*;
class Vestigium
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
        int n=sc.nextInt();
        int a[][]=new int[n][n];
        int sum=0;
        int r=0;
        int c=0;
        HashSet<Integer>h=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
                if(i==j)
                sum=sum+a[i][j];
            }
        }
        for(int i=0;i<n;i++)
        {
            h.clear();
            for(int j=0;j<n;j++)
            {
                if(!h.contains(a[i][j]))
                h.add(a[i][j]);
                else
                {
                    r++;
                    break;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            h.clear();
            for(int j=0;j<n;j++)
            {
                if(!h.contains(a[j][i]))
                h.add(a[j][i]);
                else
                {
                    c++;
                    break;
                }
            }
        }
        System.out.println("Case #"+(t+1)+":"+" "+sum+" "+r+" "+c);
        }
    }
}