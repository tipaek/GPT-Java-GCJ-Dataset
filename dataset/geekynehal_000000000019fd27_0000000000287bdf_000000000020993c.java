import java.util.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n = s.nextInt();
            int a[][] = new int[n][n];
            int trace = 0,r=0,c=0;
            
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    a[j][k] = s.nextInt();
                    if(k==j)
                    {
                        trace+=a[j][k];
                    }
                }
            }
            boolean flagc, flagr;
            
            for(int j=0;j<n;j++)
            {
                flagc = false;
                flagr = false;
                for(int k=0;k<n;k++)
                {
                    for(int l=k+1;l<n;l++)
                    {
                        if(a[j][k]==a[j][l] && flagr!=true)
                        {
                            r++;
                            flagr = true;
                        }
                        if(a[k][j]==a[l][j] && flagc!=true)
                        {
                            c++;
                            flagc = true;
                        }
                    }
                }
            }
            System.out.println("Case #"+t+": "+trace+" "+r+" "+c);
        }
    }
}