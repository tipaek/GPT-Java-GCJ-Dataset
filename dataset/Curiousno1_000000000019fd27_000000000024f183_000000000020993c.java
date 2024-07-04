import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int z=0;z<t;z++)
        {
            int n=sc.nextInt();
            int a[][]=new int [n][n];
            int k=0,r=0,c=0;
            for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
                if(j==i)
                k+=a[i][j];
            }
            for(int i=0;i<n;i++)
           outer : for(int y=0;y<n;y++)
            for(int j=y+1;j<n;j++)
            {
                if(a[i][y]==a[i][j])
                {
                    r++;
                    break outer;
                }
            }
            for(int i=0;i<n;i++)
           inner : for(int y=0;y<n;y++)
            for(int j=y+1;j<n;j++)
                if(a[y][i]==a[j][i])
                {
                    c++;
                    break inner;
                }
            System.out.println("Case #"+z+": "+k+" "+r+" "+c);
        }
    }
}