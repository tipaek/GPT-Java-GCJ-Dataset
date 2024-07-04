import java.util.*;
class Solution{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        int count = 1;
        while(test-->0)
        {
            String str = s.next();
            int pt = 0;
            System.out.print("Case #"+count+": ");
            count++;
            for(int i=0;i<str.length();i++)
            {
               int no = str.charAt(i)-48;
               if(no==pt)
            	   System.out.print(no);
               else if(no>pt)
               {
            	   while(no>pt)
            	   {
            		   System.out.print("(");
            		   pt++;
            	   }
            	   System.out.print(no);
               }
               else
               {
            	   while(no<pt)
            	   {
            		   System.out.print(")");
            		   pt--;
            	   }
            	   System.out.print(no);
               }
            }
            while(pt!=0)
            {
            	System.out.print(")");
            	pt--;
            }
            System.out.println();
        }
    }
}