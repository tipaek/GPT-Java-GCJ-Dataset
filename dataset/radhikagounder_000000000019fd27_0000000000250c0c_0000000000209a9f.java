import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner s= new Scanner(System.in);
        int T=s.nextInt();
        s.nextLine();
        for(int t=0;t<T;t++)
        {
            String str=s.nextLine();
            StringBuilder sb=new StringBuilder();
            int c=0;
            for(int i=0;i<str.length();i++)
               {
                   if(str.charAt(i)=='0')
                   {   if(c>0)
                       {
                           sb.append("(");
                           for(int j=0;j<c;j++)
                           {
                               sb.append("1");
                               
                           }
                           c=0;
                           sb.append(")");
                       }
                       sb.append("0");
                       continue;
                   }
                   if(str.charAt(i)=='1')
                   {
                       c++;
                   }
                   
               }
               if(c!=0)
                       {
                           sb.append("(");
                           while(c-->0)
                           sb.append("1");
                           
                           sb.append(")");
                       }
          System.out.println("Case #"+(t+1)+":"+" "+sb.toString());  
        }
    }
}