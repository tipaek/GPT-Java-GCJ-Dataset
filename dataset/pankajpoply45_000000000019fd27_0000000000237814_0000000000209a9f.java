import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int tt=1;tt<=t;tt++)
        {
           String str = s.next();
           String result = "";
           int n = 0;
           for(int i=0;i<str.length();i++)
           {
               int x = str.charAt(i)-'0';
               if(x==n)
               {
                   result = result + x;
               }
               if(n<x)
               {
                   for(int k=0;k<x-n;k++)
                   {
                       result = result + "(";
                   }
                   result = result + x;
               }
               if(n>x)
               {
                   for(int k=0;k<n-x;k++)
                   {
                       result = result + ")";
                   }
                   result = result + x;
               }
               n = x;
           }
           for(int i=0;i<n;i++)
            result = result + ")";
           System.out.println("Case #" + tt + ": " + result);
        }
    }
}