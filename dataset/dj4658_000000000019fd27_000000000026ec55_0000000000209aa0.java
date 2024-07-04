import java.util.*;
class Solution
{
    public static void main(String a[])
    {
        Scanner dj=new Scanner(System.in);
        int t,i,j,k,sum=0;
        t=dj.nextInt();
        for(i=0;i<t;i++)
        {
            int n=dj.nextInt();
             k=dj.nextInt();
           int mat[][]=new int[n][n];
            for(j=0;j<n;j++)  //diagonal
            mat[j][j]=1;
            int b=1;
            for(j=0;j<n;j++)   //1st row
            mat[0][j]=b++;
            b=n;
            for(j=1;j<n;j++)   //1st col
            mat[j][0]=b--;
            b=n;
            for(j=0;j<n-1;j++)//last col
            mat[j][n-1]=b--;
            b=2;
            for(j=0;j<n-1;j++) //last row
            mat[n-1][j]=b++;
            
        for(j=n-1;j>=0;j--)
        {
            for(k=1;k<j;k++)
            {
                mat[j-1][k-1]=mat[j][k];   //lower lft
            }
        }
        
        for(j=0;j<n-1;j++)
        {
            for(k=1;k<n-1;k++)
            {
                mat[j+1][k+1]=mat[j][k];   //upper ryt
            }
        }

        for(j=0;j<n;j++)
        {
            for(k=0;k<n;k++)
            {
                if((k+j)==(n-1))
                sum+=mat[j][k];
            }
        }
        String s;
                if(sum==k)
                {
                    s="POSSIBLE";
                }
                else
                s="IMPOSSIBLE";
            
            System.out.println("Case #"+(i+1)+": "+s);
            if(s.equals("POSSIBLE"))
            {
                for(j=0;j<n;j++)
                {
                    for(k=0;k<n;k++)
                    {
                        System.out.print(mat[j][k]+" ");
                    }
                    System.out.println();
                }
            }
        }
    }
}