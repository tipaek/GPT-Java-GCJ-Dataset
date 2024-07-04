import java.util.*;
class Solution
{
    public static void main(String a[])
    {
        Scanner dj=new Scanner(System.in);
        int t,i,j,k,p=0;
        t=dj.nextInt();
        for(i=0;i<t;i++)
        {
            p=0;
            int n=dj.nextInt(),s=0;
            int cr=0,cc=0;
            int mat[][]=new int[n][n];
            int sum[]=new int[101];
            for(k=1;k<=100;k++)
            sum[k]=0;
            for(j=0;j<n;j++)
            {
                for(k=1;k<=100;k++)
            sum[k]=0;
                for( k=0;k<n;k++)
                {
                    mat[j][k]=dj.nextInt();
                    if(j==k)
                    s+=mat[j][k];
                    sum[mat[j][k]]=sum[mat[j][k]]+1;
                }
                
                for(k=1;k<=100;k++)
                {
                    if(sum[k]>1)
                    {
                        p=1;
                        break;
                    }
                }
                if(p==1)
                {
                    cr++;
                    p=0;
                }
            }
            for(k=1;k<=100;k++)
            sum[k]=0;
            p=0;
            for(j=0;j<n;j++)
            {
                 for(k=1;k<=100;k++)
            sum[k]=0;
                 for(k=0;k<n;k++)
                {
                        sum[mat[k][j]]=sum[mat[k][j]]+1;
                }
                for(k=1;k<=100;k++)
                {
                    if(sum[k]>1)
                    {
                        p=1;
                        break;
                    }
                }
                if(p==1)
                {
                    cc++;
                    p=0;
                }
            }
            System.out.println("Case #"+(i+1)+": "+s+" "+cr+" "+cc);
            
        }
    }
}