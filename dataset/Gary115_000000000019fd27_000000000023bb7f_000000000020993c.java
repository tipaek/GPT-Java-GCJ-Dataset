import java.lang.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=s.nextInt();
            int mat[][]=new int[n][n];
            int sum=0;
            for(int j=0;j<n;j++)
            { 
                
                for(int k=0;k<n;k++)
                {  
                
                    mat[j][k]=s.nextInt();
                	
                	
                   // System.out.print(mat[j][k]+" ");
                    if(j==k)
                    {
                        sum+=mat[j][k];
                    }
                    
                }
            }
            int countr=0;
            for(int j=0;j<n;j++)
            {
                HashSet<Integer> hash=new HashSet<Integer>();
                int cntr=0;
               for(int k=0;k<n;k++)
               {
                   
                   if(hash.contains(mat[j][k]))
                   {
                       cntr++;
                       break;
                   }
                   else
                   {
                       hash.add(mat[j][k]);
                   }
               }
               if(cntr>0)
               {
                   countr++;                          
               }
            }
            int countc=0;
             for(int k=0;k<n;k++)
            {
                HashSet<Integer> hash=new HashSet<Integer>();
                int cntc=0;
               for(int j=0;j<n;j++)
               {
                   
                   if(hash.contains(mat[j][k]))
                   {
                       cntc++;
                       break;
                   }
                   else
                   {
                       hash.add(mat[j][k]);
                   }
               }
               if(cntc>0)
               {
                   countc++;                          
               }
            } 
            System.out.println("Case #"+(i+1)+": "+sum+" "+countr+" "+countc);
        }
    }
}