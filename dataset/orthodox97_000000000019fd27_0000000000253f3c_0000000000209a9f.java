
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
      if(ch[j]=='1' && t1!=1)
      {
       System.out.print('(');
       t1=1;
       }
       else if(ch[j]=='0' && t1==1)
      {
       System.out.print(')');
       t1=0;
       }
       System.out.print(ch[j]);
     }
       if(t1==1)
       System.out.print(')');
       System.out.println();
    }
 }
}