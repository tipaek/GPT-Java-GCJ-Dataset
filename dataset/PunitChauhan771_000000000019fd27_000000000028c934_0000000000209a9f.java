import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution
{
    private static Scanner sc;
    static int tn=1;
    
    public static void main(String[] args)
    {
        sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-- > 0)
        {
        solve();
        }
    }
    public static void solve()
    {
    String S=sc.nextLine();
    char[] chars=S.toCharArray();
    StringBuilder sb=new StringBuilder();
    int pairs=0;
    /*for(int i=0;i<chars.length;i++)
    {
        int d=Character.getNumericValue(char[i]);
    }
      pairs=d;
      if(sb.length()==0)
      {
          for(int j=0;j<d;j++)
          sb.append('(');
      }
      sb.append(d);
      for(int j=0;j<n;j++)
      {
          sb.append(')');
      }*/
     
     int num=0;
     int brackets=0;
     int first=Character.getNumericValue(chars[0]);
     num=first;
     brackets=first;
     for(int i=0;i<first;i++)
     {
            sb.append('(');
     }
     sb.append(first);
     for(int i=1;i<chars.length;i++)
     {
     int d=Character.getNumericValue(chars[i]);
            if(d==num)
            sb.append(d);
            else if(d>num)
             {
                /*sb.append('(');
                sb.append(d);
                brackets++;*/
                int diff=d-num;
                for(int j=0;j<diff;j++)
                {
                    sb.append('(');
                    brackets++;
                }
                sb.append(d);
             }
            else
             {
                /*sb.append(')');
                sb.append(d);
                brackets-=(num-d);*/
                int diff=num-d;
                for(int j=0;j<diff;j++)
                {
                    sb.append(')');
                    brackets--;
                    
                }
                sb.append(d);
                
             }
     num=Character.getNumericValue(chars[i]);        
     }
     while(brackets-- >0)
     {
         sb.append(')');
     }
     
    
    System.out.println("Case #"+(tn++)+": "+sb.toString());

        
    } 
    
};