import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int trace=0;
            int a[][]=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    a[j][k]=sc.nextInt();
                    if(j==k)
                    {
                        trace=trace+a[j][k];
                    }
                }
            }
            int row=0,col=0;
            for(int j=0;j<n;j++)
            {
                inner:
                for(int k=0;k<n-1;k++)
                {
                    for(int l=k+1;l<n;l++)
                    {
                        if(a[j][k]==a[j][l])
                        {
                            row++;
                            break inner;
                        }
                    }
                }
            }
            
            for(int j=0;j<n;j++)
            {
                outer:
                for(int k=0;k<n-1;k++)
                {
                    for(int l=k+1;l<n;l++)
                    {
                        if(a[k][j]==a[l][j])
                        {
                            col++;
                            break outer;
                        }
                    }
                }
            }
            
            
          System.out.println("Case #"+(i+1)+": "+trace+" "+row+" "+col);  
            
        }
        
        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}