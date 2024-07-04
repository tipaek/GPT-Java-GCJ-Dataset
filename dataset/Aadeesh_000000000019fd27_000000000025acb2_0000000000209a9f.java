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
      String str="";
      String newstr=s;
      
      int depth=0,depth1=0;
      
      for(int i=0;i<s.length();i++)
      {
          String num=Character.toString(s.charAt(i));
          int dep1=s.charAt(i)-'0';
          
          while(dep1>depth)
          {
              str+="(";
              depth++;
          }
          while(dep1<depth)
          {
              str+=")";
              depth--;
          }
          
          str+=num;
            if(newstr.charAt(i)!=')' && newstr.charAt(i)!='(' )
          {
              int numm=Character.getNumericValue(str.charAt(i));
              String str1="";
              if(numm==0)
              {
                  if(depth1>0)
                  {
                  for(int j=0;j<depth1;j++)
                  {
                      str1+=")";
                  }
                  depth1=numm;
                  }
                  newstr=newstr.substring(0,i) +str1+
                          newstr.substring(i,i+1)
                          + newstr.substring(i + 1);
              }
              else
              {
                  if(depth1>numm)
                  {
                      for(int j=0;j<depth1-numm;j++)
                      {
                          str1+=")";
                      }
                      
                  }
                  if(depth1<numm)
                  {
                      for(int j=0;j<numm;j++)
                      str1+="(";
                  }
                  newstr=newstr.substring(0,i) +str1+
                          newstr.substring(i,i+1)
                          + newstr.substring(i + 1);
                           
                          depth1=numm;
              }
              
            //   depth=num;
            
          }
        //   str=nstr;
      }
          while(depth>0)
          {
              str+=")";
              depth--;
          }
        // if(str.charAt(i)!=')' && str.charAt(i)!='(' )
        //   {
        //       int num=Character.getNumericValue(str.charAt(i));
        //       String str1="";
        //       if(num==0)
        //       {
        //           if(depth>0)
        //           {
        //           for(int j=0;j<depth;j++)
        //           {
        //               str1+=")";
        //           }
        //           depth=num;
        //           }
        //           str=str.substring(0,i) +str1+
        //                   str.substring(i,i+1)
        //                   + str.substring(i + 1);
        //       }
        //       else
        //       {
        //           if(depth>num)
        //           {
        //               for(int j=0;j<depth-num;j++)
        //               {
        //                   str1+=")";
        //               }
                      
        //           }
        //           if(depth<num)
        //           {
        //               for(int j=0;j<num;j++)
        //               str1+="(";
        //           }
        //           str=str.substring(0,i) +str1+
        //                   str.substring(i,i+1)
        //                   + str.substring(i + 1);
                           
        //                   depth=num;
        //       }
              
        //     //   depth=num;
            
        //   }
        // //   str=nstr;
     
    //   for(int i=0;i<depth;i++)
    //   str+=")";
      
      System.out.println("Case #" + k + ": " + str);
    }
  }
}