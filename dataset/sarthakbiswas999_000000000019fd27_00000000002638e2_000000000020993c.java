import java.util.*;
import java.lang.*;
import java.io.*;
 
class GFG{

    public static void main (String[] args) { 
        //System.out.println("GfG!");
        Scanner sc=new Scanner(System.in);
        
        int t=sc.nextInt();
        
        for(int l=0;l<t;l++)
        {
            int n=sc.nextInt();
            
            int[][] m=new int[n][n];
            int d=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    m[i][j]=sc.nextInt();
                    if(j==i)
                    {
                        d=d+m[i][j];
                    }
                }
            }
            
            int r=0;
            int c=0;
            for(int i=0;i<n;i++)
            {
                int[] cnt=new int[n+1];
                Arrays.fill(cnt,0);
                for(int j=0;j<n;j++)
                {
                    if(cnt[m[i][j]]==0)
                        cnt[m[i][j]]++;
                    
                    else
                    {
                        r++;
                        break;
                    }
                        
                }
            }
            
            for(int i=0;i<n;i++)
            {
                int[] cnt=new int[n+1];
                Arrays.fill(cnt,0);
                for(int j=0;j<n;j++)
                {
                    if(cnt[m[j][i]]==0)
                        cnt[m[j][i]]++;
                    
                    else
                    {
                        c++;
                        break;
                    }
                        
                }
            }
            
            System.out.println("Case #" + (l+1) + ": " + d + " " + r + " " + c);
   
        }
    }  
}