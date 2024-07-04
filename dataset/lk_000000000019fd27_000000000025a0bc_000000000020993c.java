import java.util.*;
class Solution
{
    public static void main(String[] b)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0)
        {
            int n=s.nextInt();
            int[][] m=new int[n][n];
            for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            m[i][j]=s.nextInt();
            int c=0,rcount=0,ccount=0;
            for(int i=0;i<n;i++)
            {for(int j=0;j<n-1;j++)
              {   c=m[i][j];
                   int k;
                  for(k=j+1;k<n;k++)
                  if(m[i][k]==c)
                   {
                       rcount++;
                       break;
                   }
                  if(k!=n)
                   break;
              }
            }
            
            for(int i=0;i<n;i++)
            {for(int j=0;j<n-1;j++)
              {   c=m[j][i];
              int k;
                  for(k=j+1;k<n;k++)
                  if(m[k][i]==c)
                   {
                       ccount++;
                       break;
                   }
                  if(k!=n)
                   break;
              }
            }
            int sum=0;
            for(int d=0;d<n;d++)
              sum=sum+m[d][d];
            System.out.println(sum+" "+rcount+" "+ccount);
        }
    }
    
    
}