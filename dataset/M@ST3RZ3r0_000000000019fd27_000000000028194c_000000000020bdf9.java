import java.util.*;
import java.io.*;
class Solution
{
	public static String scheduling(int A[][])
	{
		String schedule="";
		String l[]=new String[A.length];
		l[0]="C";
		for (int i=1;i<l.length;i++)
		{
			if (A[i][0]>=A[i-1][1])
			   l[i]="C";
		}
        for (int i=1;i<l.length;i++)
		{
			if (l[i]==null)
			   l[i]="J";
		}
		for (int i=0;i<l.length;i++)
		    schedule+=l[i];
		return schedule;
	}
	public static void main(String[] args) 
	{
	   Scanner input=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	   int T=input.nextInt();
	   if ((T<1)&&(T>100))
	     return ;
	   for (int i=0;i<T;i++)
	   {
		  int N=input.nextInt();
		  if ((N<2)&&(N>1000))
		    return;
		  int A[][]=new int[N][2];
		  for (int j=0;j<A.length;j++)
		  {
			  A[j][0]=input.nextInt();
			  A[j][1]=input.nextInt();
			  if ((A[j][0]<0)&&((A[j][0]>=A[j][1])||(A[j][0]>1440)))
			     return ;
              else if (((A[j][1]<0)||(A[j][1]<A[j][0]))&&((A[j][1]>1440)))
			     return ;
		  }
		  System.out.println("Case #"+(i+1)+": "+scheduling(A));
	   }
	   return ;
	}
}