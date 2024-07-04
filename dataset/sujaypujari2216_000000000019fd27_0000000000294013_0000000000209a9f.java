import java.io.*;
import java.math.*;
class Solution
{
	public static void main(String a[])
	{
		try
		{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BigInteger ten = BigInteger.TEN;
		int cnt=Integer.parseInt(br.readLine());
		for(int j=1;j<=cnt;j++)
		{
		String name = br.readLine(); 
		StringBuilder sb=new StringBuilder(name);  
		sb.reverse();  
		BigInteger number=new BigInteger(sb.toString());
		BigInteger modnum=new BigInteger("0");
		BigInteger n1=number;
		int open=0,num=0;
		String op="";
		for(int i=0,len=name.length();i<len;i++)
		{
			modnum=n1.mod(ten);
			num=modnum.intValue();
			//System.out.println(modnum+" " +n1+" "+ten);
			n1=n1.divide(ten);
			if(open<num)
				while(open!=num)
				{
					open++;
					op+="(";
				}
			if(open>num)
				while(open!=num)
				{
					open--;
					op+=")";
				}
			if(open==num)
				op+=num;
		}
		while(open!=0)
		{
			op+=")";
			open--;
		}
		System.out.println("Case #"+j+": "+op);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}