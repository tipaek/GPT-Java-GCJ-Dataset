import java.util.*;
import java.io.*;
class Vestigium{
    public static void main(String[] args)
 {
     //System.out.println("no.of testcases");   
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
        for(int k=0;k<n;k++)
        {   
            int tmp[] = new int[n];
            for(int j=0;j<n;j++)
            tmp[j]=j+1;
            
            int dup =0;
            for(int j=0;j<n;j++)
            {
              dup = arr[k][j];
              if(arr[k][j]==tmp[dup-1])
              tmp[dup-1]=0;
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
               dup = arr[j][k];
               if(arr[j][k]==tmp[dup-1])
               tmp[dup-1]=0;
               else
               {
                   c++;
                   break;
               }
            }
        }
        System.out.println(trace+" "+r+" "+c);
    }
  }
}