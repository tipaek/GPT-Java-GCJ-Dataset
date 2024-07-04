import java.util.*;
public class Solution
{
    public static void ain(String[] args)
    {
        int cases, n, trace = 0, m[][],i,j,k,l,r,c,check;

        Scanner sc = new Scanner(System.in);
        cases = sc.nextInt();
        int ans[][] = new int[cases][3];
        for (i=0;i<cases;i++)
        {
            n = sc.nextInt();
            m = new int[n][n];
            r=0;
            c=0;
            for(j=0;j<n;j++)
            {
                for(k=0;k<n;k++)
                {
                    m[j][k] = sc.nextInt();
                }
            }

            for(j=0;j<n;j++)
            {
                check=1;
                for(k=0;k<n;k++)
                {
                    for(l=k;l<n;l++)
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

            for(j=0;j<n;j++)
            {
                check=1;
                for(k=0;k<n;k++)
                {
                    for(l=k;l<n;l++)
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
        }
    }
}