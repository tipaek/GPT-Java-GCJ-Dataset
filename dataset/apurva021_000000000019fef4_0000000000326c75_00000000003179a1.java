import java.io.*;
import java.util.*;
import java.math.*;

class Solution
{
	public static void main(String []args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;++t)
		{
			int u=Integer.parseInt(br.readLine());
			
			int a[]= new int[26];
			Arrays.fill(a,10000);
			boolean visited[]= new boolean[26];
			
			/*ArrayList<String> input = new ArrayList<>();
			
			while(true)
			{
				String temp=br.readLine();
				if(temp.length()==0) break;
				
				input.add(temp);
			}
			*/
			
			for(int i=0;i<10000;++i)
			{
				String in[]= br.readLine().split(" ");
				char ch[]=in[1].toCharArray();
				char num[]=in[0].toCharArray();
				
				if(num[0]=='-') continue;
				
				if(ch.length==num.length)
				{
					a[ch[0]-'A']=Math.min(a[ch[0]-'A'],num[0]-'0');
				}
				
				for(char c:ch)
				{
					a[c-'A']=Math.min(a[c-'A'],9);
				}
			}
			
			StringBuilder ans = new StringBuilder();
			
			for(int i=0;i<10;++i)
			{
				int closest_index=26,val=26;
				for(int j=0;j<26;++j)
				{
					if(!visited[j])
					{
						if(Math.abs(i-a[j])<val)
						{
							val=Math.abs(i-a[j]);
							closest_index=j;
						}
					}
				}
				
				visited[closest_index]=true;
				ans.append((char)((int)('A')+closest_index));
			}
			
			pw.println("Case #"+t+": "+ans);
		}
		
		
		pw.flush();
		pw.close();
	}
}
