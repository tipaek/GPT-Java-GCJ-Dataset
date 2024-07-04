import java.util.*;
import java.io.*;
public class Solution {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int tc=1;
		while (t>0)
		{
			String s=br.readLine().trim();
			int closed[]=new int[s.length()];
			int n=s.length();
			int open[]=new int[n];
			int openbrac=0;
			//System.out.println(s);
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<n;i++)
			{
				int x=s.charAt(i)-'0';
				if (openbrac<x)
				{
					for (int j=0;j<x-openbrac;j++)
						sb.append("(");
					openbrac+=x-openbrac;
				}
				else if (openbrac>x)
				{
					for (int j=0;j<openbrac-x;j++)
						sb.append(")");
					openbrac-=openbrac-x;
				}
				sb.append(x+"");
			}
			for (int i=0;i<openbrac;i++)
				sb.append(")");
			System.out.println("Case #"+tc+": "+sb.toString());
			tc++;
			t--;
		}
	}

}
