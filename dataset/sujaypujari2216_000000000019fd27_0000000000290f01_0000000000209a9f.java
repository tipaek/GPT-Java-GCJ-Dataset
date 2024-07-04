import java.io.*;
class Solution
{
	public static void main(String a[])
	{
		try
		{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cnt=Integer.parseInt(br.readLine());
		for(int j=1;j<=cnt;j++)
		{
		String name = br.readLine(); 
		StringBuilder sb=new StringBuilder(name);  
		sb.reverse();  
		int number=Integer.parseInt(sb.toString());
		int n1=number,num=0,open=0;
		String op="";
		for(int i=0,len=name.length();i<len;i++)
		{
			num=n1%10;
			n1/=10;
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