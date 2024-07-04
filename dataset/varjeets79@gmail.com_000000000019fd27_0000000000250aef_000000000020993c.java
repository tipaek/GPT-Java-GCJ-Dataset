import java.io.*;
import java.util.*;
 class Solution
{
    public static void main(String args[])
    {
        
       Scanner sc=new Scanner(System.in);
        int t=0,n=0;
        int dsum=0,rows=0,col=0;
        int arr[][];
        HashSet<Integer> hs=new HashSet<>();
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            rows=0;
            col=0;
            dsum=0;
            n=sc.nextInt();
            arr=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    arr[j][k]=sc.nextInt();
                }
            }
        
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                     if(j==k)
                     {
                         dsum=dsum+arr[j][k];
                     }
                     
                }
                
            }
            
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                     if(hs.contains(arr[j][k]))
                     {
                         rows=rows+1;
                        
                         break;
                     }
                     else
                     {
                         hs.add(arr[j][k]);
                     }
                     
                }
                hs.clear();
               
            }
            
            
              for(int j=0;j<n;j++)
            {
                
                for(int k=0;k<n;k++)
                {
                     if(hs.contains(arr[k][j]))
                     {
               
                         col=col+1;
                         break;
                     }
                     else{
                         hs.add(arr[k][j]);
                       }
                }
                     hs.clear();               
               
            }
    
           System.out.println("Case #"+(i+1)+": "+dsum+" "+rows+" "+col+"");
            
        }
       
       
        
    }
}