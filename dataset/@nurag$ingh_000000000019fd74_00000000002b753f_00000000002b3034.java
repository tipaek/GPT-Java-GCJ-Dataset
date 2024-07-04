import java.util.*;

public class Solution
{
   public static void main(String args[])
   {
      Scanner in=new Scanner(System.in);
      int t=in.nextInt();
      for(int k=0;k<t;k++)
      {
         int n=in.nextInt();
         ArrayList<String> l=new ArrayList<String>();
         int max=0;
         for(int i=0;i<n;i++)
         {
             String temp=new String(new StringBuffer(in.next()).reverse());
             if(temp.length()>max)
              {
                  max=temp.length();
              }
           l.add(temp);
          // System.out.println(temp);
         }
         String str="";
         int count=0;
         int flag=0;
         
         while(l.isEmpty()!=true)
         {
             char ch='8';
            for(int j=0;j<l.size();j++)
            {
                if(l.get(j).charAt(count)=='*')
                {
                    l.remove(j);
                }
                else
                {
                  char  le=l.get(j).charAt(count);
                //  System.out.println(le);
                   if(ch=='8')
                   {
                       ch=le;
                   }
                   else if(ch!=le)
                   {
                       flag=1;
                       break;
                   }
                }
            }
            count++;
            if(count==max)
            {
                break;
            }
            str=str+ch;
            if(str.length()==10000)
            {
                break;
            }
           if(flag==1)
           {
               break;
           }
         }
         
         if(flag==1)
         System.out.println("Case #"+(k+1)+": "+"*");
         else
          System.out.println("Case #"+(k+1)+": "+((new StringBuffer(str))).reverse());

         
      }
   }
}