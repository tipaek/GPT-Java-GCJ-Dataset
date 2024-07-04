
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
         int t=sc.nextInt();
      int m=t;
      while(t--!=0)
      {
          boolean flag=true;
          int j[]=new int[1500];
          int c[]=new int[1500];
          int n=sc.nextInt();
          StringBuilder s=new StringBuilder();
          int a[][]=new int[n][2];
          for(int i=0;i<n;i++)
          {
             a[i][0]=sc.nextInt();
             a[i][1]=sc.nextInt();
             
          }
          for(int i=0;i<n;i++)
          {
              if(j[a[i][0]+1]==0 && j[a[i][1]-1]==0)
              {
                  for(int k=a[i][0];k<=a[i][1];k++)
                      j[k]=1;
                  s.append("J");
              }
              else if( c[a[i][0]+1]==0 && c[a[i][1]-1]==0 )
              {
                  for(int k=a[i][0];k<=a[i][1];k++)
                      c[k]=1;
              s.append("C");
              }
              else
              {
                  flag=false;
                  break;
              }
          }
          if(flag==false)
              System.out.println("Case #"+(m-t)+": "+"IMPOSSIBLE");
          else
              System.out.println("Case #"+(m-t)+": "+s);
          
       
      }
    }
  }
