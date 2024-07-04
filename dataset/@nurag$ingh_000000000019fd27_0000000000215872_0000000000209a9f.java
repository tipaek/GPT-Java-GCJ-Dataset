import java.util.*;

public class Solution
{
   public static void main(String args[])
   {
      Scanner in=new Scanner(System.in);
      int t=in.nextInt();
      for(int rr=0;rr<t;rr++)
      {
         String str=in.next();
         int count=0;
         ArrayList<Integer> l=new ArrayList<Integer>();
         for(int i=0;i<str.length();i++)
         {
           l.add(new Integer(str.charAt(i)+""));
         }
         String ans="";
         for(int i=0;i<l.size();i++)
         {
            int a=l.get(i);
            if(count<a)
            {
               int temp=a-count;
               count=count+temp;
               for(int j=0;j<temp;j++)
               {
                ans=ans+"(";
               }
               ans=ans+a;
            }
            else if(count>a)
            {
               int temp=count-a;
               count=count-temp;
               for(int j=0;j<temp;j++)
               {
                ans=ans+")";
               }
               ans=ans+a;
            }
            else
            {
              ans=ans+a;
            }
         }
         for(int i=0;i<count;i++)
           ans=ans+")";
           
         System.out.println("Case #"+(rr+1)+": "+ans);
      }
   }
}