/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    public static void main (String[] args) throws java.lang.Exception
    {
      Scanner sc= new Scanner(System.in);
      int t=sc.nextInt();
      int b=sc.nextInt();
      while(t-->0)
      {
          StringBuilder s1=new StringBuilder();
          for(int i23=0;i23<10;i23++)
          {
              char ch2;
              System.out.println(i23+1);
              System.out.flush();
              ch2=sc.next().charAt(0);
              s1.append(ch2);
          }
          System.out.println(s1);
          System.out.flush();
          char cr;
          cr=sc.next().charAt(0);
          if(cr=='N'||cr=='n') break;
      }

    }


}
