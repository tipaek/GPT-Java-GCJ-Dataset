import java.util.*;
import java.io.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        for(int g=1;g<=tc;g++)
        {
            int n=Integer.parseInt(br.readLine());
            int[][] ar=new int[n][n];
            int row[]=new int[n];
            int col[]=new int[n];
           // int sum=n*(n+1)/2;
            
            for(int i=0;i<n;i++)
            {
                String s=br.readLine();
                String sr[]=s.split(" ");
                for(int j=0;j<n;j++)
                {
                    ar[i][j]=Integer.parseInt(sr[j]);
                }
            }
            int k=0,r=0,r1=0,c1=0,c=0;
            
            for(int i=0;i<n;i++)
                k+=ar[i][i];
                
            for(int i=0;i<n;i++)
            {
                c1=0;r1=0;
               for(int j=0;j<n;j++)
               {
                   row[ar[i][j]-1]=ar[i][j];
                   col[ar[j][i]-1]=ar[j][i];
                 //  System.out.println(row[ar[i][j]-1]+" "+col[ar[j][i]-1]);
               }
               for(int j=0;j<n;j++)
               {
                    //System.out.println(row[j]+" "+col[j]);
                   // c1=0;r1=0;
                   if(row[j]==0)
                   r1=1;
                   else
                   row[j]=0;
                   if(col[j]==0)
                   c1=1;
                   else
                   col[j]=0;
               }
               r+=r1;c+=c1;
              // System.out.println(r+" "+c);
               
            }
            // for(int i=0;i<n;i++)
            // {
            //     if(row[i]!=sum)
            //     r++;
            //     if(col[i]!=sum)
            //     c++;
            // }
                
            System.out.println("Case #"+g+": "+k+" "+r+" "+c);
        }
        
    }
}