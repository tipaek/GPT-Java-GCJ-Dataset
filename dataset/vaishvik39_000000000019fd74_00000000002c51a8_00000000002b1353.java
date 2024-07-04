import java.util.*;
import java.io.*; 
import java.lang.*;
public class Solution
{
    public static void main(String args[])
    {
        int i,j,k,l,m=0,n,x=0,y=0,s=0,f=0;
        long r = 0;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] arr = new int[1000][1000];  
  

for (int line = 0; line < 999; line++) 
{ 
     
    for ( i = 0; i <= line; i++) 
    { 
    
    if (line == i || i == 0) 
        arr[line][i] = 1; 
    else 
        arr[line][i] = arr[line-1][i-1] + arr[line-1][i]; 
   
    } 
    
} 
        for(k=0;k<t;k++)
        {
            i=0;
            j=0;

            n=sc.nextInt();
           int result = (int)(Math.log(n) / Math.log(2)); 
            while((n!=0)&&(i<990)&&(j<990))
            {
                
               
               n=n-arr[i][j];
               System.out.println((i+1) +" "+ (j+1));
              if((i<998)&&(arr[i+1][j]<=n)&&n>=0&&f!=1)
              {
               i=i+1;
               j=j;
               f=1;
               
              }
              else if((i<998)&&(j<998)&&(arr[i+1][j+1]<=n)&&n>=0&&f!=0)
              {
                  i=i+1;
                  j=j+1;
                  f=0;
              }
              else if((j<998)&&(arr[i][j+1]<=n)&&n>=0)
              {
                  i=i;
                  j=j+1;
              }
              else if((j>0)&&(arr[i][j-1]<=n)&&n>=0)
              {
                  i=i;
                  j=j-1;
              }
              else if((i>0)&&(arr[i-1][j]<=n)&&n>=0)
              {
                  i=i;
                  j=j+1;
              }
               
               else
               {
                   i--;
                   j--;
               }
            }
           
           
           
            
        }
    }
}