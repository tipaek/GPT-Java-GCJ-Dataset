import java.util.*;
import java.io.*;
class xyz
{
    public static void main(String[] args)throws IOException
    {
   Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   
   for(int i=1;i<=n;i++)
   {
          int sum=0;
          int d=0;
          int f=0;
          int v=0;
          int c=0;
          int x=sc.nextInt();
          int[][] a=new int[n][n];
          
          for(int p=0;p<n;p++)
          {
                 for(int q=0;q<n;p++)
                 {
                        a[p][q]=sc.nextInt();
                 }
          }
          
          
          for(int p=0;p<n;p++)
          {
                 sum+=a[p][p];
          }
          
          for(int p=0;p<n;p++)
          {
                 int u=a[f][p];
                 int flag=0;
                 for(int q=0;q<n;q++)
                 {
                      if(q==p)
                      continue;
                      else
                      {
                         if(a[f][q]==u)
                         {
                                flag=1;
                                break;
                         }
                      }
                 }
                 f++;
                 if(flag==1)
                 {
                        v++;
                        continue;
                 }
               
          }
          
          f=0;
          for(int p=0;p<n;p++)
          {
                 int u=a[p][f];
                 int flag=0;
                 for(int q=0;q<n;q++)
                 {
                      if(q==p)
                      continue;
                      else
                      {
                         if(a[q][f]==u)
                         {
                                flag=1;
                                break;
                         }
                      }
                 }
                 f++;
                 if(flag==1)
                 {
                        c++;
                        continue;
                 }
               
          }
          
          System.out.println("#"+n+": "+sum+" "+v+" "+c);
          
                  
           }
    }
}
