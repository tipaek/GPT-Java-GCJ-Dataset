import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
      int n;
      Scanner sc=new Scanner(System.in);
      n=sc.nextInt();
      String output[]=new String[n];
      String s="";
      int st=0;
      String x[]=new String[n];
      for(int i=0;i<n;i++)
      {
          x[i]=sc.next();
          int l=x[i].length();
          for(int j=0;j<l;j++)
          {
              if(x[i].charAt(j)=='0')
              {
                 while(st>0)
                 {
                     s=s+")";
                     st--;
                 }
              }else
              {
                  //x[i] not 0
                  
                      if(st==0)
                      {
                          s=s+"(";
                          st++;
                          
                      }
                   }
              s=s+x[i].charAt(j);
             
          }
          while(st>0)
          {
              s=s+")";
              st--;
          }
                output[i]=s;
                s="";

      }
      for(int i=0;i<n;i++)
      {
      System.out.println(" Case #"+(i+1)+": "+output[i]);        
      }
    }
}