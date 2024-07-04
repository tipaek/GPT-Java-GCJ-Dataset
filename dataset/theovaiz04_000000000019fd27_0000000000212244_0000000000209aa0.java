import java.util.*;
class Main
{
 public static void main(String args[])
   {
      try
      {
       Scanner sc=new Scanner(System.in);
      Integer t,x;
      x=1;
      t=sc.nextInt();
      while(x<=t)
       {
         Integer n,k;
         n=sc.nextInt();
         k=sc.nextInt();
         if(n/k==2 || n%k==0)
           System.out.println("Possible");
         else
           System.out.println("Imossible");
         x++;
       }  
      }
      catch(Exception e)
      {
          
      }
   }
}