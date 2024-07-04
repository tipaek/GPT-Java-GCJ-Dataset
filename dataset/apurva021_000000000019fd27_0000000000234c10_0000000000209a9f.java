import java.io.*;
import java.util.*;
import java.math.*;

class Solution
{
	public static void main(String []args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		PrintWriter w = new PrintWriter(System.out);
		int tc=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;++t)
		{
			char ch[]= br.readLine().toCharArray();
			int n=ch.length;
			StringBuilder ans = new StringBuilder();
			
			for(int i=0;i<(ch[0]-'0');++i) ans.append("(");
			ans.append(ch[0]);
			
			
			for(int i=1;i<n;++i)
			{
				if(ch[i]>ch[i-1])
				{
					//for(int j=0;j<(ch[i-1]-'0');++j) ans.append(")");
					for(int j=0;j<(ch[i]-ch[i-1]);++j) ans.append("(");
				}
				else if(ch[i]<ch[i-1])
				{
					int diff=ch[i-1]-ch[i];
					for(int j=0;j<diff;++j) ans.append(")");
				}
				
				ans.append(ch[i]);
			}
			
			for(int i=0;i<(ch[n-1]-'0');++i) ans.append(")");
			
			w.println("Case #"+t+": "+ans);
		}
		
		w.flush();
		w.close();
	}
}