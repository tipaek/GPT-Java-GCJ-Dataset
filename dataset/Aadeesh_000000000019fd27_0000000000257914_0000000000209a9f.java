import java.util.*;
import java.io.*;
public class Solution
{
    
  public static void main(String[] args) throws Exception
  {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    
    in.nextLine();
    for (int k = 1; k <= t; ++k)
    {
       
      String s=in.nextLine();
      String str=s;
      
      int depth=0;
      
      for(int i=0;i<str.length();i++)
      {
        if(str.charAt(i)!=')' && str.charAt(i)!='(' )
          {
              int num=Character.getNumericValue(str.charAt(i));
              String str1="";
              if(num==0)
              {
                  if(depth>0)
                  {
                  for(int j=0;j<depth;j++)
                  {
                      str1+=")";
                  }
                  depth=num;
                  }
                  str=str.substring(0,i) +str1+
                           str.substring(i,i+1)
                           + str.substring(i + 1);
              }
              else
              {
                  if(depth>num)
                  {
                      for(int j=0;j<depth-num;j++)
                      {
                          str1+=")";
                      }
                      
                  }
                  if(depth<num)
                  {
                      for(int j=0;j<num;j++)
                      str1+="(";
                  }
                  str=str.substring(0,i) +str1+
                           str.substring(i,i+1)
                           + str.substring(i + 1);
                           
                           depth=num;
              }
              
              depth=num;
            
          }
        //   str=nstr;
      }
      for(int i=0;i<depth;i++)
      str+=")";
      
      System.out.println("Case #" + k + ": " + str.toString());
    }
  }
}