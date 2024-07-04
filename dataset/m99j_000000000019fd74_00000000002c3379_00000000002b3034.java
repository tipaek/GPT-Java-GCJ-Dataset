import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int tc=1;
		while (t>0)
		{	
			//System.out.println(t);
			int n=Integer.parseInt(br.readLine());
			ArrayList<String[]> patterns=new ArrayList<>();
			for (int i=0;i<n;i++)
			{
				String inp[]=br.readLine().split("\\*");
				patterns.add(inp);
				//System.out.println(patterns.get(i));
			}
			
			String ans=patterns.get(0)[1];
			boolean possible=true;
			for (int i=1;i<n;i++)
			{
				
				String curr=patterns.get(i)[1];
				int p=ans.length()-1;
				int q=curr.length()-1;
				//System.out.println(ans+" "+curr);
				while (p>-1 && q>-1)
				{
					if (curr.charAt(q)!=ans.charAt(p))
					{
						possible=false;
						break;
					}
					p--;
					q--;
				}
				if (!possible)
				{
					break;
				}
				if (q>-1)
					ans=curr;
			}
			
			if (!possible)
				ans="*";
			
			System.out.println("Case #"+tc+": "+ans);
			t--;
			tc++;			
		}
	}
}