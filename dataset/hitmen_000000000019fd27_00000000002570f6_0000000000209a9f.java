import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        String s;
        int count =0;
        for(int i=0;i<t;i++)
        {
            System.out.print("Case #"+(i+1)+": ");
            count=0;
           s=sc.next();
           char[] ch = s.toCharArray();
           //System.out.println(s);
           for(int j=0;j<s.length();j++)
           {
               int n=Character.getNumericValue(ch[j]);
               if(count<n)
               {
                   while(count<n)
                   {
                   System.out.print("(");
                   count+=1;
                   }
               }
               else if(n<count)
               {
                   while(n<count)
                   {
                        System.out.print(")");
                        count-=1;
                   }
               }
               System.out.print(s.charAt(j));
            }
               while(count>0)
               {
                 System.out.print(")");
                        count-=1;  
               }
                System.out.println(); 
               }
           }
}
