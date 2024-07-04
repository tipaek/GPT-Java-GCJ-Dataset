import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Patterns {
	public static void main(String[] args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++)
		{
			int n=Integer.parseInt(br.readLine());
			String s[]=new String[n];
			int length[]=new int[n];
			for(int j=0;j<n;j++)
			{
				s[j]=br.readLine();
				length[j]=s[j].length();
			}
			int max=length[0];
			int position=0;
			for(int j=0;j<n;j++)
			{
				if(length[j]>max)
				{
					max=length[j];
					position=j;
				}
			}
			int location=0;
			int l=0;
			for(int j=0;j<s[position].length();j++)
			{
				char ch=s[position].charAt(j);
				if(ch=='*'&&j==0)
				{
					location=j;
					s[position]=s[position].substring(1);
					l=s[position].length();
				}
			}
			int c=0;
			for(int j=0;j<n;j++)
			{
				String result=" ";
				if(location==0&&j!=position)
				{
					result=s[j].substring(1);
					int len=result.length();
					int compare=s[position].indexOf(result);
					if(l-compare==len)
					{
						c++;
					}
				}
			}
			if(c==n-1)
			{
				System.out.println(s[position]);
			}
			else
				System.out.println("*");
		}
	}
}