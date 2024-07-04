package gkg;
import java.util.*;
class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int ncount = 1;
        while(test-->0)
        {
            String str = sc.next();
            int pcount = 0;
            System.out.print("Case #"+ncount+": ");
            ncount++;
            for(int i=0;i<str.length();i++)
            {
               int nein = str.charAt(i)-48;
               if(nein==pcount)
            	   System.out.print(nein);
               else if(nein>pcount)
               {
            	   while(nein>pcount)
            	   {
            		   System.out.print("(");
            		   pcount++;
            	   }
            	   System.out.print(nein);
               }
               else
               {
            	   while(nein<pcount)
            	   {
            		   System.out.print(")");
            		   pcount--;
            	   }
            	   System.out.print(nein);
               }
            }
            while(pcount!=0)
            {
            	System.out.print(")");
            	pcount--;
            }
            System.out.println();
        }
    }
}