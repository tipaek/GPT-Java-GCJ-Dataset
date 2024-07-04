import java.util.*;
import java.io.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        int c=1;
        while(t>0)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int trace=0;
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    a[i][j]= sc.nextInt();
                    
                    if(i==j)
                    {
                        trace+=a[i][j];    //calculating trace
                    }
                }
                
            }  //taking input
            
            System.out.println("Case #" +c +": " +trace +" "+countrows(a,n) +" "+countcol(a,n));
            c++; t--;
        }// while loop closing
      
        
    }  //closing of main
    
    
    public static int countrows(int a[][], int n)
    {
        boolean flag;
        int count=0;
        for(int i=0; i<n; i++)
        {
            flag=false;
            for(int j=0; j<n-1; j++)
            {
                int first = a[i][j];
                for(int k=j+1; k<n; k++)
                {
                    if(first==a[i][k])
                    {
                        count++;
                        flag=true;
                        break;
                    }
                }//closing k loop
                
                if(flag==true)
                {
                    break;
                }
            }//closing j loop

            
        }
        
        return count;
        
    }// countrows closing
    
    
    public static int countcol(int a[][], int n)
    {
        boolean flag;
        int count=0;
        for(int i=0; i<n; i++)
        {
            flag=false;
            for(int j=0; j<n-1; j++)
            {
                int first = a[j][i];
                for(int k=j+1; k<n; k++)
                {
                    if(first==a[k][i])
                    {
                        count++;
                        flag=true;
                        break;
                    }
                }//closing k loop
                
                if(flag==true)
                {
                    break;
                }
            }//closing j loop

            
        }
        
        return count;
        
    }// countcol closing
}