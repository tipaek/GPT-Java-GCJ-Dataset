import java.util.*;
import java.io.*;
class Solution
{   public static String popBrackets(String str)
    { int flag=1;
       if(str.length()==1)
       return str;
       for(int i=0;i<str.length()-2;i++)
        {
          if(str.charAt(i)==')'&&str.charAt(i+1)=='(')
           {
             str=str.substring(0,i)+str.substring(i+2,str.length());
             flag=0;
             break;
           }
        }
      if(flag==0)
      return popBrackets(str);
      else
      return str;
    }
    public static void main(String ar[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tcases=Integer.parseInt(br.readLine());
        int item;
        for(int t=0;t<tcases;t++)
        {
            String str=br.readLine();
            String ans="";
            int arr[]=new int[str.length()];
            for(int i=0;i<str.length();i++)
            {   
                item=Character.getNumericValue(str.charAt(i));
                arr[i]=item;
                 for(int j=0;j<item;j++)
                 { 
                    ans+="(";
                 }
                 ans+=""+item;         
                 for(int k=0;k<item;k++)
                 { 
                    ans+=")";
                 }
            }
         ans=""+popBrackets(ans);
         System.out.println("Case #"+(t+1)+": "+ans);
        }
    }
}