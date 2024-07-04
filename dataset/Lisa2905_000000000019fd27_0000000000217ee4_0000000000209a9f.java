import java.util.*;
class nest
{
   public static void main()
   {
       Scanner in=new Scanner(System.in);
       System.out.println("enter no.");
       int T=in.nextInt();
       for(int i=1;i<=T;i++)
       {
           String s=in.nextLine();String q="";
           int w=Integer.parseInt(s);
           while(w>0)
           {
               int d=w%10;w=w/10;
               for(int y=1;y<=d;y++)
               q=q+"(";
               q=q+d;
                for(int y=1;y<=d;y++)
               q=q+")";
           }
           System.out.println(q);
       }
   }
}