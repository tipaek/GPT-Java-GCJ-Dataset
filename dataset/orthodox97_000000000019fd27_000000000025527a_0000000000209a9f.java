
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args)
	{
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int i=0;i<t;i++)
    {
     String n=sc.next();
     char ch[]=n.toCharArray();
     int l=n.length();
     int t1=0;
     System.out.print("Case #"+(i+1)+": ");
     for(int j=0;j<l;j++)
     {
      int num=Character.getNumericValue(ch[j]);
      if(t1<num)
      {
       while(t1<num)
       {
       System.out.print('(');
       t1++;
       }
       }
       else if(t1>num)
      {
       while(t1>num)
       {
       System.out.print(')');
       t1--;
       }
      }
       System.out.print(ch[j]);
     }
       while(t1!=0)
       {
         System.out.print(')');
       t1--;
       }
       System.out.println();
    }
 }
}