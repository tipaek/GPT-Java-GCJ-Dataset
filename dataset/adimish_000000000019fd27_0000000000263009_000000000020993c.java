import java.util.*;
import java.io.*;
public class Vestigium{
    public static void main(String[] args)
 {
        
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i=0;i<t;i++)
    {
        int n = sc.nextInt();
        int [][]arr = new int[n][n];
        int trace =0;
        
        for(int j=0;j<n;j++)
        {
            for(int k=0;k<n;k++)
            {
               arr[j][k]=sc.nextInt(); 
               if(j==k)
               trace = trace+arr[j][k];
            }
        }
        int r =0;
        int c=0;
        for(i=0;i<n;i++)
        {   
            int tmp[] = new int[n];
            for(int j=0;j<n;j++)
            tmp[j]=j+1;
            
            int dup =0;
            for(int j=0;j<n;j++)
            {
              dup = arr[i][j];
              if(arr[i][j]==tmp[dup])
              tmp[dup]=0;
              else
              {
                  r++;
                  break;
              }
            }
            for(int j=0;j<n;j++)
            tmp[j]=j+1;
            for(int j=0;j<n;j++)
            {
               dup = arr[j][i];
               if(arr[j][i]==tmp[dup])
               tmp[dup]=0;
               else
               {
                   c++;
                   break;
               }
            }
        }
        System.out.print(trace+" "+r+" "+c);
    }
  }
}