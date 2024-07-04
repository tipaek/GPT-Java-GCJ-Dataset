
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
       int t=sc.nextInt();
      int m=t;
      while(t--!=0)
      {
          boolean flag1=true , flag2=true , flag=true;
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
             // System.out.println(c[20]+" "+j[20]);
                if( c[a[i][0]+1]==0 && c[a[i][1]-1]==0 )
              {
                  for(int k=a[i][0]+1;k<=a[i][1];k++)
                  {
                     
                      if(c[k]==1)
                      {
                         // System.out.println("s");
                          flag1=false;
                         
                      }
                    
                  }
                  if(flag1==true){
                     // System.out.println("lkjh");
                       for(int k=a[i][0];k<=a[i][1];k++)
                  {
                      
                      c[k]=1;
                        
                  }
                       s.append("C");
                       flag1=true;
                  }
          
              }
             else if(j[a[i][0]+1]==0 && j[a[i][1]-1]==0)
              {
                  for(int k=a[i][0]+1;k<=a[i][1];k++)
                      
                  {
                       if(j[k]==1)
                      {
                          flag2=false;
                         
                      }
                     
                  }
                  if(flag2==true)
                  {
                    for(int k=a[i][0];k<=a[i][1];k++)
                      
                  {
                      j[k]=1;
                     
                  } 
                    s.append("J");
                    flag2=true;
                  }
                  
              }
             
              else
              {
                  flag=false;
                  break;
              }
          }
          if(flag==false || (!flag1&& !flag2))
              System.out.println("Case #"+(m-t)+": "+"IMPOSSIBLE");
          else
              System.out.println("Case #"+(m-t)+": "+s);
          
       
      }
    }
  }
