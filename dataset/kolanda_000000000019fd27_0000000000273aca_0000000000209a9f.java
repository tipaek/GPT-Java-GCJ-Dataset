import java.util.*;

public class Solution {

	public static String remove(String pass)
	{
		char[] sarr= pass.toCharArray();

		String resarr="";
		int i;
		for(i=0;i<sarr.length-2;i++)
		{
			resarr="";
			if(sarr[i]==')' && (sarr[i+1]=='('))
			{
				resarr = resarr+pass.substring(0,i)+pass.substring(i+2,pass.length());
				sarr   = resarr.toCharArray();
				pass   = resarr;
				i=0;
			}
		}
		return pass;
	}
	public static String add(String pass)
	{
		int n1=Integer.parseInt(pass);
		String res="";
		res=res+pass;
		if (n1==0)
		{
			return "0";
		}
		else
		{
			for(int i=0;i<n1;i++)
			{
				res="("+res+")";
			}
		}
		return res;
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int tc;
		ArrayList fin = new ArrayList();
		tc=sc.nextInt();
		for(int t=0;t<tc;t++)
		{
			String s=sc.next();
			String result="";
			for(int i=0;i<s.length();i++)
			{
				String pass=s.substring(i,i+1);
				String res=add(pass);
				result=result+res;
			}
			String rres= remove(result);
			fin.add(rres);
		}
		for(int z=0;z<fin.size();z++)
		{
			System.out.println("Case #"+(z+1)+": " +fin.get(z));
		}
	}
}
