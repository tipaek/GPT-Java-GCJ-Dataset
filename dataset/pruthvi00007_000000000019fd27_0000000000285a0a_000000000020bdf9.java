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
             for(int k=a[i][0]+1;k<a[i][1];k++)
             {
                 if(c[k]==1)
                     flag=false;
                     
             }
             if(flag==true)
             {
                 //System.out.println("c"+i);
                 for(int k=a[i][0];k<=a[i][1];k++)
             {
                c[k]=1;
                     
             }
                 
                 s.append("C");
                 
             }
             else
             {
                    for(int k=a[i][0]+1;k<a[i][1];k++)
             {
                 if(j[k]==1)
                     flag1=false;
                     
             }
                    if(flag1==false)
                    {
                        //System.out.println("br");
                      flag2=false;  
                      break;
                    }
                    else
                    {      //System.out.println("j"+i); 
                           for(int k=a[i][0];k<=a[i][1];k++)
                              {
                                  j[k]=1;
                     
                                    }
                           s.append("J");
                        
                    }
                    
             }
             if(flag2==false)
                 break;
             flag1=true;
             flag=true;
             
          }
               
          if(flag2==false )
              System.out.println("Case #"+(m-t)+": "+"IMPOSSIBLE");
          else
              System.out.println("Case #"+(m-t)+": "+s);
          
       
      }
    }
  }
