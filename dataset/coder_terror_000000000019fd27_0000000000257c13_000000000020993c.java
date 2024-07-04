import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        try
        {
        for(int q=1;q<=t;q++)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int k=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(i==j)
                    k+=a[i][j];
                }
                
            }
            int r=0,c=0;
            for(int i=0;i<n;i++)
            {
                int cr=1;
                for(int j=0;j<n-1;j++)
                {
                    for(int p=j+1;p<n;p++)
                    {
                    if(a[i][j]==a[i][p])
                    cr++;
                }
                
                }
                if(cr>1)
                r++;
                
            }
            for(int i=0;i<n;i++)
            {
                int cc=1;
                for(int j=0;j<n-1;j++)
                {
                    for(int p=j+1;p<n;p++)
                    {
                    if(a[p][i]==a[j][i])
                    cc++;
                }
                
                }
                if(cc>1)
                c++;
                
            }
            System.out.println("Case #"+q+": "+k+" "+r+" "+c);
            
        }
    }catch(Exception e){
        return;
    }
    
    }
}
