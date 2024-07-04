import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        int cases,n,trace,m[][],i,j,k,l,r,c,check;

        Scanner sc = new Scanner(System.in);
        cases = sc.nextInt();
        int ans[][] = new int[cases][3];
        for (i=0;i<cases;i++)
        {
            n = sc.nextInt();
            m = new int[n][n];
            trace=0;
            r=0;
            c=0;
            for(j=0;j<n;j++)
            {
                for(k=0;k<n;k++)
                {
                    m[j][k] = sc.nextInt();
                }
            }
            
            for(k=0;k<n;k++)
            {
                trace = trace + m[k][k];
            }
            ans[i][0] = trace;
            
            for(j=0;j<n;j++)
            {
                check=1;
                for(k=0;k<n-1;k++)
                {
                    for(l=k+1;l<n;l++)
                    {
                        if(m[j][k]==m[j][l])
                        {
                            check=0;
                            r++;
                            break;
                        }
                    }
                    if(check==0)
                    {
                        break;
                    }
                }
            }
            ans[i][1] = r;

            for(j=0;j<n;j++)
            {
                check=1;
                for(k=0;k<n-1;k++)
                {
                    for(l=k+1;l<n;l++)
                    {
                        if(m[k][j]==m[l][j])
                        {
                            check=0;
                            c++;
                            break;
                        }
                    }
                    if(check==0)
                    {
                        break;
                    }
                }
            }
            ans[i][2] = c;
        }
        
        for(i=0;i<cases;i++)
        {
            System.out.println("Case #"+i+": "+ans[i][0]+" "+ans[i][1]+" "+ans[i][2]);
        }
    }
}