import java.util.*;
import java.io.*;
public class Solution {

	public static String get(int n,int flag)
	{
		String out="";
		if (flag==0)
			{
			for (int i=0;i<n;i++)
				{
					out+=")";
				}
			}
		else 
		{
			for (int i=0;i<n;i++)
				{
					out+="(";
				}
		}
		return out;
	}
  public static String newsted(String s)
	{
		int curr;
		int next;
		String out;
		int[] arr = new int[s.length()];

		for (int i=0;i<s.length();i++)
		{
			arr[i]=Integer.parseInt(Character.toString(s.charAt(i)));
		}
		curr=arr[0];
		out=get(curr,1)+Integer.toString(curr);
		int rems=curr;
		for (int i=1;i<arr.length;i++)
		{
			next=arr[i];
			if (next<curr)
			{
				out+=get(curr-next,0)+Integer.toString(next);
				rems=rems-(curr-next);
			}
			else if (curr<next)
			{
				out+=get(next-curr,1)+Integer.toString(next);
				rems=rems-(curr-next);	
			}
			else out+=Integer.toString(next);
			curr=next;
		}
		out+=get(rems,0);
		return out;
	}

	public static void main(String args[]) 
	{
		String out="";
		String temp;
		Scanner s= new Scanner(System.in);
		int T = s.nextInt();
		s.nextLine();
		String str;
		for (int t=0;t<T;t++)
		{
			str=s.nextLine();
			temp=newsted(str);
			if (t!=T-1) out+="Case #"+(t+1)+": "+temp+"\n";
			else out+="Case #"+(t+1)+": "+temp;
		}
		System.out.println(out);
	}
}