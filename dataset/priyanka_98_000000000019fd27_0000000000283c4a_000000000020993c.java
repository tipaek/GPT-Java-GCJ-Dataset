import java.io.*;
import java.util.*;


public class Solution{
    public static void main(String[] args)throws Exception
    {
        Scanner sc=new Scanner(System.in);
        
        int t=sc.nextInt();
         
        for(int g=1;g<=t;g++)
        {
             int n=sc.nextInt();
        
             int[][] a=new int[n][n];
        
          int sum=0;
             for(int i=0;i<n;i++)
             {
                   for(int j=0;j<n;j++)
                     {
                           a[i][j]=sc.nextInt();
                           
                          
                     }
              }
              
              for(int i=0;i<n;i++)
                sum+=a[i][i];
                
                
              
              int num_r=0;
              
              int num_col=0;
              
              
              for(int i=0;i<n;i++)
              {
                  HashSet<Integer> hs=new HashSet<>();
                  for(int j=0;j<n;j++)
                  {
                      
                        hs.add(a[i][j]);
                  }
                  
                  if(hs.size()!=n)
                    num_r+=1;
              }
              
              int[][] b=new int[n][n];
              
              for(int i=0;i<n;i++)
              {
                  for(int j=0;j<n;j++)
                     b[i][j]=a[j][i];
              }
              
              for(int i=0;i<n;i++)
              {
                  
                  HashSet<Integer> hs=new HashSet<>();
                  for(int j=0;j<n;j++)
                  {
                      
                      
                      hs.add(b[i][j]);
                  }
                  
                  if(hs.size()!=n)
                    num_col++;
                  
                  
              }
              
              System.out.println("Case #"+g+": "+sum+" "+num_r+" "+num_col);
              
              
        
        }
        
        
        
    }
}